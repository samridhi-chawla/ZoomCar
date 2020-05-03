package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class generate_005fbill_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../includes/header.jsp", out, false);
      out.write("\n");
      out.write("        ");

            int bill_id = Integer.parseInt(request.getParameter("bill_id"));
            java.util.Date date_of_billing = new java.util.Date();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from car_billing where bill_id='" + bill_id + "'");
            String date_of_booking = rs.getString("from_date");
            String date_of_return = rs.getString("to_date");
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form action=\"bill.jsp\" method='post'>\n");
      out.write("                <h1>Bill of (user's name)<span style=\"float: right\">Dated: <input type=\"text\" value=\"");
      out.print(date_of_billing);
      out.write("\" name='date_of_billing'/></span></h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-6\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <img src=\"\" class=\"img-responsive img-thumbnail\" style=\"margin-left: 20%\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <table class=\"table table-responsive\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><label>Bill Id</label></td>\n");
      out.write("                                    <td></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><label>Car Id</label></td>\n");
      out.write("                                    <td></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <td><label>Car Name</label></td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><label>Booked By</label></td>\n");
      out.write("                                    <td></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><label>Owner</label></td>\n");
      out.write("                                    <td></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><label>Booked From</label></td>\n");
      out.write("                                    <td></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><label>Booked To</label></td>\n");
      out.write("                                    <td></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-6\">\n");
      out.write("                        <table class=\"table table-responsive\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Date of car return</label></td>\n");
      out.write("                                <td><input type=\"date\" class='form-control'/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Number of Days</label></td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" id='num_days' disabled/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Rent per Day</label></td>\n");
      out.write("                                <td><input type=\"text\" class=\"form-control\" id='p_per_day' value=\"\" disabled/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Extra Charges</label></td>\n");
      out.write("                                <td><input type=\"number\" id='extra_charges' name='extra_charges'</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Remarks</label></td>\n");
      out.write("                                <td><input type=\"text\" name='remarks' class=\"form-control\"/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Taxes</label></td>\n");
      out.write("                                <td><input type=\"number\" name=\"taxes\" id='taxes'/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Enter Coupon code(if any)</label></td>\n");
      out.write("                            <input type=\"text\" name='coupon_used' class='form-control'/>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Discount</label></td>\n");
      out.write("                                <td><input type='number' class=\"form-control\" id='discount'/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><label>Net Payable Amount</label></td>\n");
      out.write("                                <td><input type=\"text\" id='net_amt' name='net_amt' class=\"form-control\" disabled/></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"btn btn-lg btn-primary\" style=\"margin-left: 40%\">Generate Bill</div>\n");
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
