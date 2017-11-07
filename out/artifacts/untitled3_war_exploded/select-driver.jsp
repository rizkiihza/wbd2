<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %>
<%@ page import="driver.driver"%>
<%@ page import="ws.StringArray" %>
<%@ page import="java.util.List" %><%--
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
</head>
<body>
    <%--<jsp:include page="/DriverServlet"/>--%>
    <%
        OjekWSImplService driverService = new OjekWSImplService();
        OjekWS eif = driverService.getPort(OjekWS.class);
        StringArray driverResult = eif.getDriver(request.getParameter("picking-point"),
                request.getParameter("destination"), request.getParameter("pref-driver"));
        List<String> list = driverResult.getItem();
        driver d = new driver();
        for (String i : list) {
            d.fromJson(i);
            out.println(d.getID() + "<br>");
            out.println(d.getName() + "<br>");
            out.println(d.getRate() + "<br>");
            out.println(d.getVoter() + "<br>");
            out.println(d.getStatus() + "<br>");
            out.println("<a href='complete-order.jsp?id=" + d.getID() + "'>Choose Me</a><br>");
        }
    %>
</body>
</html>
