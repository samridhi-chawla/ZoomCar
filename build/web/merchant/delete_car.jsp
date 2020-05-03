<%@page import="java.sql.*" %>
<%
    int car_id = Integer.parseInt(request.getParameter("c_id"));
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs1 = stmt1.executeQuery("select * from rental_cars where id='"+car_id+"'");
    if(rs1.next())
    {
        rs1.deleteRow();
        response.sendRedirect("dashboard.jsp");
    }

%>