<%@page import="java.sql.*" %>
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
    <body class="container">

        <!--        <script>
                    var xmlhttp = new XMLHttpRequest();
                    function login(){
                        var username = document.getElementById("username").value;
                        var password = document.getElementById("password").value;
                        xmlhttp.open("post","user_login.jsp?username"+username+"&password="+password,true);
                        xmlhttp.onreadystatechange=function (){
                            document.getElementById("login_error").innerHTML = xmlhttp.responseText;
                            document.getElementById("password").value="";
                           
                        };
                        xmlhttp.send();
                    }
                    
                </script>    
        -->


        <h1 class='text-center'>User Login</h1>
        <%
            String username = (String) session.getAttribute("username");
            if(username!=null){
                response.sendRedirect("home.jsp");
            }
        %>

        <div class="frame">
            <form class="form-vertical" action="../user_login_servlet" method="post">
                <label id='login_error' style="color: red; size: 1em; font-style: italic"></label>
                <div class="form-group">
                    <label for='username'>Enter the username</label>
                    <label id="login_error"></label>
                    <input type="text" class="form-control" id='username' name="username"/>
                </div>
                <div class="form-group">
                    <label for='password'>Enter the username</label>
                    <input type="password" class="form-control" id='password' name="password"/>
                </div>
                <input type="submit" class="btn btn-primary btn-lg" onclick="login()" value="Login"/>
            </form>
            <label>Do Not Have an Account.<a href="sign_up.jsp"> Click Here</a></label>
        </div>
        <%
            String msg = request.getParameter("msg");
            if (msg != null) {
        %>
        <script>
            document.getElementById("login_error").innerHTML = '<%=msg%>';
            document.getElementById("password").value = "";
        </script>
        <%
            }
        %>
    </body>
</html>
