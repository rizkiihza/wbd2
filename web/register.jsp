<%--
  Created by IntelliJ IDEA.
  User: hilmi
  Date: 07/11/2017
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="registerServlet" method="post">
    Your Name :<input type="text" name="fullname"/><br/><br/>
    Username :<input type="text" name="username"/><br/><br/>
    Password :<input type="password" name="password"/><br/><br/>
    Confirm Password :<input type="password" name="confirm_password"/><br/><br/>
    Phone Number :<input type="text" name="phone"/><br/><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
