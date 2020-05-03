
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
public class get_car_details extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      PrintWriter out = response.getWriter();
      try {
            String car_name = request.getParameter("car_name");
            String car_id = request.getParameter("car_id");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("select * from cars where car_name='"+car_name+"'");
            
            if(rs.next()) 
            {
                out.println(car_id+","+rs.getString("photo")+","+rs.getString("maker")+","+rs.getString("num_seats")+","+rs.getString("car_price")+","+rs.getString("p_per_day")+","+rs.getString("security"));
            }
            else
            {
                out.println("gadbad");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
