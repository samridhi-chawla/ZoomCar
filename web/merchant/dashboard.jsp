
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
            //function for add cars module
            function go(car_type)
            {
                xmlhttp.open("get", "../get_cars?car_type=" + car_type, true);
                xmlhttp.onreadystatechange = set_cars;
                xmlhttp.send();
            }

            function set_cars()
            {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var res = xmlhttp.responseText.split(",");
                    var car_id = res[0];
                    document.getElementById("car_name").innerHTML = res[1];
                }
            }
            //fnctions for add_bike model (had to make different func coz of id conflict)
            function get_bikes(car_type)
            {
                xmlhttp.open("get", "../get_cars?car_type=" + car_type, true);
                xmlhttp.onreadystatechange = set_bikes;
                xmlhttp.send();
            }

            function set_bikes()
            {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var res = xmlhttp.responseText.split(",");
                    var car_id = res[0];
                    document.getElementById("bike_name").innerHTML = res[1];
                }
            }
            /// function for edit car module
            function edit_go(car_type, car_id)
            {
                xmlhttp.open("get", "../get_cars?car_type=" + car_type + "&car_id=" + car_id, true);
                xmlhttp.onreadystatechange = edit_set_cars;
                xmlhttp.send();
            }

            function edit_set_cars()
            {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    var res = xmlhttp.responseText.split(",");
                    var car_id = res[0];
                    document.getElementById("car_name" + car_id).innerHTML = res[1];
                }
            }
            //for add module car
            function go1(car_name)
            {
                xmlhttp.open("get", "../get_car_details?car_name=" + car_name, true);
                xmlhttp.onreadystatechange = get_details;
                xmlhttp.send();
            }
            function get_details()
            {
                // alert(xmlhttp.responseText);
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    var res = xmlhttp.responseText.split(",");
                    var car_id = res[0];
                    var photo = "." + res[1];
                    var maker = res[2];
                    var num_seats = res[3];
                    var car_price = res[4];
                    var p_per_day = res[5];
                    var security = res[6];
                    document.getElementById("d_photo").style.display = "inline";
                    document.getElementById("photo").src = photo;
                    document.getElementById("d_maker").style.display = "inline";
                    document.getElementById("maker").value = maker;
                    document.getElementById("d_num_seats").style.display = "inline";
                    document.getElementById("num_seats").value = num_seats;
                    document.getElementById("d_price").style.display = "inline";
                    document.getElementById("car_price").value = car_price;
                    document.getElementById("d_p_per_day").style.display = "inline";
                    document.getElementById("p_per_day").value = p_per_day;
                    document.getElementById("d_security").style.display = "inline";
                    document.getElementById("security").value = security;

                }
            }
            //add bike 
            function get_bike_details(car_name)
            {
                xmlhttp.open("get", "../get_car_details?car_name=" + car_name, true);
                xmlhttp.onreadystatechange = set_bike_details;
                xmlhttp.send();
            }
            function set_bike_details()
            {
                // alert(xmlhttp.responseText);
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    var res = xmlhttp.responseText.split(",");
                    var car_id = res[0];
                    var photo = "." + res[1];
                    var maker = res[2];
                    var num_seats = res[3];
                    var car_price = res[4];
                    var p_per_day = res[5];
                    var security = res[6];
                    document.getElementById("bike_d_photo").style.display = "inline";
                    document.getElementById("bike_photo").src = photo;
                    document.getElementById("bike_d_maker").style.display = "inline";
                    document.getElementById("bike_maker").value = maker;
                    //document.getElementById("d_num_seats").style.display = "inline";
                    //document.getElementById("num_seats").value = num_seats;
                    document.getElementById("bike_d_price").style.display = "inline";
                    document.getElementById("bike_car_price").value = car_price;
                    document.getElementById("bike_d_p_per_day").style.display = "inline";
                    document.getElementById("bike_p_per_day").value = p_per_day;
                    document.getElementById("bike_d_security").style.display = "inline";
                    document.getElementById("bike_security").value = security;

                }
            }
            //for edit module
            function edit_go1(car_id, car_name)
            {
                xmlhttp.open("get", "../get_car_details?car_id=" + car_id + "&car_name=" + car_name, true);
                xmlhttp.onreadystatechange = get_details_of_edit;
                xmlhttp.send();
            }
            function get_details_of_edit()
            {
                // alert(xmlhttp.responseText);
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    var res = xmlhttp.responseText.split(",");
                    var car_id = res[0];
                    var photo = "." + res[1];
                    var maker = res[2];
                    var p_per_day = res[5];
                    var num_seats = res[3];
                    var car_price = res[4];
                    var security = res[6];
                    document.getElementById("d_photo" + car_id).style.display = "inline";
                    document.getElementById("photo" + car_id).src = photo;
                    document.getElementById("d_maker" + car_id).style.display = "inline";
                    document.getElementById("maker" + car_id).value = maker;
                    document.getElementById("d_num_seats" + car_id).style.display = "inline";
                    document.getElementById("num_seats" + car_id).value = num_seats;
                    document.getElementById("d_price" + car_id).style.display = "inline";
                    document.getElementById("car_price" + car_id).value = car_price;
                    document.getElementById("d_p_per_day" + car_id).style.display = "inline";
                    document.getElementById("p_per_day" + car_id).value = p_per_day;
                    document.getElementById("d_security" + car_id).style.display = "inline";
                    document.getElementById("security" + car_id).value = security;

                }
            }

            function del(car_id, num_cars)
            {
                if (confirm("Are you sure you want to delete " + num_cars + " car?"))
                {
                    window.location.href = "delete_car.jsp?c_id=" + car_id;
                }
            }

        </script>


    </head>
    <body >
        <jsp:include page="merchant_header.jsp"/>

        <div class="container">
            <%@page import="java.sql.*" %>
            <%
                String merchant_username = (String) session.getAttribute("merchant_username");
                if (merchant_username == null) {
                    response.sendRedirect("login.jsp?msg=please login first");
                }
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select status from merchant where username ='" + merchant_username + "'");
                String status = "";
                if (rs1.next()) {
                    status = rs1.getString("status");
                }
                stmt1.close();

            %>

            <div class="jumbotron">
                <h1><%=merchant_username%> Dashboard</h1>

            </div>
            <h4 class="text-right" >Status <%=status%></h4>
            <h1>Manage My Cars</h1>

            <table class="table table-bordered table-striped">
                <tr>
                    <th>S.No</th>
                    <th>Car Photo</th>
                    <th>Car Name</th>
                    <th>No. of Cars</th>
                    <th>Rent Received per Day</th>
                    <th>Security deposit</th>
                    <th colspan="2">Operations</th>
                </tr>

                <%
                    Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs2 = stmt2.executeQuery("select * from rental_cars, cars where rental_cars.car_name= cars.car_name and cars.car_name= ANY (select car_name from rental_cars where merchant_username='" + merchant_username + "')");

                    for (int i = 1; rs2.next(); i++) {
                        int car_id = rs2.getInt("id");
                        String car_name = rs2.getString("car_name");
                        String car_type = rs2.getString("car_type");
                        String photo = rs2.getString("photo");
                        String p_per_day = rs2.getString("p_per_day");
                        String security = rs2.getString("security");
                        String num_cars = rs2.getString("num_cars");
                        String num_seats = rs2.getString("num_seats");
                        String maker = rs2.getString("maker");
                        String car_price = rs2.getString("car_price");
                %>
                <tr>
                    <td><%= i%></td>
                    <td><img src=".<%=photo%>" width="100px" height="100px"/></td>
                    <td><%=car_name%></td>
                    <td><%=num_cars%></td>
                    <td><%=p_per_day%></td>
                    <td><%=security%></td>
                    <td><input type="button" class="btn btn-primary" data-toggle="modal" data-target="#edit_modal<%=car_id%>" value="Edit"/></td>
                    <td><input type="button" class="btn btn-primary" onclick="del('<%=car_id%>', '<%=num_cars%>')" value="Delete"/></td>
                </tr>

                <!------EDIT CAR MODAL STARTS-------->
                <!-- Modal -->
                <div id="edit_modal<%=car_id%>" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Edit <%=car_name%></h4>
                            </div>
                            <div class="modal-body">
                                <form action="edit_merchant_car.jsp?c_id=<%=car_id%>" method="post" class="form-vertical">
                                    <div class="form-group">
                                        <label for="car_type<%=car_id%>">Car Type</label>
                                        <select id="car_type<%=car_id%>" name="car_type" onchange="edit_go(this.value, '<%=car_id%>')" class="form-control" required>
                                            <option selected><%=car_type%></option>
                                            <%
                                                Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                                ResultSet rs3 = stmt3.executeQuery("select distinct car_type from cars where car_type!='" + car_type + "'");

                                                while (rs3.next()) {
                                            %>
                                            <option><%=rs3.getString("car_type")%></option>
                                            <%
                                                }
                                            %>
                                        </select>   
                                    </div>

                                    <div class="form-group" >
                                        <label for="car_name<%=car_id%>">Select Car</label>
                                        <select name="car_name" id="car_name<%=car_id%>" class="form-control" onchange="edit_go1('<%=car_id%>', this.value)" required>
                                            <option><%=car_name%></option>
                                        </select>
                                    </div>
                                    <div id="d_photo<%=car_id%>" style="display:none">
                                        <img src="" id="photo<%=car_id%>" height="200px" width="200px">
                                    </div>
                                    <div class="form-group">
                                        <label for="num_cars<%=car_id%>">Number of cars you want to rent</label>
                                        <input type="text" value="1" readonly class="form-control" id="num_cars">
                                    </div>
                                    <div class="form-group" id="d_maker<%=car_id%>" style="display:none">
                                        <label for="maker<%=car_id%>">Maker of the car</label>
                                        <input type="text" id="maker<%=car_id%>" class="form-control" readonly>
                                    </div>
                                    <div class="form-group" id="d_num_seats<%=car_id%>" style="display:none">
                                        <label for="num_seats<%=car_id%>">Numbe of seats in the car</label>
                                        <input type="text" id="num_seats<%=car_id%>" class="form-control" readonly>
                                    </div>
                                    <div class="form-group" id="d_price<%=car_id%>" style="display:none">
                                        <label for="car_price<%=car_id%>">Market Price of the car</label>
                                        <input type="text" id="car_price<%=car_id%>" class="form-control" readonly>
                                    </div>
                                    <div class="form-group" id="d_p_per_day<%=car_id%>" style="display:none">
                                        <label for="p_per_day<%=car_id%>">Rent per day that will be received for this car while on rent</label>
                                        <input type="text" id="p_per_day<%=car_id%>" class="form-control" readonly>
                                    </div>
                                    <div class="form-group" id="d_security<%=car_id%>" style="display:none">
                                        <label for="security<%=car_id%>">Security deposit made by borrower before renting this car</label>
                                        <input type="text" id="security<%=car_id%>" class="form-control" readonly>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" style="margin-left: 40%" class="btn btn-primary" value="Update Car"/>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
                <!-------EDIT CAR MODAL ENDS-------->

                <%
                    }
                %>

            </table>

            <% 
                if (status.equals("pending")) {
            %>
            <style>
                #add_bike_btn{
                    pointer-events: none;
                    opacity: 0.5;
                }
                #add_car_btn{
                    pointer-events: none;
                    opacity: 0.5;
                }
            </style>
            <h3>You cant perform any operations until your status becomes active</h3>
            <%
                }
            %>
            <!---------ADD NEW CARS-------->

            <div class="btn btn-lg btn-primary" id="add_car_btn" data-toggle="collapse" data-target="#add_form" ><span class="glyphicon glyphicon-plus-sign"></span> Add New Cars</div>

            <div id="add_form" class="collapsing" style="width:60%;margin: 1%">
                <form action="add_merchant_car.jsp" method="post" class="form-vertical">
                    <div class="form-group">
                        <label for="car_type">Car Type</label>
                        <select id="car_type" name="car_type" onchange="go(this.value)" class="form-control" required>
                            <option selected disabled>Select car type</option>
                            <%
                                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs = stmt.executeQuery("select distinct car_type from cars where type='4wheeler'");

                                while (rs.next()) {
                            %>
                            <option><%=rs.getString("car_type")%></option>
                            <%
                                }
                            %>
                        </select>   
                    </div>

                    <div class="form-group" >
                        <label for="car_name">Select Car</label>
                        <select name="car_name" id="car_name" class="form-control" onchange="go1(this.value)" required>
                        </select>
                    </div>
                    <div id="d_photo" style="display:none">
                        <img src="" id="photo" height="200px" width="200px">
                    </div>
                    <div class="form-group">
                        <label for="num_cars">Number of cars you want to rent</label>
                        <input type="text" value="1" id="num_cars" name="num_cars" readonly/>
                    </div>
                    <div class="form-group" id="d_maker" style="display:none">
                        <label for="maker">Maker of the car</label>
                        <input type="text" id="maker" class="form-control" readonly>
                    </div>
                    <div class="form-group" id="d_num_seats" style="display:none">
                        <label for="num_seats">Number of seats in the car</label>
                        <input type="text" id="num_seats" class="form-control" readonly>
                    </div>
                    <div class="form-group" id="d_price" style="display:none">
                        <label for="car_price">Market Price of the car</label>
                        <input type="text" id="car_price" class="form-control" readonly>
                    </div>
                    <div class="form-group" id="d_p_per_day" style="display:none">
                        <label for="p_per_day">Rent per day that will be received for this car while on rent</label>
                        <input type="text" id="p_per_day" class="form-control" readonly>
                    </div>
                    <div class="form-group" id="d_security" style="display:none">
                        <label for="security">Security deposit made by borrower before renting this car</label>
                        <input type="text" id="security" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Add Car"/>
                    </div>
                </form>
            </div>

            <!---------ADD NEW BIKES-------->

            <div class="btn btn-lg btn-primary" id="add_bike_btn" data-toggle="collapse" data-target="#add_bike_form" ><span class="glyphicon glyphicon-plus-sign"></span> Add New Bikes</div>

            <div id="add_bike_form" class="collapsing" style="width:60%;margin: 1%">
                <form action="add_merchant_car.jsp" method="post" class="form-vertical">
                    <div class="form-group">
                        <label for="car_type">Car Type</label>
                        <select id="car_type" name="car_type" onchange="get_bikes(this.value)" class="form-control" required>
                            <option selected disabled>Select Bike type</option>
                            <%
                                Statement stmt4 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs4 = stmt4.executeQuery("select distinct car_type from cars where type='2wheeler'");

                                while (rs4.next()) {
                            %>
                            <option><%=rs4.getString("car_type")%></option>
                            <%
                                }
                            %>
                        </select>   
                    </div>

                    <div class="form-group" >
                        <label for="bike_name">Select Bike</label>
                        <select name="car_name" id="bike_name" class="form-control" onchange="get_bike_details(this.value)" required>
                        </select>
                    </div>
                    <div id="bike_d_photo" style="display:none">
                        <img src="" id="bike_photo" height="200px" width="200px">
                    </div>
                    <div class="form-group">
                        <label>Number of Bikes you want to rent</label>
                        <input type="text" value="1" readonly class="form-control"/>
                    </div>
                    <div class="form-group" id="bike_d_maker" style="display:none">
                        <label for="bike_maker">Maker of the Bike</label>
                        <input type="text" id="bike_maker" class="form-control" readonly>
                    </div>
                    <div class="form-group" id="bike_d_price" style="display:none">
                        <label for="bike_car_price">Market Price of the Bike</label>
                        <input type="text" id="bike_car_price" class="form-control" readonly>
                    </div>
                    <div class="form-group" id="bike_d_p_per_day" style="display:none">
                        <label for="bike_p_per_day">Rent per day that will be received for this Bike while on rent</label>
                        <input type="text" id="bike_p_per_day" class="form-control" readonly>
                    </div>
                    <div class="form-group" id="bike_d_security" style="display:none">
                        <label for="bike_security">Security deposit made by borrower before renting this car</label>
                        <input type="text" id="bike_security" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Add Bike"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
