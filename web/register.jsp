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
    <title>PR-OJEK</title>
    <link rel="stylesheet" type="text/css" href="css/login-regist.css">
    <script type="text/javascript" src="js/check.js"></script>
    <script type="text/javascript" src="js/validate.js"></script>
</head>
<body>
<div class="form">
    <div>
        <div class="judul">
            <div id="hiasan"><hr></div>
            <div id="tengah"><h1>SIGN UP</h1></div>
            <div id="hiasan"><hr></div>
        </div>
        <form action="registerServlet" method="post" onsubmit="return validateRegister()">
            <table id="table1">
                <tr>
                    <th><label>Your Name</label></th>
                    <th><input id="name" type="text" name="fullname" placeholder="" /></th>
                </tr>
            </table>
            <table id="table2">
                <tr>
                    <td><label>Username</label></td>
                    <td>
                        <input type="text" id="username" name="username" onkeyup="checkUsername(this.value)" placeholder="" />
                    </td>
                    <td id="check1"></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td>
                        <input type="text" id="email" name="email" onkeyup="checkEmail(this.value)" placeholder=""/>
                    </td>
                    <td id="check2"></td>
                </tr>
            </table>
            <table id="table1">
                <tr>
                    <th><label>Password</label></th>
                    <th><input id="password" type="password" name="password" placeholder=""/></th>
                </tr>
                <tr>
                    <th><label>Confirm Password</label></th>
                    <th><input id="copassword" type="password" name="confirm_password" placeholder=""/></th>
                </tr>
                <tr>
                    <th><label>Phone Number</label></th>
                    <th><input id="phone_number" type="text" name="phone" placeholder=""/></th>
                </tr>
            </table>
            <div id="driv">
                <input type="checkbox" value="Yes" id="check" name="is_driver"  /><label>Also sign me up as a driver!</label>
            </div>
            <br>
            <label id="pindah"><a href="index.jsp">Already have an account?</a></label>
            <button type="submit" id="register" name="register" >REGISTER</button>
        </form>
    </div>
</div>
</body>
</html>

