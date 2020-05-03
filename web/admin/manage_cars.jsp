<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-MangeCars</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>

        <%
            String admin = (String)session.getAttribute("admin");
            String msg = request.getParameter("msg");
            if(admin==null){
                response.sendRedirect("admin_login.jsp");
            }
             if (msg != null) {
        %>

        <script>
            alert(<%=msg%>);
        </script>
        <%
            }
        %>
        <script>
            function cal_security(price)
            {
                document.getElementById("security").value = 0.01 * price;
               
            }


        </script>
    </head>
    <body>
        <jsp:include page="admin_header.jsp"/>
        <div class="container" bgcolor="white">
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
                function del(name)
                {
                    if (confirm("Are you sure u want to delete " + name))
                    {
                        window.location.href = "../del_car?name=" + name;
                    }

                }
                function go()
                {   
                    if(document.getElementById('add_form').style.visibility=="hidden")
                    {
                        document.getElementById('add_form').style.visibility="visible";
                        document.getElementById('add_btn').className="glyphicon glyphicon-minus-sign";
                    }
                    else if(document.getElementById('add_form').style.visibility=="visible")
                    {
                        document.getElementById('add_form').style.visibility="hidden";
                        document.getElementById('add_btn').className="glyphicon glyphicon-plus-sign";
                    }
                }
            </script>

            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
                //System.out.println("connection amde");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from cars where type='4wheeler'");
                //System.out.println("query amde");

    
            %>


            <div class="jumbotron">
                <h1 class="text-center">Manage Cars</h1>
            </div>
            
            <table class="table table-bordered table-responsive table-hover table-striped">
                <tr>
                    <th>Photo</th>
                    <th>Car Name</th>
                    <th>Maker</th>
                    <th>No. of Seats</th>
                    <th>Car Type</th>
                    <th>Price</th>
                    <th>Price per Day</th>
                    <th>Security</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>   

                <%                    
                    while (rs.next()) {
                        String name = rs.getString("car_name");
                %>
                <tr>
                    <td>
                        <img src='../<%=rs.getString("photo")%>' width="150px" height="100px"/>
                    </td>
                    <td>
                        <%=name%>
                    </td>
                    <td>
                        <%=rs.getString("maker")%>
                    </td>
                    <td>
                        <%=rs.getString("num_seats")%>
                    </td>
                    <td>
                        <%=rs.getString("car_type")%>
                    </td>
                    <td>
                        <%=rs.getString("car_price")%>
                    </td>
                    <td>
                        <%=rs.getString("p_per_day")%>
                    </td>
                    <td>
                        <%=rs.getString("security")%>
                    </td>
                    <td>
                        <a href="edit_car.jsp?name=<%=name%>"><div class="btn btn-primary">Edit</div></a>
                    </td>
                    <td>
                        <input type="button" class="btn btn-primary" id="<%=name%>" onclick="del(this.id)" value="Delete">
                    </td>
                </tr>
                <%
                    }
                %>

            </table>    
                
            <div class="btn btn-lg btn-primary"  onclick="go()"><span id="add_btn" class="glyphicon glyphicon-plus-sign"></span> Add New Car Category</div>
            
            <div  id="add_form" style="visibility:hidden; width: 70%;" >
                <h2 class="text-center">Add New Car Category</h2>
                <form class="form-vertical" action="../add_car" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="car_name">Car Name</label>
                        <input type = "text" name ="car_name" class="form-control"  placeholder="Enter Name of the car" required="">
                    </div>
                    <div class="form-group">
                        <label for="maker">Maker</label>
                        <input type = "text" id="maker" class="form-control" name ="maker" placeholder="Enter the name of the Maker" required="">
                    </div>
                    <div class="form-group">
                        <label for="photo">Photo</label>
                        <img src="" id="img" style="width: 150px;height: 100px;">
                        <input type = "file" id="photo" name ="photo" onchange="readandpreview(this, 'img')" required>

                    </div>
                    <div class="form-group">
                        <label for="num_seats">Number of Seats</label>
                        <input type = "number" id="num_seats" class="form-control" name ="num_seats" placeholder="Enter number of seats" required="">
                    </div>
                    <div class="form-group">
                        <label for="car_type">Car Type</label>
                        <input type = "text" id="car_type" class="form-control" name ="car_type" placeholder="Enter Car type" required="">
                    </div>
                    <div class="form-group">
                        <label for="car_price">Car Price</label>
                        <input type = "number" id="car_price" class="form-control" name ="car_price" onchange="cal_security(this.value)" placeholder="Enter price of the car in market" required="">
                    </div>
                    <div class="form-group">
                        <label for="p_per_day">Price per Day</label>
                        <input type = "number" id="p_per_day" class="form-control" name ="p_per_day" placeholder="Enter price of the car per day when rented" required="">
                    </div>
                    <div class="form-group">
                        <label for="security">Security</label>
                        <input type = "text" id="security" class="form-control" name ="security" value="1000"readonly placeholder="The security to be deposited prier to hire" >
                    </div>
                    <!--            <div class="form-group">
                                    <label for="username"> Enter Username</label>
                                    <input type = "text" id="username" class="form-control" name ="username" placeholder="Enter Username" required="">
                                </div>-->
                    <div class="form-group">

                        <input type = "submit" class="btn btn-lg btn-primary" style="margin-left: 40%" class="form-control" name ="username">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
