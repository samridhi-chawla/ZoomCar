
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script>

            function update_num_days(from_date) {
                document.getElementById("date_error").innerHTML = "";
                var from = new Date(from_date);
                var to = new Date(document.getElementById("to_date").value);
                if (to.getTime() > from.getTime()) {
                    var diff = Math.round(Math.abs(to.getTime() - from.getTime()) / (1000 * 60 * 60 * 24));
                    document.getElementById("num_days").value = diff;
                    update_tot_amt();
                } else {
                    document.getElementById("date_error").innerHTML = "Return Date must be greater than booking date";
                }
            }
            function update_tot_amt() {
                var price = parseFloat(document.getElementById("p_per_day").value);
                //alert("price "+price);
                var num_days = parseInt(document.getElementById("num_days").value);
                //alert("num_days "+num_days);
                var extra = parseFloat(document.getElementById("extra_charges").value);
                //alert("extra "+extra);
                var tot_amt = price * num_days + extra;
                //alert("tot_amt "+tot_amt);
                document.getElementById("tot_amt").value = tot_amt;
                update_net_amt();
            }
            function update_net_amt() {
                var tot_amt = parseFloat(document.getElementById("tot_amt").value);
                //alert("tot_amt "+tot_amt);
                var taxes = parseFloat(document.getElementById("taxes").value);
                //alert("taxes "+taxes);
                var discount = parseFloat(document.getElementById("discount").value);
                //alert("discount "+discount);
                var net_amt = tot_amt + taxes - discount;
                //alert("net_amt "+net_amt);
                document.getElementById("net_amt").value = net_amt;
            }
        </script>
    </head>
    <body>
        <jsp:include page="admin_header.jsp"/>
        
            <%
            int bill_id = Integer.parseInt(request.getParameter("bill_id"));
            java.util.Date date_of_billing = new java.util.Date();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT car_id,rental_cars.car_name, merchant_username, user, car_booking.p_per_day, to_date,from_date, count(booking_date) as num_days, car_booking.p_per_day*count(booking_date) as tot_amt , cars.photo FROM car_booking,rental_cars,cars,car_billing where car_billing.bill_id='"+bill_id+"' and car_booking.bill_id='"+bill_id+"' and rental_cars.id=car_booking.car_id and cars.car_name=rental_cars.car_name group by car_id;");
            if (rs.next()) {
                String car_id = rs.getString("car_id");
                String car_name = rs.getString("car_name");
                String owner = rs.getString("merchant_username");
                String booked_by = rs.getString("user");
                String p_per_day = rs.getString("p_per_day");
                String from_date = rs.getString("from_date");
                String to_date = rs.getString("to_date");
                String photo = rs.getString("photo");
                String num_days = rs.getString("num_days");
                String tot_amt = rs.getString("tot_amt");

        %>
        <div class="container" style="margin-top: 3%">

            <h1>Bill of <%=booked_by%><span style="float: right;font-size:medium">Dated: <input type="text" value="<%=date_of_billing%>"/></span></h1>

            <form action="bill.jsp?bill_id=<%=bill_id%>" method='post'>
                <div class="row">
                    <div class="col-xs-6">
                        <div class="row">
                            <img src=".<%=photo%>" class="img-responsive img-thumbnail" style="margin-left: 20%"/>
                        </div>
                        <div class="row">
                            <table class="table table-responsive">
                                <tr>
                                    <td><label>Bill Id</label></td>
                                    <td><%=bill_id%></td>
                                </tr>
                                <tr>
                                    <td><label>Car Id</label></td>
                                    <td><%=car_id%></td>
                                </tr>
                                <td><label>Car Name</label></td>
                                <td><%=car_name%></td>
                                <tr>
                                    <td><label>Booked By</label></td>
                                    <td><%=booked_by%></td>
                                </tr>
                                <tr>
                                    <td><label>Owner</label></td>
                                    <td><%=owner%></td>
                                </tr>
                                <tr>
                                    <td><label>Booked From</label></td>
                                    <td><%=from_date%></td>
                                </tr>
                                <tr>
                                    <td><label>Booked To</label></td>
                                    <td><%=to_date%></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="col-xs-6">

                        <table class="table table-responsive">
                            <tr>
                                <td><label>Date of car return</label><label style="color: red;" id='date_error'></label></td>
                                <td><input type="date" class='form-control' id='to_date' name='to_date' value="<%=to_date%>" onchange="update_num_days('<%=from_date%>')"/></td>
                            </tr>
                            <tr>
                                <td><label>Number of Days</label></td>
                                <td><input type="text" class="form-control" id='num_days' value="<%=num_days%>" readonly/></td>
                            </tr>
                            <tr>
                                <td><label>Rent per Day</label></td>
                                <td><input type="text" class="form-control" id='p_per_day' value="<%=p_per_day%>" readonly/></td>
                            </tr>
                            <tr>
                                <td><label>Extra Charges</label></td>
                                <td><input type="number" id='extra_charges' name='extra_charges' value="0" onchange="update_tot_amt()" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td><label>Total Amount</label></td>
                                <td><input type="text" id='tot_amt' name='tot_amt' class="form-control" value="<%=tot_amt%>" readonly/></td>
                            </tr>
                            <tr>
                                <td><label>Remarks</label></td>
                                <td><input type="text" name='remarks' class="form-control"/></td>
                            </tr>
                            <tr>
                                <td><label>Taxes</label></td>
                                <td><input type="number" name="taxes" id='taxes' value="0.0" onchange="update_net_amt()" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td><label>Enter Coupon code(if any)</label></td>
                                <td><input type="text" name='coupon_used' class='form-control'/></td>
                            </tr>
                            <tr>
                                <td><label>Discount</label></td>
                                <td><input type='number' class="form-control" id='discount' name='discount' value="0.0" onchange="update_net_amt()"/></td>
                            </tr>
                            <tr>
                                <td><label>Net Payable Amount</label></td>
                                <td><input type="text" id='net_amt' name='net_amt' class="form-control" value="<%=tot_amt%>" readonly/></td>
                            </tr>
                        </table>

                    </div>
                </div>
                <input type="submit" class="btn btn-lg btn-primary" style="margin-left: 40%" value="Generate Bill">
            </form>
            <%
                }  //if ends
%>
        </div>
    </body>
</html>
