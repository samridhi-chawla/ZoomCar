
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body class="back" >
        <div class="frame">
            <h1 class="text-center">Merchant Login</h1>
            <%
                String msg = request.getParameter("q");
                if (msg != null) {

            %>
            <h4 style="color:red"><%=msg%></h4>


            <%
                }

            %>

            <form class="form-vertical" action="check_merchant_login.jsp" method="post" >
                <div class="form-group">
                    <label for="username"> Enter Username</label>
                    <input type = "text" id="username" class="form-control" name ="username" placeholder="Enter Username" required="">
                </div>
                <div class="form-group">
                    <label for=password"> Enter Password </label>
                    <input type = "password" id="password" class="form-control" name ="password" placeholder="Enter Password" required="">
                </div>    
                <input class="form-control btn btn-sm btn-primary" type = "submit" value="Login">
            </form>            

            <label>Don't Have A Merchant Account. <a href ="sign_up.jsp">Click Here To Sign Up.</a></label>

        </div>
    </body>
</html>
