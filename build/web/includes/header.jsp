
<%@page import="java.sql.*"%>
<script>
    var xmlhttp_header = new XMLHttpRequest();
    function modal_login()
    {
        var user = document.getElementById("user").value;
        var password = document.getElementById("password").value;
        xmlhttp_header.open("post", "user_login.jsp?username=" + user + "&password=" + password, true);
        xmlhttp_header.onreadystatechange = function ()
        {
            window.location.reload();
        };
        xmlhttp_header.send();
    }
</script>
<%
    String username = (String) session.getAttribute("username");
%>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="../index.html">
                <span><img alt="Brand" src="../logo.jpg" class="img-circle" width="30px" height="30px"></span>
                ZoomCar
            </a>
            <ul class="nav navbar-nav">
                <li class="active"><a href="home.jsp">Home</a></li>
                    <%
                        if (username != null) {

                    %>
                <li><a href="user_bookings.jsp">My Bookings</a></li>
            </ul>

        </div>
        <ul class="nav navbar-nav navbar-right">

            <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=username%> logged in </a></li>

            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                <%
                } else {

                %>
            <li style="cursor: pointer;" data-toggle="modal" data-target="#LoginModal"><a ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                <%                    }

                %>

            <!-- Modal -->
            <div id="LoginModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title text-center">Login</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-vertical">
                                <label id='login_error' style="color: red; size: 1em; font-style: italic"></label>
                                <div class="form-group">
                                    <label for='user'>Enter Username</label>
                                    <input type="text" class="form-control" id='user' name="user"/>
                                </div>
                                <div class="form-group">
                                    <label for='password'>Enter the Password</label>
                                    <input type="password" class="form-control" id='password' name="password"/>
                                </div>
                                <input type="button" class="btn btn-primary btn-lg" onclick="modal_login()" value="Login"/>
                            </form>
                            <label>Don't have a user account? <a href='sign_up.jsp'>Click here.</a></label>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
        </ul>
    </div>
</nav>