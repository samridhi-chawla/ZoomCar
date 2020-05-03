package org.apache.jsp.merchant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class sign_005fup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function readandpreview(fileobj, imageid)\n");
      out.write("            {\n");
      out.write("                var firstfile = fileobj.files[0];\n");
      out.write("\n");
      out.write("                var reader = new FileReader();\n");
      out.write("\n");
      out.write("                //alert(\"File name: \" + firstfile.name);\n");
      out.write("                // alert(\"File size: \" + firstfile.size);\n");
      out.write("\n");
      out.write("                reader.onload = (function (f)\n");
      out.write("                {\n");
      out.write("                    return function read12(e)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(imageid).src = e.target.result;\n");
      out.write("                    };\n");
      out.write("                })(firstfile);\n");
      out.write("\n");
      out.write("\n");
      out.write("                reader.readAsDataURL(firstfile);\n");
      out.write("            }\n");
      out.write("            function go()\n");
      out.write("            {\n");
      out.write("                if (document.getElementById(\"password\").value == document.getElementById(\"cp\").value)\n");
      out.write("                {\n");
      out.write("                    return true;\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"cp_error\").innerHTML = \"**Password and Confirm Password does not match\";\n");
      out.write("                    document.getElementById(\"cp\").value = \"\";\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>    \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        <div class=\"frame\">\n");
      out.write("            <h2 class=\"text-center\">Merchant Signup</h2>\n");
      out.write("            <form class=\"form-vertical\" action=\"../merchant_signup\" method=\"post\" enctype=\"multipart/form-data\" onsubmit=\"return go()\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"username\">Username</label>\n");
      out.write("                    <input type = \"text\" name =\"username\" class=\"form-control\"  placeholder=\"Choose a unique username \" onblur=\"validate()\" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"name\">Name</label>\n");
      out.write("                    <input type = \"text\" id=\"name\" class=\"form-control\" name =\"name\" placeholder=\"Enter your full name \" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"photo\">Photo</label>\n");
      out.write("                    <img src=\"\" id=\"img\" style=\"width: 100px;height: 100px;\">\n");
      out.write("                    <input type = \"file\" id=\"photo\" name =\"photo\" onchange=\"readandpreview(this, 'img')\" required>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"address\">Address</label>\n");
      out.write("                    <input type = \"text\" id=\"address\" class=\"form-control\" name =\"address\" placeholder=\"Enter your permanent residence address\" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"city\">City</label>\n");
      out.write("                    <input type = \"text\" id=\"city\" class=\"form-control\" name =\"city\" placeholder=\"Enter your city\" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"state\">State</label>\n");
      out.write("                    <input type = \"text\" id=\"state\" class=\"form-control\" name =\"state\" placeholder=\"Enter your state\" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\">Email</label>\n");
      out.write("                    <input type = \"text\" id=\"email\" class=\"form-control\" name =\"email\" placeholder=\"Enter email\" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"phone\">Mobile number</label>\n");
      out.write("                    <input type = \"text\" id=\"phone\" class=\"form-control\" name =\"phone\"  placeholder=\"Enter your mobile number\" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\">Password</label>\n");
      out.write("                    <input type = \"password\" id=\"password\" class=\"form-control\" name =\"password\" placeholder=\"Enter password\" required=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"cp\">Confirm Password</label>\n");
      out.write("                    <label id=\"cp_error\" class=\"label-danger\"></label>\n");
      out.write("                    <input type = \"password\" id=\"cp\" class=\"form-control\" placeholder=\"Re-enter your password\" >\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <input type = \"submit\" class=\"btn btn-lg btn-primary\" style=\"margin-left: 40%\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
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
