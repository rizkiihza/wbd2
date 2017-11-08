<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %>
<%@ page import="driver.driver"%>
<%@ page import="ws.StringArray" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04/11/2017
  Time: 01.54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PR-OJEK Select Driver</title>
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
            <p id=greeting>Hi, <b><?php echo $user['username']; ?></b> !</p>
            <a href="index.php">Logout</a>
        </div>
    </header>

    <div id="navbar">
        <ul>
            <li><a href="#" class="active">ORDER</a></li>
            <li><a href="history.php?id_active=<?php echo $user_id; ?>">HISTORY</a></li>
            <li><a href="profile.php?id_active=<?php echo $user_id; ?>">MY PROFILE</a></li>
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
        <div id="step2" class="division active">
            <div class="circle">2</div>
            <p>Select a Driver</p>
        </div>
        <div id="step3" class="division">
            <div class="circle">3</div>
            <p>Complete your Order</p>
        </div>
    </div>
    <%
        OjekWSImplService driverService = new OjekWSImplService();
        OjekWS eif = driverService.getPort(OjekWS.class);
        StringArray driverResult = eif.getDriver(request.getParameter("picking-point"),
                request.getParameter("destination"), request.getParameter("pref-driver"));
        List<String> list = driverResult.getItem();
        ArrayList<driver> pref = new ArrayList<driver>();
        boolean isPref = false;
        ArrayList<driver> other = new ArrayList<driver>();
        int x = 0;
        for (String i : list) {
            driver d = new driver();
            d.fromJson(i);
            if (x == 0 && d.getStatus().equals("Preferred Driver")) {
                isPref = true;
                pref.add(d);
            } else {
                other.add(d);
//                out.print(d.toJson());
            }
            x++;
//            out.print(d.toJson());
        }

        session.setAttribute("pickPoint", request.getParameter("picking-point"));
        session.setAttribute("dest", request.getParameter("destination"));
    %>
    <div id="select-driver">
        <div id="preferred-driver">
            <p class="order-title">PREFERRED DRIVERS:</p>
            <%
                if (!isPref) {
                    out.print("<center>No Driver Found</center>");
                } else {
                    int i = 0;
                    for (driver j : pref) {
                    %>
            <div class="driver">
                <%--<img id="choose-img-prefer<?=$key?>" class="img-driver" src="<?=$img?>" alt="<?=$name?>">--%>
                <p id="choose-name-prefer<%=i%>" class="name-driver"><%=j.getName()%></p>
                <div class="other-recommend">
                    <a id="choose-rate-prefer<%=i%>" class="other-rating" >&#9734 <%=j.getRate()%></a>
                    <a id="choose-vote-prefer<%=i%>" class="other-votes"><%=j.getVoter()%> (votes)</a>
                </div>
                <a href = 'complete-order.jsp?id=<%=j.getID()%>'><button class="button-choose-driver" name="choose">I Choose You!</button></a>
            </div>
            <%
                        i++;
                        out.print(i);
                    }
                }
            %>
        </div>
        <div id="other-driver">
            <p class="order-title">OTHER DRIVERS:</p>
            <%
                int i = 0;
                for (driver k : other) {
                    %>
            <div class="driver">
                <%--<img id="choose-img<%=i%>" class="img-driver" src="<?=$img?>" alt="<?=$name?>">--%>
                <p id="choose-name<%=i%>" class="name-driver"><%=k.getName()%></p>
                <div class="other-recommend">
                    <a id="choose-rate<%=i%>" class="other-rating" >&#9734 <%=k.getRate()%></a>
                    <a id="choose-vote<%=i%>" class="other-votes"><%=k.getVoter()%> (votes)</a>
                </div>
                <a href = 'complete-order.jsp?id=<%=k.getID()%>'><button class="button-choose-driver"
                                                                         name="choose" />I Choose You!</button></a>
            </div>
            <%
                    i++;
                }
            %>
        </div>
    </div>
</div>

<script type="text/javascript" src="js/order.js"></script>
</body>
</html>
