
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="admin_header.jsp"/>
        <div class="container">
        <div class="jumbotron"><h1 class="text-center">Merchants</h1></div>
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
            //System.out.println("connection amde");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from merchant where status='pending'");
            //System.out.println("query amde");

        %>
        <table class="table table-bordered table-responsive table-hover table-striped">
            <caption class="caption">Merchants with Status Pending</caption>
            <tr>
                <th>Photo</th>
                <th>Merchant Name</th>
                <th>Username</th>
                <th>Password</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Mobile number</th>
                <th>Email</th>
                <th>Status</th>
                <th></th>
                <!--<th>Delete</th>-->

            </tr>   

            <%                    while (rs.next()) {
                    String name = rs.getString("username");
            %>
            <tr>
                <td>
                    <img src='../<%=rs.getString("photo")%>' width="100px" height="100px"/>
                </td>
                <td>
                    <%=rs.getString("name")%>
                </td>
                <td>
                    <%=name%>
                </td>
                <td type="password">
                    <%=rs.getString("password")%>
                </td>
                <td>
                    <%=rs.getString("address")%>
                </td>
                <td>
                    <%=rs.getString("city")%>
                </td>
                <td>
                    <%=rs.getString("state")%>
                </td>
                <td>
                    <%=rs.getString("phone")%>
                </td>
                <td>
                    <%=rs.getString("email")%>
                </td>
                <td>
                    <%=rs.getString("status")%>
                </td>
                <td>
                    <a href="activate_merchant.jsp?name=<%=name%>&q=activate"><div class="btn btn-primary">Activate</div></a>
                </td>
            </tr>
            <%
                }
            %>

        </table>    
        <%
            ResultSet rs1 = stmt.executeQuery("select * from merchant where status='active'");
            //System.out.println("query amde");

        %>
        <table class="table table-bordered table-responsive table-hover table-striped">
            <caption class="caption">Merchants with Status Active</caption>
            <tr>
                <th>Photo</th>
                <th>Merchant Name</th>
                <th>Username</th>
                <th>Password</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Mobile number</th>
                <th>Email</th>
                <th>Status</th>
                <th></th>
                <!--<th>Delete</th>-->

            </tr>   

            <%                    
                while (rs1.next()) {
                    String name = rs1.getString("username");
            %>
            <tr>
                <td>
                    <img src='../<%=rs1.getString("photo")%>' width="100px" height="100px"/>
                </td>
                <td>
                    <%=rs1.getString("name")%>
                </td>
                <td>
                    <%=name%>
                </td>
                <td type="password">
                    <%=rs1.getString("password")%>
                </td>
                <td>
                    <%=rs1.getString("address")%>
                </td>
                <td>
                    <%=rs1.getString("city")%>
                </td>
                <td>
                    <%=rs1.getString("state")%>
                </td>
                <td>
                    <%=rs1.getString("phone")%>
                </td>
                <td>
                    <%=rs1.getString("email")%>
                </td>
                <td>
                    <%=rs1.getString("status")%>
                </td>
                <td>
                    <a href="activate_merchant.jsp?name=<%=name%>&q=deactivate"><div class="btn btn-primary">Deactivate</div></a>
                </td>
            </tr>
            <%
                }
            %>

        </table>    
        </div>
    </body>
</html>
