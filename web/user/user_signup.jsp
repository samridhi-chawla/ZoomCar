<%@page import="java.sql.*" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String phone_no = request.getParameter("phone_no");
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("select * from users where username='" + username + "'");
    if(rs.next())
        {
            response.sendRedirect("sign_up.jsp?msg=Username already exists. Please try with some other username.");
        }
    else
    {
        rs.moveToInsertRow();
        rs.updateString("username", username);
        rs.updateString("password", password);
        rs.updateString("email", email);
        rs.updateString("phone_no", phone_no);
        rs.insertRow();
        response.sendRedirect("login.jsp");
    }
%>
