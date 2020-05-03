<%@page import="java.sql.*"%>
<%
    String month = request.getParameter("month");
    System.out.println(month);
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("SELECT car_id, user,p_per_day,car_name,car_booking.bill_id, merchant_username, from_date , to_date, count(booking_date) as num_days, p_per_day*count(booking_date) as tot_amt FROM car_booking, rental_cars,car_billing where car_booking.booking_date like '%" + month + "%' and date_of_billing is null and car_booking.car_id=rental_cars.id and car_booking.bill_id=car_billing.bill_id group by car_id,user,p_per_day,merchant_username");
%>
<h3>Cars on Ride</h3>

<table class='table table-condensed table-responsive'>
    <th>Bill ID</th>
    <th>Owner's Name</th>
    <th>Car ID</th>
    <th>Car Name</th>
    <th>Booked By</th>
    <th>Date of Booking</th>
    <th>Date of Return</th>
    <th>Number of days</th>
    <th>Price per Day</th>
    <th>Total Amt.</th>
    <th>Operations</th>
        <%
            while (rs.next()) {
                System.out.println("inside rs ");
                String bill_id = rs.getString("bill_id");
                String owner = rs.getString("merchant_username");
                int car_id = rs.getInt("car_id");
                String car_name = rs.getString("car_name");
                String user = rs.getString("user");
                String from_date = rs.getString("from_date");
                String to_date = rs.getString("to_date");
                String num_days = rs.getString("num_days");
                String p_per_day = rs.getString("p_per_day");
                String tot_amt = rs.getString("tot_amt");
        %>

    <tr>
        <td><%=bill_id%></td>
        <td><%=owner%></td>
        <td><%=car_id%></td>
        <td><%=car_name%></td>
        <td><%=user%></td>
        <td><%=from_date%></td>
        <td><%=to_date%></td>
        <td><%=num_days%></td>
        <td><%=p_per_day%></td>
        <td><%=tot_amt%></td>
        <td><input type='button' class='btn btn-sm btn-primary' onclick="generate_bill('<%=bill_id%>')" value='Generate Bill'></td>
    </tr>
    <%
        }
        stmt.close();
    %>
</table>
<%
    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs1 = stmt1.executeQuery("SELECT car_id, user,p_per_day,car_name,car_booking.bill_id, merchant_username, from_date , to_date, count(booking_date) as num_days, p_per_day*count(booking_date) as tot_amt FROM car_booking, rental_cars,car_billing where car_booking.booking_date like '%" + month + "%' and date_of_billing is not null and car_booking.car_id=rental_cars.id and car_booking.bill_id=car_billing.bill_id group by car_id,user,p_per_day,merchant_username");
%>
<h3 style="margin-top: 15px;">Cars returned and billed</h3>
<table class="table table-condensed table-responsive">
    <th>Bill ID</th>
    <th>Owner's Name</th>
    <th>Car ID</th>
    <th>Car Name</th>
    <th>Booked By</th>
    <th>Date of Booking</th>
    <th>Date of Return</th>
    <th>Number of days</th>
    <th>Price per Day</th>
    <th>Total Amt.</th>
    <th>Operations</th>
        <%
            while (rs1.next()) {
                System.out.println("inside rs1 ");
                String bill_id = rs1.getString("bill_id");
                String owner = rs1.getString("merchant_username");
                int car_id = rs1.getInt("car_id");
                String car_name = rs1.getString("car_name");
                String user = rs1.getString("user");
                String from_date = rs1.getString("from_date");
                String to_date = rs1.getString("to_date");
                String num_days = rs1.getString("num_days");
                String p_per_day = rs1.getString("p_per_day");
                String tot_amt = rs1.getString("tot_amt");

        %>
    <tr>
        <td><%=bill_id%></td>
        <td><%=owner%></td>
        <td><%=car_id%></td>
        <td><%=car_name%></td>
        <td><%=user%></td>
        <td><%=from_date%></td>
        <td><%=to_date%></td>
        <td><%=num_days%></td>
        <td><%=p_per_day%></td>
        <td><%=tot_amt%></td>
        <td><input type='button' class='btn btn-sm btn-primary' onclick="view_bill('<%=bill_id%>')" value='View Bill'></td>
    </tr>
    <%
        }
        stmt1.close();
    %>
</table>
<%
    Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs2 = stmt2.executeQuery("SELECT sum(net_amt) as monthly_revenue FROM car_billing where date_of_booking like '%" + month + "%';");
    if (rs2.next()) {
        String monthly_revenue = rs2.getString("monthly_revenue");
        // if there were no bookings this string monthly_revenue will have value =null and the next line double conversion will throw number format exception ,,handle it
        double comm=0.0;
        if (monthly_revenue != null) {
             comm = 0.1 * Integer.parseInt(monthly_revenue);
        }
%>
<div style="margin-top: 30px">
    <label>Total Revenue generated of <%=month%> is: </label><%=monthly_revenue%><br>
    <label>Our Commission: </label><%=comm%>
</div>
<%
    }

%>