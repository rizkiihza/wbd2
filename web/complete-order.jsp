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
    <jsp:include page="/OrderServlet"/>

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

    <%
        session.setAttribute("idDriver", request.getParameter("id"));
    %>
    <script type="text/javascript" src="js/order.js"></script>
</body>
</html>
