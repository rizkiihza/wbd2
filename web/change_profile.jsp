<%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/7/17
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="profile_data.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile Information</title>
    <link rel="stylesheet" href="css/edit-profile.css" type="text/css">
</head>
<body>
<div id="frame">
    <form action="change_profile_data.jsp">
    <h2 id="title">EDIT PROFILE INFORMATION</h2>
    <img src="<%out.print(user.Foto);%>" alt="profile-picture"
         id="profile-pic"
         onerror="this.onerror=null;this.src='img/profile-default.jpg';">
        <<a href="change_pic.jsp">edit picture</a>
        <table class="clear" id="name-phone-table">
            <tr>
                <td id="left-column"><label for="name" class="label">Your Name</label></td>
                <td><input class="field" type="text" name="name" id="name" value="<%out.print(user.Name);%>" onclick="this.select()"></td>
            </tr>
            <tr>
                <td><label for="phone" class="label">Phone</label></td>
                <td><input type="text" name="phone" class="field" id="phone" value="<%out.print(user.Phone);%>" onclick="this.select()"></td>
            </tr>
            <tr>
                <td><label class="label">Status Driver</label></td>
                <td id="toggle">
                    <label class="switch">
                        <input type="checkbox" name="driver_stat" <% if(user.Driver.equals("1")) {out.print("checked");}%>>
                        <span class="slider round"></span>
                    </label>
                </td>
            </tr>
        </table>
        <input type="submit" value="SAVE" id="submit">
    </form>
    <a href="profile.jsp?id_active=<%out.print(user.ID);%>" id="back">BACK</a>
</div>
<script src="js/edit-profile.js"></script>
</body>
</html>