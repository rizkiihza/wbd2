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

//        location_ws.editLocation(method, id, value);
    %>
<%=value%>
<%=method%>
<%=id%>
</body>
</html>
