package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class add_005fcar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

            String car_name = request.getParameter("car_name1");
            System.out.print("CAR NAME"+car_name);
            String maker = request.getParameter("maker");
            String num_seats =request.getParameter("num_seats");
            String car_type = request.getParameter("car_type");
            String car_price = request.getParameter("car_price");
            String p_per_day = request.getParameter("p_per_day");
            String security = request.getParameter("security");
            
            System.out.print("CAR maker"+maker);
            System.out.print("CAR seats"+num_seats);
            System.out.print("CAR price"+car_price);
            
            String absolutepath = request.getServletContext().getRealPath("/car_images");

            Part part = request.getPart("photo");
            String filename = vmm.FileUploader.savefileonserver(part, absolutepath);
            
            String photo = "./car_images/"+filename;
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from cars where car_name='" + car_name + "'");
            if (rs.next()) 
            {
                response.sendRedirect("manage_cars.jsp?msg=Car Name already exists");
            } else 
            {
//                rs.moveToInsertRow();
//                rs.updateString("car_name", car_name);
//                rs.updateString("maker", maker);
//                rs.updateString("photo", photo);
//                rs.updateString("num_seats", num_seats);
//                rs.updateString("car_type", car_type);
//                rs.updateString("car_price", car_price);
//                rs.updateString("p_per_day", p_per_day);
//                rs.updateString("security", security);
//                rs.insertRow();
                response.sendRedirect("manage_cars.jsp?msg=Car Added Succesfully");
            }


        
      out.write("\n");
      out.write("    ");
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
