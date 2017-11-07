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
    <div>
        <div class="judul">
            <div id="hiasan"><hr></div>
            <div id="tengah"><h1>LOGIN</h1></div>
            <div id="hiasan"><hr></div>
        </div>
        <br><br>
        <form action="loginServlet" method="post" onsubmit="return validateLogin()">
            <table id="login">
                <tr>
                    <th class="masuk"><label>Username</label></th>
                    <th><input id="username" type="text" name="username" placeholder="" /></th>
                </tr>
                <tr>
                    <th class="masuk"><label>Password</label></th>
                    <th><input id="password" type="password" name="userpass" placeholder="" /></th>
                </tr>
            </table>
            <br><br><br><br>
            <label id="pindah"><a href="register.jsp">Don't have an account?</a></label>
            <button type="submit" id="go" name="login" >GO!</button>
        </form>
    </div>
</div>
</body>
</html>
