package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class manage_005fcars_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Admin-MangeCars</title>\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("        ");

            String msg = request.getParameter("msg");
            if (msg != null) {
        
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert(");
      out.print(msg);
      out.write(");\n");
      out.write("        </script>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function cal_security(price)\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"security\").value = 0.01 * price;\n");
      out.write("               \n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"\">\n");
      out.write("        <div class=\"container\" bgcolor=\"white\">\n");
      out.write("            <script>\n");
      out.write("                function readandpreview(fileobj, imageid)\n");
      out.write("                {\n");
      out.write("                    var firstfile = fileobj.files[0];\n");
      out.write("\n");
      out.write("                    var reader = new FileReader();\n");
      out.write("\n");
      out.write("                    //alert(\"File name: \" + firstfile.name);\n");
      out.write("                   // alert(\"File size: \" + firstfile.size);\n");
      out.write("\n");
      out.write("                    reader.onload = (function (f)\n");
      out.write("                    {\n");
      out.write("                        return function read12(e)\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(imageid).src = e.target.result;\n");
      out.write("                        };\n");
      out.write("                    })(firstfile);\n");
      out.write("\n");
      out.write("\n");
      out.write("                    reader.readAsDataURL(firstfile);\n");
      out.write("                }\n");
      out.write("                function del(name)\n");
      out.write("                {\n");
      out.write("                    if (confirm(\"Are you sure u want to delete \" + name))\n");
      out.write("                    {\n");
      out.write("                        window.location.href = \"../del_car?name=\" + name;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                function go()\n");
      out.write("                {   \n");
      out.write("                    if(document.getElementById('add_form').style.visibility==\"hidden\")\n");
      out.write("                    {\n");
      out.write("                        document.getElementById('add_form').style.visibility=\"visible\";\n");
      out.write("                        document.getElementById('add_btn').className=\"glyphicon glyphicon-minus-sign\";\n");
      out.write("                    }\n");
      out.write("                    else if(document.getElementById('add_form').style.visibility==\"visible\")\n");
      out.write("                    {\n");
      out.write("                        document.getElementById('add_form').style.visibility=\"hidden\";\n");
      out.write("                        document.getElementById('add_btn').className=\"glyphicon glyphicon-plus-sign\";\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("            ");

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
                //System.out.println("connection amde");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from cars where type='4wheeler'");
                //System.out.println("query amde");

    
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("                <h1 class=\"text-center\">Manage Cars</h1>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <table class=\"table table-bordered table-responsive table-hover table-striped\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Photo</th>\n");
      out.write("                    <th>Car Name</th>\n");
      out.write("                    <th>Maker</th>\n");
      out.write("                    <th>No. of Seats</th>\n");
      out.write("                    <th>Car Type</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Price per Day</th>\n");
      out.write("                    <th>Security</th>\n");
      out.write("                    <th>Edit</th>\n");
      out.write("                    <th>Delete</th>\n");
      out.write("\n");
      out.write("                </tr>   \n");
      out.write("\n");
      out.write("                ");
                    
                    while (rs.next()) {
                        String name = rs.getString("car_name");
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <img src='../");
      out.print(rs.getString("photo"));
      out.write("' width=\"100px\" height=\"100px\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(name);
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(rs.getString("maker"));
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(rs.getString("num_seats"));
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(rs.getString("car_type"));
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(rs.getString("car_price"));
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(rs.getString("p_per_day"));
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(rs.getString("security"));
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"edit_car.jsp?name=");
      out.print(name);
      out.write("\"><div class=\"btn btn-primary\">Edit</div></a>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"button\" class=\"btn btn-primary\" id=\"");
      out.print(name);
      out.write("\" onclick=\"del(this.id)\" value=\"Delete\">\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </table>    \n");
      out.write("                \n");
      out.write("            <div class=\"btn btn-lg btn-primary\"  onclick=\"go()\"><span id=\"add_btn\" class=\"glyphicon glyphicon-plus-sign\"></span> Add New Car Category</div>\n");
      out.write("            \n");
      out.write("            <div  id=\"add_form\" style=\"visibility:hidden; width: 70%;\" >\n");
      out.write("                <h2 class=\"text-center\">Add New Car Category</h2>\n");
      out.write("                <form class=\"form-vertical\" action=\"../add_car\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"car_name\">Car Name</label>\n");
      out.write("                        <input type = \"text\" name =\"car_name\" class=\"form-control\"  placeholder=\"Enter Name of the car\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"maker\">Maker</label>\n");
      out.write("                        <input type = \"text\" id=\"maker\" class=\"form-control\" name =\"maker\" placeholder=\"Enter the name of the Maker\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"photo\">Photo</label>\n");
      out.write("                        <img src=\"\" id=\"img\" style=\"width: 100px;height: 100px;\">\n");
      out.write("                        <input type = \"file\" id=\"photo\" name =\"photo\" onchange=\"readandpreview(this, 'img')\" required>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"num_seats\">Number of Seats</label>\n");
      out.write("                        <input type = \"text\" id=\"num_seats\" class=\"form-control\" name =\"num_seats\" placeholder=\"Enter number of seats\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"car_type\">Car Type</label>\n");
      out.write("                        <input type = \"text\" id=\"car_type\" class=\"form-control\" name =\"car_type\" placeholder=\"Enter Car type\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"car_price\">Car Price</label>\n");
      out.write("                        <input type = \"text\" id=\"car_price\" class=\"form-control\" name =\"car_price\" onchange=\"cal_security(this.value)\" placeholder=\"Enter price of the car in market\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"p_per_day\">Price per Day</label>\n");
      out.write("                        <input type = \"text\" id=\"p_per_day\" class=\"form-control\" name =\"p_per_day\" placeholder=\"Enter price of the car per day when rented\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"security\">Security</label>\n");
      out.write("                        <input type = \"text\" id=\"security\" class=\"form-control\" name =\"security\" value=\"1000\"readonly placeholder=\"The security to be deposited prier to hire\" >\n");
      out.write("                    </div>\n");
      out.write("                    <!--            <div class=\"form-group\">\n");
      out.write("                                    <label for=\"username\"> Enter Username</label>\n");
      out.write("                                    <input type = \"text\" id=\"username\" class=\"form-control\" name =\"username\" placeholder=\"Enter Username\" required=\"\">\n");
      out.write("                                </div>-->\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                        <input type = \"submit\" class=\"btn btn-lg btn-primary\" style=\"margin-left: 40%\" class=\"form-control\" name =\"username\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
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
