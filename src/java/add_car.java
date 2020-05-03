
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig
public class add_car extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        
            String car_name = request.getParameter("car_name").toUpperCase();
            
            String maker = request.getParameter("maker").toUpperCase();
            String num_seats =request.getParameter("num_seats");
            String car_type = request.getParameter("car_type").toUpperCase();
            String car_price = request.getParameter("car_price");
            String p_per_day = request.getParameter("p_per_day");
            String security = request.getParameter("security");
            
            System.out.println("CAR NAME"+car_name);
            System.out.println("CAR maker"+maker);
            System.out.println("CAR seats"+num_seats);
            System.out.println("CAR price"+car_price);
            System.out.println("CAR price per day"+p_per_day);
            System.out.println("CAR security"+security);
            
            try
            {
            
            String absolutepath = request.getServletContext().getRealPath("/car_images");

            Part part = request.getPart("photo");
            String filename = vmm.FileUploader.savefileonserver(part, absolutepath);
            
            String photo = "./car_images/"+filename;
            System.out.println("photo" +photo);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from cars where car_name='" + car_name + "'");
            
            if (rs.next()) 
            {
                response.sendRedirect("manage_cars.jsp?msg=Car Name already exists");
            } else 
            {
                rs.moveToInsertRow();
                rs.updateString("car_name", car_name);
                rs.updateString("maker", maker);
                rs.updateString("photo", photo);
                rs.updateString("num_seats", num_seats);
                rs.updateString("car_type", car_type);
                rs.updateString("car_price", car_price);
                rs.updateString("p_per_day", p_per_day);
                rs.updateString("security", security);
                rs.updateString("type", "4wheeler");
                rs.insertRow();
                response.sendRedirect("admin/manage_cars.jsp?msg=Car Added Succesfully");
            }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                    
    }


}
