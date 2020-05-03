package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/jquery-3.2.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>User Dashboard</title>\n");
      out.write("        <style>\n");
      out.write("            .footer{\n");
      out.write("                background-color: black;\n");
      out.write("                height: 50px;\n");
      out.write("                margin-bottom: 0px;\n");
      out.write("            }\n");
      out.write("            .footer_text{\n");
      out.write("                margin-left: 40%;margin-top: 3%;font-weight: bolder;color: white;padding-top: 1%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"height: 100vh\">\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            var xmlhttp = new XMLHttpRequest();\n");
      out.write("            function set_city(city) {\n");
      out.write("                xmlhttp.open(\"post\", \"../set_city_session?city=\" + city, true);\n");
      out.write("                xmlhttp.onreadystatechange = function () {\n");
      out.write("                    window.location.reload();\n");
      out.write("                    //document.getElementById(\"display_cars\").style.display=\"inherit\";\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            function appear_block(id) {\n");
      out.write("                document.getElementById(\"hover_block\" + id).style.display = \"inherit\";\n");
      out.write("                document.getElementById(\"hover_block\" + id).style.zIndex = 100;\n");
      out.write("            }\n");
      out.write("            function disappear_block(id)\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"hover_block\" + id).style.display = \"none\";\n");
      out.write("                document.getElementById(\"hover_block\" + id).style.zIndex = 100\n");
      out.write("            }\n");
      out.write("            function set_vehicle_type() {\n");
      out.write("                vehicle_type = document.getElementById(\"vehicle_type\").value;\n");
      out.write("                //alert(vehicle_type);\n");
      out.write("                xmlhttp.open(\"post\", \"../set_vehicle_type_session?type=\" + vehicle_type, true);\n");
      out.write("                xmlhttp.onreadystatechange = function () {\n");
      out.write("                    window.location.reload();\n");
      out.write("                    //document.getElementById(\"display_cars\").style.display=\"inherit\";\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("        </script>    \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../includes/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"margin-top: 3%\">\n");
      out.write("            ");

                String msg = request.getParameter("msg");
                if (msg != null) {
            
      out.write("\n");
      out.write("            <script>\n");
      out.write("                alert('");
      out.print(msg);
      out.write("');\n");
      out.write("            </script>\n");
      out.write("            ");

                }
                String username = (String) session.getAttribute("username");
                if (username == null) {
                    response.sendRedirect("login.jsp");
                }
                String session_city = (String) session.getAttribute("city");
                String vehicle_type = (String) session.getAttribute("vehicle_type");
                System.out.println(vehicle_type);
            
      out.write("\n");
      out.write("            <h1>Welcome ");
      out.print(username);
      out.write("   </h1>\n");
      out.write("            <h2>Book A Self Driving Car</h2>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-xs-2\">\n");
      out.write("                    <label for=\"city\">Select your City :</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xs-3\">\n");
      out.write("                    <select class='form-control' id =\"city\" onchange=\"set_city(this.value)\" >\n");
      out.write("                        ");

                            if (session_city != null) {
                        
      out.write("\n");
      out.write("                        <option selected>");
      out.print(session_city);
      out.write("</option>\n");
      out.write("                        ");

                        } else {
                        
      out.write("\n");
      out.write("                        <option disabled selected>Select city</option>\n");
      out.write("                        ");

                            }
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("select distinct city from merchant where city!='" + session_city + "'");
                            while (rs.next()) {
                        
      out.write("\n");
      out.write("                        <option>");
      out.print(rs.getString("city"));
      out.write("</option>\n");
      out.write("                        ");

                            }
                            stmt.close();
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xs-4\">\n");
      out.write("                    <label for=\"vehicle_type\">Select the type of vehicle you want to zoom in :</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xs-3\">\n");
      out.write("                    <select id=\"vehicle_type\" class=\"form-control\" onchange=\"set_vehicle_type()\">\n");
      out.write("                        ");

                            if (vehicle_type == null) {
                        
      out.write("\n");
      out.write("                        <option disabled selected>Cars or Bikes</option>\n");
      out.write("                        <option value=\"4wheeler\">Only Cars</option>\n");
      out.write("                        <option value=\"2wheeler\">Only Bikes</option>\n");
      out.write("                        <option value=\"\">Both Cars and Bikes</option>\n");
      out.write("                        ");

                        } else if (vehicle_type.equals("2wheeler")) {
                        
      out.write("\n");
      out.write("                        <option value=\"4wheeler\">Only Cars</option>\n");
      out.write("                        <option value=\"2wheeler\" selected>Only Bikes</option>\n");
      out.write("                        <option value=\"\">Both Cars and Bikes</option>\n");
      out.write("                        ");

                        } else if (vehicle_type.equals("4wheeler")) {
                        
      out.write("\n");
      out.write("                        <option value=\"4wheeler\" selected>Only Cars</option>\n");
      out.write("                        <option value=\"2wheeler\">Only Bikes</option>\n");
      out.write("                        <option value=\"\">Both Cars and Bikes</option>\n");
      out.write("                        ");

                        } else {
                        
      out.write("\n");
      out.write("                        <option value=\"4wheeler\">Only Cars</option>\n");
      out.write("                        <option value=\"2wheeler\">Only Bikes</option>\n");
      out.write("                        <option value=\"\" selected>Both Cars and Bikes</option>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

                if (session_city != null) {
            
      out.write("\n");
      out.write("            <div class=\"panel panel-default\" id=\"display_cars\">\n");
      out.write("                <div class=\"panel-heading text-center\"><h4>Cars Available for Booking from ");
      out.print(session_city);
      out.write("</h4></div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    ");

                        
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
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-xs-3\">\n");
      out.write("                        <div class=\"thumbnail bg-info\" data-toggle=\"modal\" data-target=\"#view_car");
      out.print(car_id);
      out.write("\" style=\"background-color: beige;\" >\n");
      out.write("                            <img src=\".");
      out.print(photo);
      out.write("\"style=\"height: 160px;\" class=\"img-responsive img-rounded img-thumbnail\">\n");
      out.write("                            <div class=\"caption text-center\">");
      out.print(car_name);
      out.write("</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!----VIEW CAR FOR BOOKING MODAL STARTS-------->            \n");
      out.write("                    <div id=\"view_car");
      out.print(car_id);
      out.write("\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("                        <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                            <!-- Modal content-->\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                                    <h4 class=\"modal-title\">Hire ");
      out.print(car_name);
      out.write(" from ");
      out.print(session_city);
      out.write("</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("                                    <img src=\".");
      out.print(photo);
      out.write("\" class=\"img-responsive img-responsive img-thumbnail\" style=\"margin-left: 30%\"/>\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><label>Car Name</label><td>\n");
      out.write("                                            <td><p>");
      out.print(car_name);
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><label>Type</label><td>\n");
      out.write("                                            <td><p>");
      out.print(car_type);
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><label>Maker</label><td>\n");
      out.write("                                            <td><p>");
      out.print(maker);
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><label>Number of seats</label><td>\n");
      out.write("                                            <td><p>");
      out.print(num_seats);
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><label>Rent per Day</label><td>\n");
      out.write("                                            <td><p>");
      out.print(p_per_day);
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td><label>Security to be deposited</label><td>\n");
      out.write("                                            <td><p>");
      out.print(security);
      out.write("</p></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                    <a href=\"book_car.jsp?c_id=");
      out.print(car_id);
      out.write("\">\n");
      out.write("                                        <div class=\"btn btn-primary btn-lg\" style=\"margin-left: 40%\" >\n");
      out.write("                                            Book Now\n");
      out.write("                                        </div></a>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-----VIEW CAR FOR BOOKING MODAL ENDS--------->            \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("           \n");
      out.write("        </div>\n");
      out.write("<!--            <div class=\"footer\">\n");
      out.write("                <p class=\"footer_text\">Want To Rent Your Cars Here. <a href=\"../merchant/login.jsp\">Click here to be a Seller</a></p>\n");
      out.write("            </div>-->\n");
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
