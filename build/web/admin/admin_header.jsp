<%
String admin=(String)session.getAttribute("admin");
%>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <span><img alt="Brand" src="../logo.jpg" class="img-circle" width="30px" height="30px"></span>
                ZoomCar
            </a>
            <ul class="nav navbar-nav">
                <li class="active"><a href="admin_dashboard.jsp">Home</a></li>
                <li><a href="manage_cars.jsp">Manage Cars</a></li>
                <li><a href="manage_bikes.jsp">Manage Bikes</a></li>
                <li><a href="view_merchant.jsp">View Merchants</a></li>
                <li><a href="view_booking.jsp">View Bookings</a></li>
            </ul>

        </div>
        <ul class="nav navbar-nav navbar-right">

            <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=admin%> logged in </a></li>

            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
           
        </ul>
    </div>
</nav>