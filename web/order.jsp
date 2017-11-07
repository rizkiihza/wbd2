<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04/11/2017
  Time: 01.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PR-OJEK Order</title>
</head>
<body>

<div id="frame">
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
