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
    <title>PR-OJEK</title>
    <link rel="stylesheet" type="text/css" href="css/login-regist.css">
    <script type="text/javascript" src="js/validate.js"></script>
</head>

<body>
<div class="form">
    <%
        if (session.getAttribute("UNUserAktif") == null) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("profile.jsp");
        }
    %>
</div>
</body>
</html>
