package serverForMobile;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class get_cars_mobile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json");
        try {
            PrintWriter out = response.getWriter();
            JSONArray jSONArray = new JSONArray();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from cars");
            while(rs.next()){
                JSONObject jo=new JSONObject();
                jo.put("car_name",rs.getString("car_name"));
                jo.put("maker",rs.getString("maker"));
                jo.put("photo",rs.getString("photo"));
                jo.put("num_seats",rs.getString("num_seats"));
                jo.put("car_type",rs.getString("car_type"));
                jo.put("car_price",rs.getString("car_price"));
                jo.put("security",rs.getString("security"));
                jo.put("type",rs.getString("type"));
                jSONArray.add(jo);
            }
            out.println(jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        processRequest(request, response);
    }

}
