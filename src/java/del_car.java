import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class del_car extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String car_name = request.getParameter("name");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ZoomCar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from cars where car_name='" + car_name + "'");
            if (rs.next()) 
            {
                rs.deleteRow();
                response.sendRedirect("admin/manage_cars.jsp?msg="+car_name+" record deleted");
            } 
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

   

}
