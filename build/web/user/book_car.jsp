
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <script>

            var xmlhttp = new XMLHttpRequest();

            function set_city(city) {
                xmlhttp.open("post", "../set_city_session?city=" + city, true);
                xmlhttp.onreadystatechange = function () {
                    window.location.href = "home.jsp?msg=Choose the car again from the city from where the ride is going to start";
                };
                xmlhttp.send();
            }

            function enable_return()
            {
                document.getElementById("date_return").removeAttribute("disabled");
                document.getElementById("error").innerHTML = "";
            }
            function days_between() {

                var date_issue = document.getElementById("date_issue").value;
                var date_return = document.getElementById("date_return").value;
                if (date_issue != "" && date_return != "")
                {
                    //var res=date_issue.
                    var date1 = new Date(date_issue);
                    var date2 = new Date(date_return);

                    // The number of milliseconds in one day
                    var ONE_DAY = 1000 * 60 * 60 * 24;

                    // Convert both dates to milliseconds
                    var date1_ms = date1.getTime();
                    var date2_ms = date2.getTime();
                    document.getElementById("error").innerHTML= "";
                    if (date2_ms < date1_ms)
                    {
                        document.getElementById("error").innerHTML = "Date of return has to be more than that of issue";
                        return;
                    }
                    // Calculate the difference in milliseconds
                    var difference_ms = Math.abs(date2_ms - date1_ms);


                    // Convert back to days and return
                    document.getElementById("num_days").value = Math.round(difference_ms / ONE_DAY);
                    cal_amt();
                }   //if ends
            }
            function cal_amt()
            {
                var num_days = parseInt(document.getElementById("num_days").value);
                var p_per_day = parseInt(document.getElementById("p_per_day").value);
                var security = parseInt(document.getElementById("security").value);

                document.getElementById("tot_amt").value = num_days * p_per_day + security;
            }
        </script>

        <div class="container" style="margin-top: 3%">
            <%
                java.sql.Date today = new java.sql.Date((new java.util.Date()).getTime());
                String username = (String) session.getAttribute("username");
                if (username == null) {
                    response.sendRedirect("login.jsp");
                }
                String session_city = (String) session.getAttribute("city");
            %>
            <h1>Welcome <%=username%></h1><a href="logout.jsp"><span style="float: right" >Logout</span></a>
            <%
                String c_id = request.getParameter("c_id");
                int car_id = 0;
                if (c_id == null) {
                    response.sendRedirect("home.jsp");
                } else {
                    car_id = Integer.parseInt(c_id);
                }
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from cars,rental_cars where rental_cars.car_name=cars.car_name and rental_cars.id='" + car_id + "'");
                if (rs.next()) {
                    String car_name = rs.getString("car_name");
                    String car_type = rs.getString("car_type");
                    String maker = rs.getString("maker");
                    String photo = rs.getString("photo");
                    String num_seats = rs.getString("num_seats");
                    String p_per_day = rs.getString("p_per_day");
                    String security = rs.getString("security");
                    String merchant_username = rs.getString("merchant_username");
                    String num_cars = rs.getString("num_cars");


            %>

            <div class="row" style="background-color: whitesmoke; border-radius: 10px">
                <div class="col-md-6">
                    <div class="row">
                        <img src=".<%=photo%>" class="img-responsive img-thumbnail" style="margin-left: 20%"/>
                    </div>
                    <div class="row">
                        <table class="table table-responsive">
                            <tr>
                                <td><label>Car</label></td>
                                <td><%=car_name%></td>
                            </tr>
                            <tr>
                                <td><label>Car Type</label></td>
                                <td><%=car_type%></td>
                            </tr>
                            <tr>
                                <td><label>Maker</label></td>
                                <td><%=maker%></td>
                            </tr>
                            <tr>
                                <td><label>Number of seats</label></td>
                                <td><%=num_seats%></td>
                            </tr>
                        </table>

                    </div>
                </div>

                <div class="col-md-6">
                    <form action="final_booking.jsp?c_id=<%=car_id%>" method="post" >
                        <table class="table table-responsive" >
                            <tr>
                                <td><label>From</label></td>
                                <td>
                                    <select onchange="set_city(this.value)" name="from" class="form-control">
                                        <option><%=session_city%></option>
                                        <%
                                            Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                            ResultSet rs1 = stmt1.executeQuery("select distinct city from merchant where city!='" + session_city + "'");
                                            while (rs1.next()) {
                                        %>
                                        <option><%=rs1.getString("city")%></option>
                                        <%
                                            }
                                            stmt1.close();
                                        %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="to">Destination</label></td>
                                <td>
                                    <input type='text' name='to' id='to' name="to" class="form-control"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="date_issue">Date of car issue</label><label style="color:  blue">(Car will be issued At 08:00 A.M)</label>
                                </td>
                                <td>
                                    <input type="date" class="form-control" min="<%=today%>" id="date_issue" name="date_issue" required onchange="enable_return()"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="date_return">Date of car return</label><label style="color:  blue">(Car has to be returned By 08:00 A.M on)</label>
                                    <label id='error' style="color: red"></label>
                                </td>
                                <td>
                                    <input type="date" class="form-control" id="date_return" name="date_return" required disabled onchange="days_between()"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label for="num_days">Number of days</label></td>
                                <td><input type="text" class="form-control" id="num_days" name="num_days" readonly required/></td>
                            </tr>
                            <tr>
                                <td><label for="p_per_day">Rent per day</label></td>
                                <td><input type="text" id="p_per_day" class="form-control" name="p_per_day" value="<%=p_per_day%>" readonly/></td>
                            </tr>
                            <tr>
                                <td><label for="security">Security to be deposited prier to ride</label></td>
                                <td><input type="text" id="security" class="form-control" name="security" value="<%=security%>" readonly/></td>
                            </tr>
                            <tr>
                                <td><label for="tot_amt">Total Amount</label></td>
                                <td><input type="text" id="tot_amt" class="form-control"name="tot_amt" readonly/></td>
                            </tr>

                        </table>
                </div>
            </div>
            <input type="submit" class="btn btn-lg btn-primary" value="Book" style="margin-left: 40%"/>       
        </form>
        <%
            }
        %> 

    </div>

</body>
</html>
