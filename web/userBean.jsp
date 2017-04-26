<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8" %>
<%@page import="net.lastone.model.*" %>
<html>

<head><title>User Bean</title></head>

<body>
<%
    UserBean user=new UserBean();
    user.setName("Deli");
    user.setAge(32);
%>
<h3>Name: <%=user.getName()%></h3>
<h3>Age: <%=user.getAge()%></h3>
</body>

</html>