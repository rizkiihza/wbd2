<%@ page import="ws.OjekWSImpl" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04/11/2017
  Time: 01.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="profile_data.jsp"%>
<html>
<head>
    <title>PR-OJEK Order</title>
    <link rel="stylesheet" href="css/order.css" type="text/css">
</head>
<body>

<%
    OjekWSImpl.validateAccess((String)session.getAttribute("TokenUserAktif"));
%>
<div id="frame">
    <header class="clearfix">
        <div id=logo>
            <h2 id="main-logo"><span id="logo1">PR-</span><span id="logo2">OJEK</span></h2>
            <p id="sub-logo">wush... wush... ngeeeeeenggg...</p>
        </div>
        <div id=user-stat>
            <p id=greeting>Hi, <b><%=session.getAttribute("UNUserAktif")%></b> !</p>
            <a href="logout.jsp">Logout</a>
        </div>
    </header>

    <div id="navbar">
        <ul>
            <li><a href="#" class="active">ORDER</a></li>
            <li><a href="history.jsp?id_active=<%=session.getAttribute("IDUserAktif")%>">HISTORY</a></li>
            <li><a href="profile.jsp?id_active=<%=session.getAttribute("IDUserAktif")%>">MY PROFILE</a></li>
        </ul>
    </div>

    <div id="order-title">
        <h2>MAKE AN ORDER</h2>
    </div>


    <div id="order-flow">
        <div id="step1" class="division active">
            <div class="circle">1</div>
            <p>Select Destination</p>
        </div>
        <div id="step2" class="division">
            <div class="circle">2</div>
            <p>Select a Driver</p>
        </div>
        <div id="step3" class="division">
            <div class="circle">3</div>
            <p>Complete your Order</p>
        </div>
    </div>
    <div id="select-destination">
        <form  id="destination-form" action="select-driver.jsp" method="post" onsubmit="return validateField()">
            <table style="margin:auto">
                <tr>
                    <th><label class="label">Picking point <span></span></label></th>
                    <th><input type="text" id="driver-pick-point" name="picking-point" class="input-order"></th>
                </tr>
                <tr>
                    <th><label class="label">Destination <span></span></label></th>
                    <th><input type="text" id="driver-destination" name="destination" class="input-order"></th>
                </tr>
                <tr>
                    <th><label class="label">Preferred Driver <span></span></label></th>
                    <th><input type="text" name="pref-driver" class="input-order" placeholder="(optional)"></th>
                </tr>
            </table>
            <button type="submit" id="button" name="next" />NEXT</button>
        </form>
    </div>
</div>

    <script type="text/javascript" src="js/order.js"></script>
</body>
</html>
