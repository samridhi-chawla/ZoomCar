package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Sign Up</title>\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    ");

    String msg = request.getParameter("msg");
    if(msg!=null)
    {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert(\"");
      out.print(msg);
      out.write("\");\n");
      out.write("            </script>\n");
      out.write("        ");

    }
    
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function go()\n");
      out.write("        {\n");
      out.write("            if(document.getElementById(\"password\").value==document.getElementById(\"cp\"))\n");
      out.write("            {\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("            else \n");
      out.write("            {   \n");
      out.write("                document.getElementById(\"cp_error\").innerHTML=\"**Password and Confirm Password do not match\";\n");
      out.write("                document.getElementById(\"cp\").value=\"\";\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        var xmlhttp = new XMLHttpRequest();\n");
      out.write("        function check_unique()\n");
      out.write("        {   \n");
      out.write("            var name = document.getElementById(\"username\").value;\n");
      out.write("            xmlhttp.open(\"get\",\"../check_unique_user?name=\"+name,true);\n");
      out.write("            xmlhttp.onreadystatechange=checked;\n");
      out.write("            xmlhttp.send();\n");
      out.write("        }\n");
      out.write("        function checked()\n");
      out.write("        {\n");
      out.write("            if(xmlhttp.readyState==4 && xmlhttp.status==200)\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"username_error\").innerHTML=xmlhttp.responseText;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        <div class=\"frame\">\n");
      out.write("            <form class=\"form-vertical\" action=\"user_signup.jsp\" method=\"post\" onsubmit=\"go()\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"username\">Choose a unique username</label>\n");
      out.write("                    <label id=\"username_error\"></label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" onblur=\"check_unique()\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\">Enter your email</label>\n");
      out.write("                    <input type=\"email\" id=\"email\" name=\"email\" class=\"form-control\" />\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"phone_no\">Enter your 10 digit mobile number</label>\n");
      out.write("                    <input type=\"text\" id=\"phone_no\" name=\"phone_no\" class=\"form-control\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\">Enter Password</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"cp\">Re-Enter Password</label>\n");
      out.write("                    <label id=\"cp_error\" style=\"color:red\"></label>\n");
      out.write("                    <input type=\"password\" id=\"cp\" class=\"form-control\" />\n");
      out.write("                </div>\n");
      out.write("                <input type=\"submit\" class=\"btn btn-primary btn-lg\" value=\"Sign_up\"/>\n");
      out.write("            </form>\n");
      out.write("            \n");
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
