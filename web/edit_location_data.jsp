<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %><%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/8/17
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit location</title>
</head>
<body>
    <%
        OjekWSImplService location_service = new OjekWSImplService();
        OjekWS location_ws = location_service.getPort(OjekWS.class);

        String id = "1";
        String method = request.getParameter("method");
        String value = request.getParameter("value");

        out.print(method+id+value);

        location_ws.editLocation(method, id, value);
    %>
    <%
        // New location to be redirected
        String site = new String("profile.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    %>
</body>
</html>
