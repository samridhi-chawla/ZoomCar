
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class get_cars extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String car_type = request.getParameter("car_type");
        String car_id = request.getParameter("car_id");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("select distinct car_name from cars where car_type='"+car_type+"'");
            out.println(car_id+",");
            out.println("<option disabled selected value=''>Select the car</option>");
            
            while(rs.next()) 
            {
                out.println("<option>"+rs.getString("car_name")+"</option>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
