
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <div class="container" style="margin-top: 3%;">
            <h1>BOOKING HISTORY</h1>
            <table class="table table-condensed table-bordered table-responsive table-hover">
                <tr>
                    <th>Photo</th>
                    <th>Car</th>
                    <th>Booked From</th>
                    <th>Booked To</th>
                    <th>Billing Id</th>

                </tr>
                <%
                    String user = (String) session.getAttribute("username");  //making a new variable user even if username exists but in header.jsp that ill give error otherwise
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("SELECT bill_id,min(booking_date) as from_date, max(booking_date) as to_date, car_id,cars.car_name, photo from car_booking, rental_cars,cars where car_booking.user='" + user + "' and car_booking.car_id=rental_cars.id and rental_cars.car_name=cars.car_name group by bill_id,car_id,car_booking.p_per_day,user;");

                    while (rs.next()) {
                        String bill_id = rs.getString("bill_id");
                        String from_date = rs.getString("from_date");
                        Date date = rs.getDate("to_date");
                        long td = date.getTime() + 1000 * 24 * 60 * 60;   //this is done so that car_billing table use can be avoided
                        Date to_date = new Date(td);
                        String car_id = rs.getString("car_id");
                        String car_name = rs.getString("car_name");
                        String photo = rs.getString("photo");
                %>
                <!--<a href="view_bill.jsp?bill_id=<%=bill_id%>">-->
                    <tr>
                        <td><img src=".<%=photo%>" class="img-responsive img-thumbnail" style="width: 150px;height: 150px"></td>
                        <td><%=car_name%></td>
                        <td><%=from_date%></td>
                        <td><%=to_date%></td>
                        <td><%=bill_id%></td>

                    </tr>
                <!--</a>-->
                <%
                    }
                %>
            </table>
        </div> 
    </body>
</html>
