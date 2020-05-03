<%@page import="java.sql.*" %>
<%
    int car_id = Integer.parseInt(request.getParameter("c_id"));
    String merchant_name = (String)session.getAttribute("username");
    String car_name = request.getParameter("car_name");
    String num_cars = request.getParameter("num_cars");
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs1 = stmt1.executeQuery("select * from rental_cars where id='"+car_id+"'");
    if(rs1.next())
    {
        rs1.updateString("car_name", car_name);
        rs1.updateString("num_cars", num_cars);
        rs1.updateRow();
        response.sendRedirect("dashboard.jsp");
    }

%>