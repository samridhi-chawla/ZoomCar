<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css.css" rel="stylesheet" type="text/css"/>
        <script src="../js/jquery-3.2.0.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page= "admin_header.jsp" />
        <div class="container" style="margin-top: 5%">
            <%
                
            double net_amt_payable=Double.parseDouble(request.getParameter("net_amt"));
            double net=net_amt_payable*100;
            
            %>
            <form action="payment_success.jsp" method="post">

                <!-- receive ur normal text data on next page , like we do regularly -->

                <!--<input type="text"  name="t1" />-->

                <label> Net payable Amount :  <%=net_amt_payable%></label><br>
                
                    
                <!-- Note that the amount is in paise = 500 INR -->
                <!-- This script will show payment screen and block form submit until, payment is successful -->
                <script
                    src="https://checkout.razorpay.com/v1/checkout.js"
                    data-key="rzp_test_96HeaVmgRvbrfT"
                    data-amount="<%=net%>"
                    data-buttontext="Proceed to Payment"
                    data-name="Shopohop"
                    data-description="Thank You for shopping with Shopohop."
                    data-image="http://vmmeducation.com/images/newlogo.png"
                    data-prefill.name="Amrinder Singh"
                    data-prefill.email=""
                    data-theme.color="#F33F54"
                ></script>
                <input type="hidden" value="Hidden Element" name="hidden">
            </form>
        </div>
    </body>
</html>
