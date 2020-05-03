
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page= "admin_header.jsp" />
        <div class="container" style="margin-top: 5%">
            <h1>Your payment is successful</h1>
            <a href="view_booking.jsp"><h2><span class="glyphicon glyphicon-backward"></span>Go Back</h2></a>
            
        </div>
    </body>
</html>
