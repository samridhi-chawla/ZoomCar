package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class view_005fbooking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("        var xmlhttp = new XMLHttpRequest();  \n");
      out.write("        function getbookings()\n");
      out.write("            {\n");
      out.write("                var month = document.getElementById(\"month\").value;\n");
      out.write("                xmlhttp.open(\"get\",\"get_bookings.jsp?month=\"+month,true);\n");
      out.write("                xmlhttp.onreadystatechange=function (){\n");
      out.write("                    document.getElementById(\"set_bookings\").innerHTML=xmlhttp.responseText;\n");
      out.write("                };\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            function generate_bill(bill_id){\n");
      out.write("                window.location.href=\"generate_bill.jsp?bill_id=\"+bill_id;\n");
      out.write("            }\n");
      out.write("        </script>    \n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        <div class=\"jumbotron\"><h2 class=\"text-center\">View Bookings</h2></div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <div class=\"col-xs-4\"><label for=\"month\">Select the month you want to view the bookings of</label></div>\n");
      out.write("            <div class=\"col-xs-3\"><input type=\"month\" class=\"form-control\" id=\"month\" name=\"month\" onchange=\"getbookings()\"/></div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"set_bookings\" class=\"row\" style=\"margin-top: 15px;\"></div>\n");
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
