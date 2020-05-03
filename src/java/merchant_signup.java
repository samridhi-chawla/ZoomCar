
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.Part;

@MultipartConfig
public class merchant_signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try 
        {
            PrintWriter out = response.getWriter();
           
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String name = request.getParameter("name");
                String city = request.getParameter("city").toUpperCase();
                String state = request.getParameter("state").toUpperCase();
                
                Part part = request.getPart("photo");
                String absolutepath = request.getServletContext().getRealPath("/merchant_images");
                String filename = vmm.FileUploader.savefileonserver(part, absolutepath);
                String photo = "./merchant_images/"+filename;
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from merchant where username='" + username + "'");
                if(rs.next())
                {
                    response.sendRedirect("merchant/sign_up.jsp?msg=username already exists");
                }
                else
                {
                    rs.moveToInsertRow();
                    rs.updateString("username", username);
                    rs.updateString("password", password);
                    rs.updateString("name", name);
                    rs.updateString("email", email);
                    rs.updateString("address", address);
                    rs.updateString("phone", phone);
                    rs.updateString("photo", photo);
                    rs.updateString("status", "pending");
                    rs.updateString("city", city);
                    rs.updateString("state", state);
                    
                    Date date = new Date(System.currentTimeMillis());
                    System.out.println(date.toString());
                    rs.updateString("joiningdate", date.toString());
                    
                    rs.insertRow();
                    response.sendRedirect("merchant/login.jsp");
                }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

  

}
