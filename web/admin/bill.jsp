
<%@page import="vmm.SMSsender"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <%
        java.util.Date date_of_billing = new java.util.Date();
        long dtformat = date_of_billing.getTime();
        String bill_id = request.getParameter("bill_id");
        Date to_date = Date.valueOf(request.getParameter("to_date"));
        String extra_charges = request.getParameter("extra_charges");
        String tot_amt = request.getParameter("tot_amt");
        String remarks = request.getParameter("remarks");
        String taxes = request.getParameter("taxes");
        String coupon_used = request.getParameter("coupon_used");
        String discount = request.getParameter("discount");
        String net_amt = request.getParameter("net_amt");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoomcar", "root", "system");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from car_billing where bill_id='" + bill_id + "'");
        if (rs.next()) {

            rs.updateDate("date_of_billing", new java.sql.Date(dtformat));
            rs.updateDate("to_date", to_date);
            rs.updateString("extra_charges", extra_charges);
            rs.updateString("extra_charges", extra_charges);
            rs.updateString("tot_amt", tot_amt);
            rs.updateString("remarks", remarks);
            rs.updateString("taxes", taxes);
            rs.updateString("coupon_used", coupon_used);
            rs.updateString("discount", discount);
            rs.updateString("net_amt", net_amt);
            rs.updateRow();
            Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("SELECT username,phone_no FROM users,car_booking where car_booking.user=users.username and car_booking.bill_id='" + bill_id + "' group by bill_id, car_id, user,p_per_day ;");
            if (rs1.next()) {
                String phone_no = rs1.getString("phone_no");
                String username = rs1.getString("username");
                String url = "http://192.168.1.103/ZoomCar/user/view_bill.jsp?bill_id="+bill_id;
                String msg = "Hello "+username+", Thanks for riding with us. You can view your bill at "+url;
                vmm.SMSsender obj = new SMSsender(phone_no, msg, "text");
                Thread t = new Thread(obj);
                t.start();
            }
    %>

    <body>
        <jsp:include page="admin_header.jsp"/>
        <div class="container" style="margin-top: 3%">
            <h1>Thank you for Riding with us.</h1>
            <h2>Your net payable amount is <%=net_amt%></h2>
            <a href="bill_payment.jsp?net_amt=<%=net_amt%>"><div class="btn btn-lg btn-primary">Proceed to Bill Payment</div></a>
            <div class="btn btn-lg btn-primary">Send SMS to User</div>
            <a href="view_booking.jsp"><h2><span class="glyphicon glyphicon-backward"></span>Go Back</h2></a>
            <!--//card or cash payment--> 


            <%
                } else {
                    out.println("else");
                }

            %>
        </div>
    </body>
</html>