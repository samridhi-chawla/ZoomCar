<%@page import="java.sql.*"%>
<%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from users where username='" + username + "' and password='"+password+"'");
                if (rs.next())
                {
                    System.out.println("if worked");
                    session.setAttribute("username", username);
                    
                } 
                else 
                {
                 out.println("Invalid Username or Password");
                }
        %>