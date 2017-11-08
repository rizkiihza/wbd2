<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %>
<%@ page import="location.location" %><%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/8/17
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String ID = "1";
    OjekWSImplService service = new OjekWSImplService();
    OjekWS ws = service.getPort(OjekWS.class);

    String result = ws.getLocation(ID);

    location tempat = new location();
    tempat.fromJson(result);
%>
</body>
</html>
