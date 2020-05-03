


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <style>
            .admin_back{
                background-image: url('../images/admin_back.jpeg');
                background-size: cover;
                opacity: 0.4;
            }
        </style>
    </head>
    <body>
        <jsp:include page="admin_header.jsp"/>
        <div class="container" style="margin-top: 3%">
            <%
                String admin = (String) session.getAttribute("admin");
                if (admin == null) {
                    response.sendRedirect("admin_login.jsp");
                }
            %>

            <div class="">
                <h1>Hello <%=admin%></h1>
                <div class="text-center" style="margin-top: 5%">
                    <a href="manage_cars.jsp"><div class="btn btn-primary btn-lg" style="width: 50%">Manage Cars</div></a><br><br>
                    <a href="manage_bikes.jsp"><div class="btn btn-primary btn-lg" style="width: 50%">Manage Bikes</div></a><br><br>
                    <a href="view_merchant.jsp"><div class="btn btn-primary btn-lg" style="width: 50%">View Merchants</div></a><br><br>
                    <a href="view_booking.jsp"><div class="btn btn-primary btn-lg" style="width: 50%">View Bookings</div></a><br><br>

                </div>

            </div>
        </div>
    </body>
</html>
