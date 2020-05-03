<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <script>
        function go()
        {
            alert("password is admin123");
        }
    </script>
<%
    
Class.forName("com.mysql.jdbc.Driver");    
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
System.out.println("connection amde");
Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
ResultSet rs = stmt.executeQuery("select * from admin_login " );
System.out.println("query amde");
if(rs.next())
{
   String email = rs.getString("email");
   String res = email.substring(0, 3) ;
   String sub = email.substring(2, email.length()-7);
   for(int i = 1;i<sub.length();i++)
       res = res + '*';
   res = res + email.substring(email.length()-7);
   
   %>
   <h3>email will be sent to <%=res%></h3>
   <%    

}

    %>
    
    <input type="button" value='Send Mail' onclick="go()">
    
    