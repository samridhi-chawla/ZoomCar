<%@page import="java.sql.*"%>
<%
    
String username = request.getParameter("username");
String password = request.getParameter("password");

Class.forName("com.mysql.jdbc.Driver");    
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
//System.out.println("connection amde");
Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
ResultSet rs = stmt.executeQuery("select * from admin_login where username='"+username +"'and password='"+password+"'" );
//System.out.println("query amde");
if(rs.next())
{
    session.setAttribute("admin", username);
    response.sendRedirect("admin_dashboard.jsp");
}
else
    response.sendRedirect("admin_login.jsp?q=Invalid Username or Password");


%>    