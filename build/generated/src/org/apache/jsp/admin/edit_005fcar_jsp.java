package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class edit_005fcar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin-MangeCars</title>\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("        \n");
      out.write("<script>\n");
      out.write("\n");
      out.write("    function readandpreview(fileobj, imageid)\n");
      out.write("    {\n");
      out.write("        var firstfile = fileobj.files[0];\n");
      out.write("\n");
      out.write("        var reader = new FileReader();\n");
      out.write("\n");
      out.write("        alert(\"File name: \" + firstfile.name);\n");
      out.write("        alert(\"File size: \" + firstfile.size);\n");
      out.write("\n");
      out.write("        reader.onload = (function (f)\n");
      out.write("        {\n");
      out.write("            return function read12(e)\n");
      out.write("            {\n");
      out.write("                document.getElementById(imageid).src = e.target.result;\n");
      out.write("            };\n");
      out.write("        })(firstfile);\n");
      out.write("\n");
      out.write("\n");
      out.write("        reader.readAsDataURL(firstfile);\n");
      out.write("    }\n");
      out.write("    function go()\n");
      out.write("    {\n");
      out.write("        document.getElementById(\"photo\").style.display=\"inherit\";\n");
      out.write("        document.getElementById(\"img\").src=\"\";\n");
      out.write("        document.getElementById(\"photo\").required=\"required\";\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("</script>\n");

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



      out.write("\n");
      out.write("\n");
      out.write("<div class=\"frame\" id=\"add_form\" >\n");
      out.write("    <h2 class=\"text-center\">Edit Car Category</h2>\n");
      out.write("    <form class=\"form-vertical\" action=\"../edit_car?name=");
      out.print(request.getParameter("name"));
      out.write("\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"car_name\">Car Name</label>\n");
      out.write("            <input type = \"text\" name =\"car_name\" class=\"form-control\"  value=\"");
      out.print(car_name);
      out.write("\" required=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"maker\">Maker</label>\n");
      out.write("            <input type = \"text\" id=\"maker\" class=\"form-control\" name =\"maker\" value=\"");
      out.print(maker);
      out.write("\" required=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"photo\">Photo</label>\n");
      out.write("            <img src=\"../");
      out.print(photo);
      out.write("\" id=\"img\" style=\"width: 100px;height: 100px;\">\n");
      out.write("            <input type=\"radio\" name=\"img_change\" id=\"r1\" value=\"false\" checked><label for='r1'> Dont Want to change the image</label>\n");
      out.write("            <input type=\"radio\" name=\"img_change\" id=\"r2\" value=\"true\" onchange=\"go()\"><label for=\"r2\">Want to change the image</label>\n");
      out.write("            <input type = \"file\" id=\"photo\" name =\"photo\" style=\"display: none\" onchange=\"readandpreview(this, 'img')\" >\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"num_seats\">Number of Seats</label>\n");
      out.write("            <input type = \"text\" id=\"num_seats\" class=\"form-control\" name =\"num_seats\" value=\"");
      out.print(num_seats);
      out.write("\" required=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"car_type\">Car Type</label>\n");
      out.write("            <input type = \"text\" id=\"car_type\" class=\"form-control\" name =\"car_type\" value=\"");
      out.print(car_type);
      out.write("\" required=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"car_price\">Car Price</label>\n");
      out.write("            <input type = \"text\" id=\"car_price\" class=\"form-control\" name =\"car_price\" onkeyup=\"cal_security(this.value)\" value=\"");
      out.print(car_price);
      out.write("\" required=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"p_per_day\">Price per Day</label>\n");
      out.write("            <input type = \"text\" id=\"p_per_day\" class=\"form-control\" name =\"p_per_day\" value=\"");
      out.print(p_per_day);
      out.write("\" required=\"\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"security\">Security</label>\n");
      out.write("            <input type = \"text\" id=\"security\" class=\"form-control\" name =\"security\" value=\"1000\"readonly value=\"");
      out.print(security);
      out.write("\" >\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("\n");
      out.write("            <input type = \"submit\" class=\"btn btn-lg btn-primary\" style=\"margin-left: 40%\" class=\"form-control\" >\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("    ");

        }
else
{
out.println("gadbad");
}
    
      out.write("\n");
      out.write("\n");
      out.write("</div>");
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
