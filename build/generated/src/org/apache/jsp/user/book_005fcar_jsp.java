package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.sql.*;

public final class book_005fcar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../includes/header.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            var xmlhttp = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("            function set_city(city) {\n");
      out.write("                xmlhttp.open(\"post\", \"../set_city_session?city=\" + city, true);\n");
      out.write("                xmlhttp.onreadystatechange = function () {\n");
      out.write("                    window.location.href = \"home.jsp?msg=Choose the car again from the city from where the ride is going to start\";\n");
      out.write("                };\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function enable_return()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"date_return\").removeAttribute(\"disabled\");\n");
      out.write("                document.getElementById(\"error\").innerHTML = \"\";\n");
      out.write("            }\n");
      out.write("            function days_between() {\n");
      out.write("\n");
      out.write("                var date_issue = document.getElementById(\"date_issue\").value;\n");
      out.write("                var date_return = document.getElementById(\"date_return\").value;\n");
      out.write("                if (date_issue != \"\" && date_return != \"\")\n");
      out.write("                {\n");
      out.write("                    //var res=date_issue.\n");
      out.write("                    var date1 = new Date(date_issue);\n");
      out.write("                    var date2 = new Date(date_return);\n");
      out.write("\n");
      out.write("                    // The number of milliseconds in one day\n");
      out.write("                    var ONE_DAY = 1000 * 60 * 60 * 24;\n");
      out.write("\n");
      out.write("                    // Convert both dates to milliseconds\n");
      out.write("                    var date1_ms = date1.getTime();\n");
      out.write("                    var date2_ms = date2.getTime();\n");
      out.write("                    document.getElementById(\"error\").innerHTML= \"\";\n");
      out.write("                    if (date2_ms < date1_ms)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"error\").innerHTML = \"Date of return has to be more than that of issue\";\n");
      out.write("                        return;\n");
      out.write("                    }\n");
      out.write("                    // Calculate the difference in milliseconds\n");
      out.write("                    var difference_ms = Math.abs(date2_ms - date1_ms);\n");
      out.write("\n");
      out.write("\n");
      out.write("                    // Convert back to days and return\n");
      out.write("                    document.getElementById(\"num_days\").value = Math.round(difference_ms / ONE_DAY);\n");
      out.write("                    cal_amt();\n");
      out.write("                }   //if ends\n");
      out.write("            }\n");
      out.write("            function cal_amt()\n");
      out.write("            {\n");
      out.write("                var num_days = parseInt(document.getElementById(\"num_days\").value);\n");
      out.write("                var p_per_day = parseInt(document.getElementById(\"p_per_day\").value);\n");
      out.write("                var security = parseInt(document.getElementById(\"security\").value);\n");
      out.write("\n");
      out.write("                document.getElementById(\"tot_amt\").value = num_days * p_per_day + security;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"margin-top: 3%\">\n");
      out.write("            ");

                java.sql.Date today = new java.sql.Date((new java.util.Date()).getTime());
                String username = (String) session.getAttribute("username");
                if (username == null) {
                    response.sendRedirect("login.jsp");
                }
                String session_city = (String) session.getAttribute("city");
            
      out.write("\n");
      out.write("            <h1>Welcome ");
      out.print(username);
      out.write("</h1><a href=\"logout.jsp\"><span style=\"float: right\" >Logout</span></a>\n");
      out.write("            ");

                String c_id = request.getParameter("c_id");
                int car_id = 0;
                if (c_id == null) {
                    response.sendRedirect("home.jsp");
                } else {
                    car_id = Integer.parseInt(c_id);
                }
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from cars,rental_cars where rental_cars.car_name=cars.car_name and rental_cars.id='" + car_id + "'");
                if (rs.next()) {
                    String car_name = rs.getString("car_name");
                    String car_type = rs.getString("car_type");
                    String maker = rs.getString("maker");
                    String photo = rs.getString("photo");
                    String num_seats = rs.getString("num_seats");
                    String p_per_day = rs.getString("p_per_day");
                    String security = rs.getString("security");
                    String merchant_username = rs.getString("merchant_username");
                    String num_cars = rs.getString("num_cars");


            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"row\" style=\"background-color: whitesmoke; border-radius: 10px\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <img src=\".");
      out.print(photo);
      out.write("\" class=\"img-responsive img-thumbnail\" style=\"margin-left: 20%\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <table class=\"table table-responsive\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Car</label></td>\n");
      out.write("                                <td>");
      out.print(car_name);
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Car Type</label></td>\n");
      out.write("                                <td>");
      out.print(car_type);
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Maker</label></td>\n");
      out.write("                                <td>");
      out.print(maker);
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Number of seats</label></td>\n");
      out.write("                                <td>");
      out.print(num_seats);
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <form action=\"final_booking.jsp?c_id=");
      out.print(car_id);
      out.write("\" method=\"post\" >\n");
      out.write("                        <table class=\"table table-responsive\" >\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>From</label></td>\n");
      out.write("                                <td>\n");
      out.write("                                    <select onchange=\"set_city(this.value)\" name=\"from\" class=\"form-control\">\n");
      out.write("                                        <option>");
      out.print(session_city);
      out.write("</option>\n");
      out.write("                                        ");

                                            Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                            ResultSet rs1 = stmt1.executeQuery("select distinct city from merchant where city!='" + session_city + "'");
                                            while (rs1.next()) {
                                        
      out.write("\n");
      out.write("                                        <option>");
      out.print(rs1.getString("city"));
      out.write("</option>\n");
      out.write("                                        ");

                                            }
                                            stmt1.close();
                                        
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label for=\"to\">Destination</label></td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type='text' name='to' id='to' name=\"to\" class=\"form-control\"/>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label for=\"date_issue\">Date of car issue</label><label style=\"color:  blue\">(Car will be issued At 08:00 A.M)</label>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"date\" class=\"form-control\" min=\"");
      out.print(today);
      out.write("\" id=\"date_issue\" name=\"date_issue\" required onchange=\"enable_return()\"/>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label for=\"date_return\">Date of car return</label><label style=\"color:  blue\">(Car has to be returned By 08:00 A.M on)</label>\n");
      out.write("                                    <label id='error' style=\"color: red\"></label>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"date\" class=\"form-control\" id=\"date_return\" name=\"date_return\" required disabled onchange=\"days_between()\"/>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label for=\"num_days\">Number of days</label></td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" id=\"num_days\" name=\"num_days\" readonly required/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label for=\"p_per_day\">Rent per day</label></td>\n");
      out.write("                                <td><input type=\"text\" id=\"p_per_day\" class=\"form-control\" name=\"p_per_day\" value=\"");
      out.print(p_per_day);
      out.write("\" readonly/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label for=\"security\">Security to be deposited prier to ride</label></td>\n");
      out.write("                                <td><input type=\"text\" id=\"security\" class=\"form-control\" name=\"security\" value=\"");
      out.print(security);
      out.write("\" readonly/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label for=\"tot_amt\">Total Amount</label></td>\n");
      out.write("                                <td><input type=\"text\" id=\"tot_amt\" class=\"form-control\"name=\"tot_amt\" readonly/></td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <input type=\"submit\" class=\"btn btn-lg btn-primary\" value=\"Book\" style=\"margin-left: 40%\"/>       \n");
      out.write("        </form>\n");
      out.write("        ");

            }
        
      out.write(" \n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
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
