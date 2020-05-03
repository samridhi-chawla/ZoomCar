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
        <script>
            var xmlhttp = new XMLHttpRequest();
            function getbookings()
            {
                var month = document.getElementById("month").value; 
                xmlhttp.open("get", "get_bookings.jsp?month=" + month, true);
                xmlhttp.onreadystatechange = function () {
                    document.getElementById("set_bookings").innerHTML = xmlhttp.responseText;
                };
                xmlhttp.send();
            }
            function generate_bill(bill_id) {
                window.location.href = "generate_bill.jsp?bill_id=" + bill_id;
            }
            function view_bill(bill_id) {
                window.location.href = "../user/view_bill.jsp?bill_id=" + bill_id;
            }

        </script>    
    </head>
    <body>
        <jsp:include page="admin_header.jsp"/>
        <div class="container">
            <div class="jumbotron"><h2 class="text-center">View Bookings</h2></div>
            <div class="form-group">
                <div class="col-xs-4"><label for="month">Select the month you want to view the bookings of</label></div>
                <div class="col-xs-3"><input type="month" class="form-control" id="month" name="month" onchange="getbookings()"/></div>
            </div>
            <br>
            <div id="set_bookings" class="row" style="margin-top: 15px;"></div>
        </div>
    </body>
</html>
