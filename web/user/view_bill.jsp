<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <%
            String bill = request.getParameter("bill_id");
            if (bill != null) {
                int bill_id = Integer.parseInt(bill);
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT car_id,rental_cars.car_name, merchant_username, user, car_booking.p_per_day, to_date,from_date,date_of_billing,extra_charges,tot_amt,net_amt,taxes,remarks,coupon_used,discount, count(booking_date) as num_days, cars.photo FROM car_booking,rental_cars,cars,car_billing where car_billing.bill_id='" + bill_id + "' and car_booking.bill_id='" + bill_id + "' and rental_cars.id=car_booking.car_id and cars.car_name=rental_cars.car_name group by car_id");
                if (rs.next()) {
                    String car_id = rs.getString("car_id");
                    String car_name = rs.getString("car_name");
                    String owner = rs.getString("merchant_username");
                    String booked_by = rs.getString("user");
                    String p_per_day = rs.getString("p_per_day");
                    String from_date = rs.getString("from_date");
                    String to_date = rs.getString("to_date");
                    String date_of_billing = rs.getString("date_of_billing");
                    String photo = rs.getString("photo");
                    String num_days = rs.getString("num_days");
                    String extra_charges = rs.getString("extra_charges");
                    String taxes = rs.getString("taxes");
                    String tot_amt = rs.getString("tot_amt");
                    String net_amt = rs.getString("net_amt");
                    String remarks = rs.getString("remarks");
                    String discount = rs.getString("discount");
                    String coupon_used = rs.getString("coupon_used");
                    

        %>
        <div class="container" style="margin-top: 3%">

            <h1>Bill of <%=booked_by%><span style="float: right;font-size:medium">Dated: <%=date_of_billing%></span></h1>

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
                        </table>
                    </div>
                </div>
                <div class="col-xs-6">

                    <table class="table table-responsive">
                        <tr>
                            <td><label>Booked From</label></td>
                            <td><%=from_date%></td>
                        </tr>
                        <tr>
                            <td><label>Date of car return</label><label style="color: red;" id='date_error'></label></td>
                            <td><%=to_date%></td>
                        </tr>
                        <tr>
                            <td><label>Number of Days</label></td>
                            <td><%=num_days%></td>
                        </tr>
                        <tr>
                            <td><label>Rent per Day</label></td>
                            <td><%=p_per_day%></td>
                        </tr>
                        <tr>
                            <td><label>Extra Charges</label></td>
                            <td><%=extra_charges%></td>
                        </tr>
                        <tr>
                            <td><label>Total Amount</label></td>
                            <td><%=tot_amt%></td>
                        </tr>
                        <tr>
                            <td><label>Remarks</label></td>
                            <td><%=remarks%></td>
                        </tr>
                        <tr>
                            <td><label>Taxes</label></td>
                            <td><%=taxes%></td>
                        </tr>
                        <tr>
                            <td><label>Coupon code used</label></td>
                            <td><%=coupon_used%></td>
                        </tr>
                        <tr>
                            <td><label>Discount</label></td>
                            <td><%=discount%></td>
                        </tr>
                        <tr>
                            <td><label>Net Payable Amount</label></td>
                            <td><%=net_amt%></td>
                        </tr>
                    </table>

                </div>
            </div>
            <%
                    }  //if ends

                } else {
                    response.sendRedirect("home.jsp");
                }
            %>
        </div>
    </body>
</html>
