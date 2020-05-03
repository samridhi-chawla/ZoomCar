<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-MangeCars</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>

    </head>
        
<script>

    function readandpreview(fileobj, imageid)
    {
        var firstfile = fileobj.files[0];

        var reader = new FileReader();

        reader.onload = (function (f)
        {
            return function read12(e)
            {
                document.getElementById(imageid).src = e.target.result;
            };
        })(firstfile);


        reader.readAsDataURL(firstfile);
    }
    function go()
    {
        document.getElementById("photo").style.display="inherit";
        document.getElementById("img").src="";
        document.getElementById("photo").required="required";
        
    }
</script>
<%
    String car_name = request.getParameter("name");
    if(car_name == null){
        response.sendRedirect("manage_cars.jsp");
    }
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("select * from cars where car_name='" + car_name + "'");
    if (rs.next()) {
        String maker = rs.getString("maker");
        String photo = rs.getString("photo");
        String num_seats = rs.getString("num_seats");
        String car_type = rs.getString("car_type");
        String car_price = rs.getString("car_price");
        String p_per_day = rs.getString("p_per_day");
        String security = rs.getString("security");


%>

<div class="frame" id="add_form" >
    <h2 class="text-center">Edit Car Category</h2>
    <form class="form-vertical" action="../edit_car?name=<%=request.getParameter("name")%>" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="car_name">Car Name</label>
            <input type = "text" name ="car_name" class="form-control"  value="<%=car_name%>" required="">
        </div>
        <div class="form-group">
            <label for="maker">Maker</label>
            <input type = "text" id="maker" class="form-control" name ="maker" value="<%=maker%>" required="">
        </div>
        <div class="form-group">
            <label for="photo">Photo</label>
            <img src="../<%=photo%>" id="img" style="width: 100px;height: 100px;">
            <input type="radio" name="img_change" id="r1" value="false" checked><label for='r1'> Dont Want to change the image</label>
            <input type="radio" name="img_change" id="r2" value="true" onchange="go()"><label for="r2">Want to change the image</label>
            <input type = "file" id="photo" name ="photo" style="display: none" onchange="readandpreview(this, 'img')" >

        </div>
        <div class="form-group">
            <label for="num_seats">Number of Seats</label>
            <input type = "text" id="num_seats" class="form-control" name ="num_seats" value="<%=num_seats%>" required="">
        </div>
        <div class="form-group">
            <label for="car_type">Car Type</label>
            <input type = "text" id="car_type" class="form-control" name ="car_type" value="<%=car_type%>" required="">
        </div>
        <div class="form-group">
            <label for="car_price">Car Price</label>
            <input type = "text" id="car_price" class="form-control" name ="car_price" onkeyup="cal_security(this.value)" value="<%=car_price%>" required="">
        </div>
        <div class="form-group">
            <label for="p_per_day">Price per Day</label>
            <input type = "text" id="p_per_day" class="form-control" name ="p_per_day" value="<%=p_per_day%>" required="">
        </div>
        <div class="form-group">
            <label for="security">Security</label>
            <input type = "text" id="security" class="form-control" name ="security" value="1000"readonly value="<%=security%>" >
        </div>
        <div class="form-group">

            <input type = "submit" class="btn btn-lg btn-primary" style="margin-left: 40%" class="form-control" >
        </div>
    </form>
    <%
        }
else
{
out.println("gadbad");
}
    %>

</div>