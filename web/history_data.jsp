<%--
  Created by IntelliJ IDEA.
  User: hilmi
  Date: 08/11/2017
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %>
<%@ page import="history.history" %>
<%@include file="profile_data.jsp" %>
<%@ page import="history.listhistory" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    OjekWSImplService service = new OjekWSImplService();
    OjekWS eif = service.getPort(OjekWS.class);

    String ID = (String) session.getAttribute("IDUserAktif");

    String driverHistoryString = eif.getDriverHistory(ID);

    String previousDriverString = eif.getPreviousDriver(ID);

    listhistory listDriverHistory = new listhistory();
    listhistory listPreviousDriver = new listhistory();


    listPreviousDriver.fromJson(previousDriverString);
    listDriverHistory.fromJson(driverHistoryString);

%>
</body>
</html>
