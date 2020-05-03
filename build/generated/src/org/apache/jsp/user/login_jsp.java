package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("\n");
      out.write("        <!--        <script>\n");
      out.write("                    var xmlhttp = new XMLHttpRequest();\n");
      out.write("                    function login(){\n");
      out.write("                        var username = document.getElementById(\"username\").value;\n");
      out.write("                        var password = document.getElementById(\"password\").value;\n");
      out.write("                        xmlhttp.open(\"post\",\"user_login.jsp?username\"+username+\"&password=\"+password,true);\n");
      out.write("                        xmlhttp.onreadystatechange=function (){\n");
      out.write("                            document.getElementById(\"login_error\").innerHTML = xmlhttp.responseText;\n");
      out.write("                            document.getElementById(\"password\").value=\"\";\n");
      out.write("                           \n");
      out.write("                        };\n");
      out.write("                        xmlhttp.send();\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                </script>    \n");
      out.write("        -->\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <h1 class='text-center'>User Login</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"frame\">\n");
      out.write("            <form class=\"form-vertical\" action=\"../user_login_servlet\" method=\"post\">\n");
      out.write("                <label id='login_error' style=\"color: red; size: 1em; font-style: italic\"></label>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for='username'>Enter the username</label>\n");
      out.write("                    <label id=\"login_error\"></label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id='username' name=\"username\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for='password'>Enter the username</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id='password' name=\"password\"/>\n");
      out.write("                </div>\n");
      out.write("                <input type=\"submit\" class=\"btn btn-primary btn-lg\" onclick=\"login()\" value=\"Login\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");

            String msg = request.getParameter("msg");
            if (msg != null) {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            document.getElementById(\"login_error\").innerHTML = '");
      out.print(msg);
      out.write("';\n");
      out.write("            document.getElementById(\"password\").value = \"\";\n");
      out.write("        </script>\n");
      out.write("        ");

            }
        
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
