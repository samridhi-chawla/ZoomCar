package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class view_005fmerchant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        <div class=\"jumbotron\"><h1 class=\"text-center\">Merchants</h1></div>\n");
      out.write("        ");

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
            //System.out.println("connection amde");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from merchant where status='pending'");
            //System.out.println("query amde");

        
      out.write("\n");
      out.write("        <table class=\"table table-bordered table-responsive table-hover table-striped\">\n");
      out.write("            <caption class=\"caption\">Merchants with Status Pending</caption>\n");
      out.write("            <tr>\n");
      out.write("                <th>Photo</th>\n");
      out.write("                <th>Merchant Name</th>\n");
      out.write("                <th>Username</th>\n");
      out.write("                <th>Password</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>City</th>\n");
      out.write("                <th>State</th>\n");
      out.write("                <th>Mobile number</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>Status</th>\n");
      out.write("                <th></th>\n");
      out.write("                <!--<th>Delete</th>-->\n");
      out.write("\n");
      out.write("            </tr>   \n");
      out.write("\n");
      out.write("            ");
                    while (rs.next()) {
                    String name = rs.getString("username");
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <img src='../");
      out.print(rs.getString("photo"));
      out.write("' width=\"100px\" height=\"100px\"/>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs.getString("name"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(name);
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td type=\"password\">\n");
      out.write("                    ");
      out.print(rs.getString("password"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs.getString("address"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs.getString("city"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs.getString("state"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs.getString("phone"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs.getString("email"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs.getString("status"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"activate_merchant.jsp?name=");
      out.print(name);
      out.write("&q=activate\"><div class=\"btn btn-primary\">Activate</div></a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("        </table>    \n");
      out.write("        ");

            ResultSet rs1 = stmt.executeQuery("select * from merchant where status='active'");
            //System.out.println("query amde");

        
      out.write("\n");
      out.write("        <table class=\"table table-bordered table-responsive table-hover table-striped\">\n");
      out.write("            <caption class=\"caption\">Merchants with Status Active</caption>\n");
      out.write("            <tr>\n");
      out.write("                <th>Photo</th>\n");
      out.write("                <th>Merchant Name</th>\n");
      out.write("                <th>Username</th>\n");
      out.write("                <th>Password</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>City</th>\n");
      out.write("                <th>State</th>\n");
      out.write("                <th>Mobile number</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>Status</th>\n");
      out.write("                <th></th>\n");
      out.write("                <!--<th>Delete</th>-->\n");
      out.write("\n");
      out.write("            </tr>   \n");
      out.write("\n");
      out.write("            ");
                    
                while (rs1.next()) {
                    String name = rs1.getString("username");
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <img src='../");
      out.print(rs1.getString("photo"));
      out.write("' width=\"100px\" height=\"100px\"/>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs1.getString("name"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(name);
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td type=\"password\">\n");
      out.write("                    ");
      out.print(rs1.getString("password"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs1.getString("address"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs1.getString("city"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs1.getString("state"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs1.getString("phone"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs1.getString("email"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(rs1.getString("status"));
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"activate_merchant.jsp?name=");
      out.print(name);
      out.write("&q=deactivate\"><div class=\"btn btn-primary\">Deactivate</div></a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("        </table>    \n");
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
