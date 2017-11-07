<%--
  Created by IntelliJ IDEA.
  User: hilmi
  Date: 07/11/2017
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="loginServlet" method="post">
        Name:<input type="text" name="username"/><br/><br/>
        Password:<input type="password" name="userpass"/><br/><br/>
        <input type="submit" value="login"/>
    </form>
</body>
</html>
