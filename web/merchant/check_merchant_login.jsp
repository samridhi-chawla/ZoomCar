<%@page import="java.sql.*" %>
<%
    String username = request.getParameter("username").trim();
    String password = request.getParameter("password").trim();
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("select * from merchant where username='" + username + "' and password='" + password + "'");
    if (rs.next()) 
    {
        session.setAttribute("merchant_username", username);
        response.sendRedirect("dashboard.jsp");
    }
    else
    {
        response.sendRedirect("login.jsp?msg=Invalid username or password");
    }
%>