<%
session.removeAttribute("username");
session.removeAttribute("city");
response.sendRedirect("login.jsp");
%>