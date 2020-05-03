<%@page import="java.sql.*" %>
<%
    String merchant_name = (String)session.getAttribute("username");
    String car_name = request.getParameter("car_name");
    String num_cars = "1";
    String merchant_city = "";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar","root","system");
    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs1 = stmt1.executeQuery("select city from merchant where username='"+merchant_name+"'");
    if(rs1.next())
    {
        merchant_city = rs1.getString("city");
    }
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("select * from rental_cars");
    
    rs.moveToInsertRow();
    rs.updateString("merchant_username", merchant_name);
    rs.updateString("car_name", car_name);
    rs.updateString("merchant_city", merchant_city);
    rs.updateString("num_cars", num_cars);
    rs.insertRow();
    response.sendRedirect("dashboard.jsp");
%>    