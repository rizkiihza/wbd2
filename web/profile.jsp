<%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/5/17
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="profile_data.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="css/profile.css" type="text/css">
</head>
<body>
<div id="frame">
    <header>
        <div id=logo>
            <h2 id="main-logo"><span id="logo1">PR-</span><span
                    id="logo2">OJEK</span></h2>
            <p id="sub-logo">wush... wush... ngeeeeeenggg...</p>
        </div>
        <div id=user-stat>
            <p id=greeting>Hi, <b> <% out.print(session.getAttribute("UNUserAktif")); %> </b> !</p>
            <a href="index.jsp">Logout</a>
        </div>
    </header>
    <div id="navbar">
        <ul>
            <li><a href="order.jsp?id_active=<%out.print(user.ID);%>">ORDER</a></li>
            <li><a href="history.jsp?id_active=<%out.print(user.ID);%>">HISTORY</a></li>
            <li><a href="#" class="active">MY PROFILE</a></li>
        </ul>
    </div>
    <div id="profile">
        <h2>MY PROFILE</h2>
        <a href="change_profile.jsp?id_active=<%out.print(user.ID);%>"><img src="img/pencil-edit-button.png"
                                                                          alt="edit-profile" class="edit-button"></a>
        <div id="main-profile">
            <img src="<%out.print(user.Foto);%>" alt="profile-picture"
                 id="profile-pic"
                 onerror="this.onerror=null;this.src='img/profile-default.jpg';">
            <h3>@<%out.print(user.Username);%></h3>
            <p><%out.print(user.Name);%></p>
            <%
                if (user.Driver.equals("1")) {
                    out.print("Driver | <span id=\"rate_avg\">&#9734;" + user.AvgRating + "</span> (" + user.Vote  + " votes)");
                } else {
                    out.print("Non-Driver");
                }
            %>
            <p>&#9993;<%out.print(user.Email);%></p>
            <p>&#9743;<%out.print(user.Phone);%></p>
        </div>
    </div>
    <%
        out.print("<div id=\"location\"> " +
                "<h2>PREFERRED LOCATION:</h2> " +
                "<a href=\"edit_location.jsp?id_active=" + user.ID+ "\">  " +
                "<img src=\"img/pencil-edit-button.png\" alt=\"edit-preferred-location\"" +
                "class=\"edit-button\"> </a>" +
                "<ul>");
        for (int i = 0; i < user.Locations.size(); i++) {
            out.print("<li id='bawah'>" + user.Locations.get(i) + "</li>");
        }
        out.print("</ul></div>");
//        <?php foreach ($locations as $value) {
//            echo "<li id='bawah'>".$value."</li>";
//        }
//        ?>
//    </ul>
//</div>
//<?php endif; ?>
    %>

</div>
</body>
</html>
