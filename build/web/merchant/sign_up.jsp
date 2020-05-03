
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script>

            function readandpreview(fileobj, imageid)
            {
                var firstfile = fileobj.files[0];

                var reader = new FileReader();

                //alert("File name: " + firstfile.name);
                // alert("File size: " + firstfile.size);

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
                if (document.getElementById("password").value == document.getElementById("cp").value)
                {
                    return true;
                } else
                {
                    document.getElementById("cp_error").innerHTML = "**Password and Confirm Password does not match";
                    document.getElementById("cp").value = "";
                    return false;
                }
            }
        </script>    

    </head>
    <body class="container">
        <div class="frame">
            <h2 class="text-center">Merchant Signup</h2>
            <form class="form-vertical" action="../merchant_signup" method="post" enctype="multipart/form-data" onsubmit="return go()">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type = "text" name ="username" class="form-control"  placeholder="Choose a unique username " onblur="validate()" required="">
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type = "text" id="name" class="form-control" name ="name" placeholder="Enter your full name " required="">
                </div>
                <div class="form-group">
                    <label for="photo">Photo</label>
                    <img src="" id="img" style="width: 100px;height: 100px;">
                    <input type = "file" id="photo" name ="photo" onchange="readandpreview(this, 'img')" required>

                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type = "text" id="address" class="form-control" name ="address" placeholder="Enter your permanent residence address" required="">
                </div>
                <div class="form-group">
                    <label for="city">City</label>
                    <input type = "text" id="city" class="form-control" name ="city" placeholder="Enter your city" required="">
                </div>
                <div class="form-group">
                    <label for="state">State</label>
                    <input type = "text" id="state" class="form-control" name ="state" placeholder="Enter your state" required="">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type = "text" id="email" class="form-control" name ="email" placeholder="Enter email" required="">
                </div>
                <div class="form-group">
                    <label for="phone">Mobile number</label>
                    <input type = "text" id="phone" class="form-control" name ="phone"  placeholder="Enter your mobile number" required="">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type = "password" id="password" class="form-control" name ="password" placeholder="Enter password" required="">
                </div>
                <div class="form-group">
                    <label for="cp">Confirm Password</label>
                    <label id="cp_error" class="label-danger"></label>
                    <input type = "password" id="cp" class="form-control" placeholder="Re-enter your password" >
                </div>
                <div class="form-group">
                    <input type = "submit" class="btn btn-lg btn-primary" style="margin-left: 40%" class="form-control">
                </div>
            </form>
        </div>

    </body>
</html>
