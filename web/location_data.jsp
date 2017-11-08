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
    location tempat = new location();
    String ID = "";
    if (session.getAttribute("TokenUserAktif") == null) {
        String site = new String("login.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    } else {
        ID = (String) session.getAttribute("IDUserAktif");
        OjekWSImplService service = new OjekWSImplService();
        OjekWS ws = service.getPort(OjekWS.class);

        String result = ws.getLocation(ID);


        tempat.fromJson(result);
    }
%>
</body>
</html>
