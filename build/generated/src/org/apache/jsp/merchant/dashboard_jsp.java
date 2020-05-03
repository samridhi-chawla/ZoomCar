package org.apache.jsp.merchant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/jquery-3.2.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            var xmlhttp = new XMLHttpRequest();\n");
      out.write("            //function for add cars module\n");
      out.write("            function go(car_type)\n");
      out.write("            {\n");
      out.write("                xmlhttp.open(\"get\", \"../get_cars?car_type=\" + car_type, true);\n");
      out.write("                xmlhttp.onreadystatechange = set_cars;\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function set_cars()\n");
      out.write("            {\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n");
      out.write("                    var res = xmlhttp.responseText.split(\",\");\n");
      out.write("                    var car_id = res[0];\n");
      out.write("                    document.getElementById(\"car_name\").innerHTML = res[1];\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            //fnctions for add_bike model (had to make different func coz of id conflict)\n");
      out.write("            function get_bikes(car_type)\n");
      out.write("            {\n");
      out.write("                xmlhttp.open(\"get\", \"../get_cars?car_type=\" + car_type, true);\n");
      out.write("                xmlhttp.onreadystatechange = set_bikes;\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function set_bikes()\n");
      out.write("            {\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n");
      out.write("                    var res = xmlhttp.responseText.split(\",\");\n");
      out.write("                    var car_id = res[0];\n");
      out.write("                    document.getElementById(\"bike_name\").innerHTML = res[1];\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            /// function for edit car module\n");
      out.write("            function edit_go(car_type, car_id)\n");
      out.write("            {\n");
      out.write("                xmlhttp.open(\"get\", \"../get_cars?car_type=\" + car_type + \"&car_id=\" + car_id, true);\n");
      out.write("                xmlhttp.onreadystatechange = edit_set_cars;\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function edit_set_cars()\n");
      out.write("            {\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                {\n");
      out.write("                    var res = xmlhttp.responseText.split(\",\");\n");
      out.write("                    var car_id = res[0];\n");
      out.write("                    document.getElementById(\"car_name\" + car_id).innerHTML = res[1];\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            //for add module car\n");
      out.write("            function go1(car_name)\n");
      out.write("            {\n");
      out.write("                xmlhttp.open(\"get\", \"../get_car_details?car_name=\" + car_name, true);\n");
      out.write("                xmlhttp.onreadystatechange = get_details;\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            function get_details()\n");
      out.write("            {\n");
      out.write("                // alert(xmlhttp.responseText);\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                {\n");
      out.write("                    var res = xmlhttp.responseText.split(\",\");\n");
      out.write("                    var car_id = res[0];\n");
      out.write("                    var photo = \".\" + res[1];\n");
      out.write("                    var maker = res[2];\n");
      out.write("                    var num_seats = res[3];\n");
      out.write("                    var car_price = res[4];\n");
      out.write("                    var p_per_day = res[5];\n");
      out.write("                    var security = res[6];\n");
      out.write("                    document.getElementById(\"d_photo\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"photo\").src = photo;\n");
      out.write("                    document.getElementById(\"d_maker\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"maker\").value = maker;\n");
      out.write("                    document.getElementById(\"d_num_seats\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"num_seats\").value = num_seats;\n");
      out.write("                    document.getElementById(\"d_price\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"car_price\").value = car_price;\n");
      out.write("                    document.getElementById(\"d_p_per_day\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"p_per_day\").value = p_per_day;\n");
      out.write("                    document.getElementById(\"d_security\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"security\").value = security;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            //add bike \n");
      out.write("            function get_bike_details(car_name)\n");
      out.write("            {\n");
      out.write("                xmlhttp.open(\"get\", \"../get_car_details?car_name=\" + car_name, true);\n");
      out.write("                xmlhttp.onreadystatechange = set_bike_details;\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            function set_bike_details()\n");
      out.write("            {\n");
      out.write("                // alert(xmlhttp.responseText);\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                {\n");
      out.write("                    var res = xmlhttp.responseText.split(\",\");\n");
      out.write("                    var car_id = res[0];\n");
      out.write("                    var photo = \".\" + res[1];\n");
      out.write("                    var maker = res[2];\n");
      out.write("                    var num_seats = res[3];\n");
      out.write("                    var car_price = res[4];\n");
      out.write("                    var p_per_day = res[5];\n");
      out.write("                    var security = res[6];\n");
      out.write("                    document.getElementById(\"bike_d_photo\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"bike_photo\").src = photo;\n");
      out.write("                    document.getElementById(\"bike_d_maker\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"bike_maker\").value = maker;\n");
      out.write("                    //document.getElementById(\"d_num_seats\").style.display = \"inline\";\n");
      out.write("                    //document.getElementById(\"num_seats\").value = num_seats;\n");
      out.write("                    document.getElementById(\"bike_d_price\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"bike_car_price\").value = car_price;\n");
      out.write("                    document.getElementById(\"bike_d_p_per_day\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"bike_p_per_day\").value = p_per_day;\n");
      out.write("                    document.getElementById(\"bike_d_security\").style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"bike_security\").value = security;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            //for edit module\n");
      out.write("            function edit_go1(car_id, car_name)\n");
      out.write("            {\n");
      out.write("                xmlhttp.open(\"get\", \"../get_car_details?car_id=\" + car_id + \"&car_name=\" + car_name, true);\n");
      out.write("                xmlhttp.onreadystatechange = get_details_of_edit;\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            function get_details_of_edit()\n");
      out.write("            {\n");
      out.write("                // alert(xmlhttp.responseText);\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                {\n");
      out.write("                    var res = xmlhttp.responseText.split(\",\");\n");
      out.write("                    var car_id = res[0];\n");
      out.write("                    var photo = \".\" + res[1];\n");
      out.write("                    var maker = res[2];\n");
      out.write("                    var p_per_day = res[5];\n");
      out.write("                    var num_seats = res[3];\n");
      out.write("                    var car_price = res[4];\n");
      out.write("                    var security = res[6];\n");
      out.write("                    document.getElementById(\"d_photo\" + car_id).style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"photo\" + car_id).src = photo;\n");
      out.write("                    document.getElementById(\"d_maker\" + car_id).style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"maker\" + car_id).value = maker;\n");
      out.write("                    document.getElementById(\"d_num_seats\" + car_id).style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"num_seats\" + car_id).value = num_seats;\n");
      out.write("                    document.getElementById(\"d_price\" + car_id).style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"car_price\" + car_id).value = car_price;\n");
      out.write("                    document.getElementById(\"d_p_per_day\" + car_id).style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"p_per_day\" + car_id).value = p_per_day;\n");
      out.write("                    document.getElementById(\"d_security\" + car_id).style.display = \"inline\";\n");
      out.write("                    document.getElementById(\"security\" + car_id).value = security;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function del(car_id, num_cars)\n");
      out.write("            {\n");
      out.write("                if (confirm(\"Are you sure you want to delete \" + num_cars + \" car?\"))\n");
      out.write("                {\n");
      out.write("                    window.location.href = \"delete_car.jsp?c_id=\" + car_id;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"jumbotron\">\n");
      out.write("            <h1>");
      out.print(merchant_username);
      out.write(" Dashboard</h1>\n");
      out.write("            <a href=\"logout.jsp\"><h5 style=\"float: right\">Logout</h5></a>\n");
      out.write("        </div>\n");
      out.write("        <h4 class=\"text-right\" >Status ");
      out.print(status);
      out.write("</h4>\n");
      out.write("        <h1>Manage My Cars</h1>\n");
      out.write("\n");
      out.write("        <table class=\"table table-bordered table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>S.No</th>\n");
      out.write("                <th>Car Photo</th>\n");
      out.write("                <th>Car Name</th>\n");
      out.write("                <th>No. of Cars</th>\n");
      out.write("                <th>Rent Received per Day</th>\n");
      out.write("                <th>Security deposit</th>\n");
      out.write("                <th colspan=\"2\">Operations</th>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( i);
      out.write("</td>\n");
      out.write("                <td><img src=\".");
      out.print(photo);
      out.write("\" width=\"100px\" height=\"100px\"/></td>\n");
      out.write("                <td>");
      out.print(car_name);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(num_cars);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(p_per_day);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(security);
      out.write("</td>\n");
      out.write("                <td><input type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#edit_modal");
      out.print(car_id);
      out.write("\" value=\"Edit\"/></td>\n");
      out.write("                <td><input type=\"button\" class=\"btn btn-primary\" onclick=\"del('");
      out.print(car_id);
      out.write("', '");
      out.print(num_cars);
      out.write("')\" value=\"Delete\"/></td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <!------EDIT CAR MODAL STARTS-------->\n");
      out.write("            <!-- Modal -->\n");
      out.write("            <div id=\"edit_modal");
      out.print(car_id);
      out.write("\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                    <!-- Modal content-->\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                            <h4 class=\"modal-title\">Edit ");
      out.print(car_name);
      out.write("</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form action=\"edit_merchant_car.jsp?c_id=");
      out.print(car_id);
      out.write("\" method=\"post\" class=\"form-vertical\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"car_type");
      out.print(car_id);
      out.write("\">Car Type</label>\n");
      out.write("                                    <select id=\"car_type");
      out.print(car_id);
      out.write("\" name=\"car_type\" onchange=\"edit_go(this.value, '");
      out.print(car_id);
      out.write("')\" class=\"form-control\" required>\n");
      out.write("                                        <option selected>");
      out.print(car_type);
      out.write("</option>\n");
      out.write("                                        ");

                                            Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                            ResultSet rs3 = stmt3.executeQuery("select distinct car_type from cars where car_type!='" + car_type + "'");

                                            while (rs3.next()) {
                                        
      out.write("\n");
      out.write("                                        <option>");
      out.print(rs3.getString("car_type"));
      out.write("</option>\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                    </select>   \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\" >\n");
      out.write("                                    <label for=\"car_name");
      out.print(car_id);
      out.write("\">Select Car</label>\n");
      out.write("                                    <select name=\"car_name\" id=\"car_name");
      out.print(car_id);
      out.write("\" class=\"form-control\" onchange=\"edit_go1('");
      out.print(car_id);
      out.write("', this.value)\" required>\n");
      out.write("                                        <option>");
      out.print(car_name);
      out.write("</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"d_photo");
      out.print(car_id);
      out.write("\" style=\"display:none\">\n");
      out.write("                                    <img src=\"\" id=\"photo");
      out.print(car_id);
      out.write("\" height=\"200px\" width=\"200px\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"num_cars");
      out.print(car_id);
      out.write("\">Number of cars you want to rent</label>\n");
      out.write("                                    <input type=\"text\" value=\"1\" readonly class=\"form-control\" id=\"num_cars\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\" id=\"d_maker");
      out.print(car_id);
      out.write("\" style=\"display:none\">\n");
      out.write("                                    <label for=\"maker");
      out.print(car_id);
      out.write("\">Maker of the car</label>\n");
      out.write("                                    <input type=\"text\" id=\"maker");
      out.print(car_id);
      out.write("\" class=\"form-control\" readonly>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\" id=\"d_num_seats");
      out.print(car_id);
      out.write("\" style=\"display:none\">\n");
      out.write("                                    <label for=\"num_seats");
      out.print(car_id);
      out.write("\">Numbe of seats in the car</label>\n");
      out.write("                                    <input type=\"text\" id=\"num_seats");
      out.print(car_id);
      out.write("\" class=\"form-control\" readonly>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\" id=\"d_price");
      out.print(car_id);
      out.write("\" style=\"display:none\">\n");
      out.write("                                    <label for=\"car_price");
      out.print(car_id);
      out.write("\">Market Price of the car</label>\n");
      out.write("                                    <input type=\"text\" id=\"car_price");
      out.print(car_id);
      out.write("\" class=\"form-control\" readonly>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\" id=\"d_p_per_day");
      out.print(car_id);
      out.write("\" style=\"display:none\">\n");
      out.write("                                    <label for=\"p_per_day");
      out.print(car_id);
      out.write("\">Rent per day that will be received for this car while on rent</label>\n");
      out.write("                                    <input type=\"text\" id=\"p_per_day");
      out.print(car_id);
      out.write("\" class=\"form-control\" readonly>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\" id=\"d_security");
      out.print(car_id);
      out.write("\" style=\"display:none\">\n");
      out.write("                                    <label for=\"security");
      out.print(car_id);
      out.write("\">Security deposit made by borrower before renting this car</label>\n");
      out.write("                                    <input type=\"text\" id=\"security");
      out.print(car_id);
      out.write("\" class=\"form-control\" readonly>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"submit\" style=\"margin-left: 40%\" class=\"btn btn-primary\" value=\"Update Car\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-------EDIT CAR MODAL ENDS-------->\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <!---------ADD NEW CARS-------->\n");
      out.write("\n");
      out.write("        <div class=\"btn btn-lg btn-primary\" data-toggle=\"collapse\" data-target=\"#add_form\" ><span class=\"glyphicon glyphicon-plus-sign\"></span> Add New Cars</div>\n");
      out.write("\n");
      out.write("        <div id=\"add_form\" class=\"collapsing\" style=\"width:60%;margin: 1%\">\n");
      out.write("            <form action=\"add_merchant_car.jsp\" method=\"post\" class=\"form-vertical\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"car_type\">Car Type</label>\n");
      out.write("                    <select id=\"car_type\" name=\"car_type\" onchange=\"go(this.value)\" class=\"form-control\" required>\n");
      out.write("                        <option selected disabled>Select car type</option>\n");
      out.write("                        ");

                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("select distinct car_type from cars where type='4wheeler'");

                            while (rs.next()) {
                        
      out.write("\n");
      out.write("                        <option>");
      out.print(rs.getString("car_type"));
      out.write("</option>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </select>   \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\" >\n");
      out.write("                    <label for=\"car_name\">Select Car</label>\n");
      out.write("                    <select name=\"car_name\" id=\"car_name\" class=\"form-control\" onchange=\"go1(this.value)\" required>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"d_photo\" style=\"display:none\">\n");
      out.write("                    <img src=\"\" id=\"photo\" height=\"200px\" width=\"200px\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"num_cars\">Number of cars you want to rent</label>\n");
      out.write("                    <input type=\"text\" value=\"1\" id=\"num_cars\" name=\"num_cars\" readonly/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"d_maker\" style=\"display:none\">\n");
      out.write("                    <label for=\"maker\">Maker of the car</label>\n");
      out.write("                    <input type=\"text\" id=\"maker\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"d_num_seats\" style=\"display:none\">\n");
      out.write("                    <label for=\"num_seats\">Number of seats in the car</label>\n");
      out.write("                    <input type=\"text\" id=\"num_seats\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"d_price\" style=\"display:none\">\n");
      out.write("                    <label for=\"car_price\">Market Price of the car</label>\n");
      out.write("                    <input type=\"text\" id=\"car_price\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"d_p_per_day\" style=\"display:none\">\n");
      out.write("                    <label for=\"p_per_day\">Rent per day that will be received for this car while on rent</label>\n");
      out.write("                    <input type=\"text\" id=\"p_per_day\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"d_security\" style=\"display:none\">\n");
      out.write("                    <label for=\"security\">Security deposit made by borrower before renting this car</label>\n");
      out.write("                    <input type=\"text\" id=\"security\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-primary\" value=\"Add Car\"/>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!---------ADD NEW BIKES-------->\n");
      out.write("\n");
      out.write("        <div class=\"btn btn-lg btn-primary\" data-toggle=\"collapse\" data-target=\"#add_bike_form\" ><span class=\"glyphicon glyphicon-plus-sign\"></span> Add New Bikes</div>\n");
      out.write("\n");
      out.write("        <div id=\"add_bike_form\" class=\"collapsing\" style=\"width:60%;margin: 1%\">\n");
      out.write("            <form action=\"add_merchant_car.jsp\" method=\"post\" class=\"form-vertical\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"car_type\">Car Type</label>\n");
      out.write("                    <select id=\"car_type\" name=\"car_type\" onchange=\"get_bikes(this.value)\" class=\"form-control\" required>\n");
      out.write("                        <option selected disabled>Select Bike type</option>\n");
      out.write("                        ");

                            Statement stmt4 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs4 = stmt4.executeQuery("select distinct car_type from cars where type='2wheeler'");

                            while (rs4.next()) {
                        
      out.write("\n");
      out.write("                        <option>");
      out.print(rs4.getString("car_type"));
      out.write("</option>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </select>   \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\" >\n");
      out.write("                    <label for=\"bike_name\">Select Bike</label>\n");
      out.write("                    <select name=\"car_name\" id=\"bike_name\" class=\"form-control\" onchange=\"get_bike_details(this.value)\" required>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"bike_d_photo\" style=\"display:none\">\n");
      out.write("                    <img src=\"\" id=\"bike_photo\" height=\"200px\" width=\"200px\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Number of Bikes you want to rent</label>\n");
      out.write("                    <input type=\"text\" value=\"1\" readonly class=\"form-control\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"bike_d_maker\" style=\"display:none\">\n");
      out.write("                    <label for=\"bike_maker\">Maker of the Bike</label>\n");
      out.write("                    <input type=\"text\" id=\"bike_maker\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"bike_d_price\" style=\"display:none\">\n");
      out.write("                    <label for=\"bike_car_price\">Market Price of the Bike</label>\n");
      out.write("                    <input type=\"text\" id=\"bike_car_price\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"bike_d_p_per_day\" style=\"display:none\">\n");
      out.write("                    <label for=\"bike_p_per_day\">Rent per day that will be received for this Bike while on rent</label>\n");
      out.write("                    <input type=\"text\" id=\"bike_p_per_day\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\" id=\"bike_d_security\" style=\"display:none\">\n");
      out.write("                    <label for=\"bike_security\">Security deposit made by borrower before renting this car</label>\n");
      out.write("                    <input type=\"text\" id=\"bike_security\" class=\"form-control\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-primary\" value=\"Add Bike\"/>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
