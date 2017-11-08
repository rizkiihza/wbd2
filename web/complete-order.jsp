<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07/11/2017
  Time: 20.34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PR-OJEK Complete Order</title>
    <link rel="stylesheet" href="css/order.css" type="text/css">
</head>
<body>

<div id="frame">
    <header class="clearfix">
        <div id=logo>
            <h2 id="main-logo"><span id="logo1">PR-</span><span id="logo2">OJEK</span></h2>
            <p id="sub-logo">wush... wush... ngeeeeeenggg...</p>
        </div>
        <div id=user-stat>
            <p id=greeting>Hi, <b><%=session.getAttribute("UNUserAktif")%></b> !</p>
            <a href="#">Logout</a>
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
        <div id="step1" class="division">
            <div class="circle">1</div>
            <p>Select Destination</p>
        </div>
        <div id="step2" class="division">
            <div class="circle">2</div>
            <p>Select a Driver</p>
        </div>
        <div id="step3" class="division active">
            <div class="circle">3</div>
            <p>Complete your Order</p>
        </div>
    </div>
    <div id="complete-order">
        <div id = "identity">

            <jsp:include page="/OrderServlet"/>
        </div>

    <form  id="complete-order-form" action="/OrderServlet" method="post" onsubmit="setDriverId()">
        <p id="rating" type="hidden" style="display:none">6.1</p>
        <div id="box-rate">
            <div class="rate">
                <input type="radio" id="star5" name="rate" value="5" />
                <label for="star5" title="text">5 stars</label>
                <input type="radio" id="star4" name="rate" value="4" />
                <label for="star4" title="text">4 stars</label>
                <input type="radio" id="star3" name="rate" value="3" />
                <label for="star3" title="text">3 stars</label>
                <input type="radio" id="star2" name="rate" value="2" />
                <label for="star2" title="text">2 stars</label>
                <input type="radio" id="star1" name="rate" value="1" />
                <label for="star1" title="text">1 star</label>
            </div>
        </div>
        <textarea id="user-text" rows="4"  name="comment" placeholder="Write your experience about The Driver.."></textarea>
        <button type="submit" class="button-complete-order" name="complete" />Complete Order</button>
    </form>
    </div>
</div>
    <script type="text/javascript" src="js/order.js"></script>
</body>
</html>
