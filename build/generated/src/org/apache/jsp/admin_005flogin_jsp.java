package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Login</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/css.css\" rel=\"stylesheet\" type =\"text/css\"/>\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"back\" >\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"frame\">\n");
      out.write("            \n");
      out.write("            <h1 class=\"text-center\">Admin Login</h1>\n");
      out.write("                ");

                    String q = request.getParameter("q");
                    if(q!=null)
                    {

                        
      out.write("\n");
      out.write("                        <h4>");
      out.print(q);
      out.write("</h4>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                    }

                
      out.write("\n");
      out.write("                \n");
      out.write("                    <form class=\"form-vertical\" action=\"check_admin_login.jsp\" method=\"get\" >\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"username\"> Enter Username</label>\n");
      out.write("                            <input type = \"text\" id=\"username\" class=\"form-control\" name =\"username\" placeholder=\"Enter Username\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=password\"> Enter Password </label>\n");
      out.write("                            <input type = \"password\" id=\"password\" class=\"form-control\" name =\"password\" placeholder=\"Enter Password\" required=\"\">\n");
      out.write("                        </div>    \n");
      out.write("                            <input class=\"form-control btn btn-sm btn-primary\" type = \"submit\" value=\"Login\">\n");
      out.write("                               \n");
      out.write("\n");
      out.write("                    </form>            \n");
      out.write("\n");
      out.write("                <a href =\"recover_pass.jsp\">Recover Admin Password</a>\n");
      out.write("              \n");
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
