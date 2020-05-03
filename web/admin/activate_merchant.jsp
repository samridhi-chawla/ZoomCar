<%@page import="java.sql.*" %>
<%
    String username = request.getParameter("name");
    String q = request.getParameter("q");
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("select * from merchant where username='" + username + "'");

    if (rs.next()) {
        if (q.equals("activate")) {
            rs.updateString("status", "active");
            rs.updateRow();
            response.sendRedirect("view_merchant.jsp");
        }
        else if(q.equals("deactivate"))
        {
             rs.updateString("status", "pending");
            rs.updateRow();
            response.sendRedirect("view_merchant.jsp");
        }
    }
%>