
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <title>User Dashboard</title>
        <style>
            .footer{
                background-color: black;
                height: 50px;
                margin-bottom: 0px;
            }
            .footer_text{
                margin-left: 40%;margin-top: 3%;font-weight: bolder;color: white;padding-top: 1%;
            }
        </style>
    </head>
    <body style="height: 100vh">
        <script>

            var xmlhttp = new XMLHttpRequest();
            function set_city(city) {
                xmlhttp.open("post", "../set_city_session?city=" + city, true);
                xmlhttp.onreadystatechange = function () {
                    window.location.reload();
                    //document.getElementById("display_cars").style.display="inherit";

                };
                xmlhttp.send();
            }
            function appear_block(id) {
                document.getElementById("hover_block" + id).style.display = "inherit";
                document.getElementById("hover_block" + id).style.zIndex = 100;
            }
            function disappear_block(id)
            {
                document.getElementById("hover_block" + id).style.display = "none";
                document.getElementById("hover_block" + id).style.zIndex = 100
            }
            function set_vehicle_type() {
                vehicle_type = document.getElementById("vehicle_type").value;
                //alert(vehicle_type);
                xmlhttp.open("post", "../set_vehicle_type_session?type=" + vehicle_type, true);
                xmlhttp.onreadystatechange = function () {
                    window.location.reload();
                    //document.getElementById("display_cars").style.display="inherit";

                };
                xmlhttp.send();
            }
        </script>    
        <jsp:include page="../includes/header.jsp"/>


        <div class="container" style="margin-top: 3%">
            <%
                String msg = request.getParameter("msg");
                if (msg != null) {
            %>
            <script>
                alert('<%=msg%>');
            </script>
            <%
                }
                String username = (String) session.getAttribute("username");
                if (username == null) {
                    response.sendRedirect("login.jsp");
                }
                String session_city = (String) session.getAttribute("city");
                String vehicle_type = (String) session.getAttribute("vehicle_type");
                System.out.println(vehicle_type);
            %>
            <h1>Welcome <%=username%>   </h1>
            <h2>Book A Self Driving Car</h2>
            <div class="row">
                <div class="col-xs-2">
                    <label for="city">Select your City :</label>
                </div>
                <div class="col-xs-3">
                    <select class='form-control' id ="city" onchange="set_city(this.value)" >
                        <%
                            if (session_city != null) {
                        %>
                        <option selected><%=session_city%></option>
                        <%
                        } else {
                        %>
                        <option disabled selected>Select city</option>
                        <%
                            }
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("select distinct city from merchant where city!='" + session_city + "'");
                            while (rs.next()) {
                        %>
                        <option><%=rs.getString("city")%></option>
                        <%
                            }
                            stmt.close();
                        %>
                    </select>
                </div>
                <div class="col-xs-4">
                    <label for="vehicle_type">Select the type of vehicle you want to zoom in :</label>
                </div>
                <div class="col-xs-3">
                    <select id="vehicle_type" class="form-control" onchange="set_vehicle_type()">
                        <%
                            if (vehicle_type == null) {
                        %>
                        <option disabled selected>Cars or Bikes</option>
                        <option value="4wheeler">Only Cars</option>
                        <option value="2wheeler">Only Bikes</option>
                        <option value="">Both Cars and Bikes</option>
                        <%
                        } else if (vehicle_type.equals("2wheeler")) {
                        %>
                        <option value="4wheeler">Only Cars</option>
                        <option value="2wheeler" selected>Only Bikes</option>
                        <option value="">Both Cars and Bikes</option>
                        <%
                        } else if (vehicle_type.equals("4wheeler")) {
                        %>
                        <option value="4wheeler" selected>Only Cars</option>
                        <option value="2wheeler">Only Bikes</option>
                        <option value="">Both Cars and Bikes</option>
                        <%
                        } else {
                        %>
                        <option value="4wheeler">Only Cars</option>
                        <option value="2wheeler">Only Bikes</option>
                        <option value="" selected>Both Cars and Bikes</option>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>

            <%
                if (session_city != null) {
            %>
            <div class="panel panel-default" id="display_cars">
                <div class="panel-heading text-center"><h4>Cars Available for Booking from <%=session_city%></h4></div>
                <div class="panel-body">
                    <%
                        
                        String vehicle_cond="";
                        if(vehicle_type!=null){
                            vehicle_cond=" and cars.type='"+vehicle_type+"'";
                        }
                        if(vehicle_type==""){
                            vehicle_cond="";
                        }
                        Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs1 = stmt1.executeQuery("select * from cars,rental_cars where cars.car_name=rental_cars.car_name and rental_cars.merchant_city='" + session_city + "' "+vehicle_cond);
                        while (rs1.next()) {
                            String car_name = rs1.getString("car_name");
                            String car_type = rs1.getString("car_type");
                            String car_id = rs1.getString("id");
                            String car_price = rs1.getString("car_price");
                            String p_per_day = rs1.getString("p_per_day");
                            String security = rs1.getString("security");
                            String photo = rs1.getString("photo");
                            String maker = rs1.getString("maker");
                            String num_seats = rs1.getString("num_seats");
                    %>





                    <div class="col-xs-3">
                        <div class="thumbnail bg-info" data-toggle="modal" data-target="#view_car<%=car_id%>" style="background-color: beige;" >
                            <img src=".<%=photo%>"style="height: 160px;" class="img-responsive img-rounded img-thumbnail">
                            <div class="caption text-center"><%=car_name%></div>
                        </div>
                    </div>

                    <!----VIEW CAR FOR BOOKING MODAL STARTS-------->            
                    <div id="view_car<%=car_id%>" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Hire <%=car_name%> from <%=session_city%></h4>
                                </div>
                                <div class="modal-body">
                                    <img src=".<%=photo%>" class="img-responsive img-responsive img-thumbnail" style="margin-left: 30%"/>
                                    <table class="table">
                                        <tr>
                                            <td><label>Car Name</label><td>
                                            <td><p><%=car_name%></p></td>
                                        </tr>
                                        <tr>
                                            <td><label>Type</label><td>
                                            <td><p><%=car_type%></p></td>
                                        </tr>
                                        <tr>
                                            <td><label>Maker</label><td>
                                            <td><p><%=maker%></p></td>
                                        </tr>
                                        <tr>
                                            <td><label>Number of seats</label><td>
                                            <td><p><%=num_seats%></p></td>
                                        </tr>
                                        <tr>
                                            <td><label>Rent per Day</label><td>
                                            <td><p><%=p_per_day%></p></td>
                                        </tr>
                                        <tr>
                                            <td><label>Security to be deposited</label><td>
                                            <td><p><%=security%></p></td>
                                        </tr>
                                    </table>
                                    <a href="book_car.jsp?c_id=<%=car_id%>">
                                        <div class="btn btn-primary btn-lg" style="margin-left: 40%" >
                                            Book Now
                                        </div></a>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-----VIEW CAR FOR BOOKING MODAL ENDS--------->            




                    <%
                        }
                    %>
                </div>
            </div>
            <%
                }
            %>
           
        </div>
<!--            <div class="footer">
                <p class="footer_text">Want To Rent Your Cars Here. <a href="../merchant/login.jsp">Click here to be a Seller</a></p>
            </div>-->
    </body>
</html>
