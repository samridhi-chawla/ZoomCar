<%@page import="java.util.Calendar"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page import="java.sql.*"%>
<%
    int car_id = Integer.parseInt(request.getParameter("c_id"));
    String from = (String) session.getAttribute("session_city");
//    if (from == null) {
//        response.sendRedirect("home.jsp");
//    }
    String user = (String) session.getAttribute("username");

    String to = request.getParameter("to");
    Date from_date = Date.valueOf(request.getParameter("date_issue"));
    Date to_date = Date.valueOf(request.getParameter("date_return"));
    String num_days = request.getParameter("num_days");
    String p_per_day = request.getParameter("p_per_day");
    String security = request.getParameter("security");
    String tot_amt = request.getParameter("tot_amt");
    int ONE_DAY = 1000 * 24 * 60 * 60;
    Date date_of_booking = new Date(Calendar.getInstance().getTimeInMillis());

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
    Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs3 = stmt3.executeQuery("select * from car_booking where car_id='"+car_id+"' and booking_date between '"+from_date+"' and '"+to_date+"'");
    String s="";
    while(rs3.next()){
         s= s+" "+rs3.getString("booking_date");
    }
    if(!s.isEmpty()){
        response.sendRedirect("error_booking.jsp?s="+s);
    }
    else{
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("select * from car_booking ");

    Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs1 = stmt1.executeQuery("select * from car_billing");
    rs1.moveToInsertRow();
    rs1.updateDate("from_date", from_date);
    rs1.updateDate("to_date", to_date);
    rs1.updateDate("date_of_booking", date_of_booking);
    rs1.insertRow();
    //stmt to get the billing id genereated
    Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs2 = stmt2.executeQuery("select max(bill_id)as b_id from car_billing");

    int bill_id = 0;
    if (rs2.next()) {
        bill_id = rs2.getInt("b_id");
    }
    for (int i = 1; i <= Integer.parseInt(num_days); i++) {
        
            rs.moveToInsertRow();
            rs.updateInt("car_id", car_id);
            rs.updateString("user", user);
            rs.updateString("p_per_day", p_per_day);
            rs.updateDate("booking_date", from_date);
            rs.updateInt("bill_id", bill_id);
            rs.insertRow();
            from_date = new Date(from_date.getTime() + ONE_DAY);
        
    }
//    if (true) {
        response.sendRedirect("thanks_booking.jsp");
//    }
    }
%>