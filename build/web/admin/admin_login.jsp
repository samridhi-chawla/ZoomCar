<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type ="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body class="back" >
        
        
        <div class="frame">
            
            <h1 class="text-center">Admin Login</h1>
                <%
                    String admin=(String)session.getAttribute("admin");
                    if(admin!=null){
                        response.sendRedirect("admin_dashboard.jsp");
                    }
                    String q = request.getParameter("q");
                    if(q!=null)
                    {

                        %>
                        <h4><%=q%></h4>


                        <%
                    }

                %>
                
                    <form class="form-vertical" action="check_admin_login.jsp" method="post" >
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

                <a href ="recover_pass.jsp">Recover Admin Password</a>
              
        </div>
    </body>
</html>
