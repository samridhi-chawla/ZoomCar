
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Sign Up</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <%
    String msg = request.getParameter("msg");
    if(msg!=null)
    {
        %>
        <script>
            alert("<%=msg%>");
            </script>
        <%
    }
    %>
    <script>
        function go()
        {
            if(document.getElementById("password").value==document.getElementById("cp").value)
            {
                return true;
            }
            else 
            {   
                document.getElementById("cp_error").innerHTML="**Password and Confirm Password do not match";
                document.getElementById("cp").value="";
                return false;
            }
        }
        var xmlhttp = new XMLHttpRequest();
        function check_unique()
        {   
            var name = document.getElementById("username").value;
            xmlhttp.open("get","../check_unique_user?name="+name,true);
            xmlhttp.onreadystatechange=checked;
            xmlhttp.send();
        }
        function checked()
        {
            if(xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("username_error").innerHTML=xmlhttp.responseText;
            }
        }
        </script>
    <body class="container">
        <h1 class="text-center">User Sign Up</h1>
        <div class="frame">
            <form class="form-vertical" action="user_signup.jsp" method="post" onsubmit="return go()">
                <div class="form-group">
                    <label for="username">Choose a unique username</label>
                    <label id="username_error"></label>
                    <input type="text" class="form-control" id="username" name="username" onblur="check_unique()">
                </div>
                <div class="form-group">
                    <label for="email">Enter your email</label>
                    <input type="email" id="email" name="email" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="phone_no">Enter your 10 digit mobile number</label>
                    <input type="text" id="phone_no" name="phone_no" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Enter Password</label>
                    <input type="password" class="form-control" id="password" name="password"/>
                </div>
                <div class="form-group">
                    <label for="cp">Re-Enter Password</label>
                    <label id="cp_error" style="color:red"></label>
                    <input type="password" id="cp" class="form-control" />
                </div>
                <input type="submit" class="btn btn-primary btn-lg" value="Sign_up"/>
            </form>
            
        </div>
    </body>
</html>
