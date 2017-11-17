<%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/7/17
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%
    if (session.getAttribute("TokenUserAktif") == null) {
        String site = new String("login.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    } else {
%>
<%@include file="history_data.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>History</title>
    <link rel="stylesheet" href="css/history.css" type="text/css">
</head>
<body>

<div id="frame">
    <header class="clearfix">
        <div id=logo>
            <h2 id="main-logo"><span id="logo1">PR-</span><span id="logo2">OJEK</span></h2>
            <p id="sub-logo">wush... wush... ngeeeeeenggg...</p>
        </div>
        <div id=user-stat>
            <p id=greeting>Hi, <b><% out.print(session.getAttribute("UNUserAktif")); %></b> !</p>
            <a href="logout.jsp">Logout</a>
        </div>
    </header>
    <div id="navbar">
        <ul>
            <li><a href="order.jsp?id_active=<%=session.getAttribute("IDUserAktif")%>">ORDER</a></li>
            <li><a href="#" class="active">HISTORY</a></li>
            <li><a href="profile.jsp?id_active=<%=session.getAttribute("IDUserAktif")%>">MY PROFILE</a></li>
        </ul>
    </div>
    <div id="history-title">
        <h2>HISTORY</h2>
    </div>

    <div id="history-step">
        <div id="step1" class="division active" onclick="previousOrder()">
            <p>MY PREVIOUS ORDERS</p>
        </div>
        <div id="step2" class="division" onclick="driverHistory()">
            <p>DRIVER HISTORY</p>
        </div>
    </div>

    <div id="previous-order">
        <%
            int i = 0;
            for (history h : listPreviousDriver.getList()) {
        %>
        <div class="driver" <% if (h.isHidden()) out.print("style='display:none;'");%> >
            <form action="updatePreviousOrder" method="post">
                <img id="img<%=i%>" class="img-driver" src="<%=h.getImg()%>" alt="<%=h.getName()%>">
                <p id="date<%=i%>" class="date-driver"><%=h.getDate()%>
                </p>
                <p id="name<%=i%>" class="name-driver"><%=h.getName()%>
                </p>
                <p id="path<%=i%>" class="path-driver"><%=h.getPick()%> - <%=h.getDest()%>
                </p>
                <p id="rate<%=i%>" class="rate-driver">&#9734 <%=h.getRate()%>
                </p>
                <p id="comment<%=i%>" class="comment-driver">comments : <%=h.getComment()%>
                </p>
                <input id="user-id<%=i%>" type="hidden" name="cust_id" value="<%= (String) session.getAttribute("IDUserAktif") %>"/>
                <input id="data-id<%=i%>" type="hidden" name="order_id" value="<%=h.getID()%>"/>
                <button type="submit" class="button-hide-driver" name="hide">Hide</button>
            </form>
        </div>

        <%
                i++;
            }
        %>
    </div>


    <div id="driver-history">
        <%
            i = 0;
            for (history d : listDriverHistory.getList()) {
        %>
        <div id="driver<%=d.getID()%>" class="driver" <%
            if (d.isHidden()) out.print("style='display:none;'");%> >
            <form action="updateDriverHistory" method="post">
                <img id="img-pass<%=i%>" class="img-driver" src="<%=d.getImg()%>" alt="<%=d.getName()%>">
                <p id="date-pass<%=i%>" class="date-driver"><%=d.getDate()%>
                </p>
                <p id="name-pass<%=i%>" class="name-driver"><%=d.getName()%>
                </p>
                <p id="path-pass<%=i%>" class="path-driver"><%=d.getPick()%> - <%=d.getDest()%>
                </p>
                <p id="rate-pass<%=i%>" class="rate-driver">&#9734 <%=d.getRate()%>
                </p>
                <p id="comment-pass<%=i%>" class="comment-driver">comments : <%=d.getComment()%>
                </p>
                <input id="position-id<%=i%>" type="hidden" name="position_id" value="2"/>
                <input id="content-id<%=i%>" type="hidden" name="content_id" value="<%=i%>"/>
                <input id="user-id<%=i%>" type="hidden" name="order_id" value="<%=d.getID()%>"/>
                <input id="data-id<%=i%>" type="hidden" name="driver_id" value="<%= (String) session.getAttribute("IDUserAktif") %>"/>
                <button class="button-hide-driver" name="hide" >Hide</button>
            </form>
        </div>

        <%
                i++;
            }
        %>
    </div>

</div>

<script>

    <% if (request.getParameter("tampilan") != null) {
        if (request.getParameter("tampilan").equals("kanan")) {
            out.print("driverHistory();");
        }
    }
    %>

    function driverHistory() {
        document.getElementById("previous-order").style.display = 'none';
        document.getElementById("driver-history").style.display = 'block';

        document.getElementById('step1').className = 'division';
        document.getElementById('step2').className += ' active';
    }

    function previousOrder() {

        document.getElementById("driver-history").style.display = 'none';
        document.getElementById("previous-order").style.display = 'block';

        document.getElementById('step2').className = 'division';
        document.getElementById('step1').className += ' active';
    }


</script>
<%
    }
    %>
%>
</body>
</html>
