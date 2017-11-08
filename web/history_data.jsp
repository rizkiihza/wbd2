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
<%@ page import="history.listhistory" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    OjekWSImplService service = new OjekWSImplService();
    OjekWS eif = service.getPort(OjekWS.class);

    String ID = "1";

    String driverHistoryString = eif.getDriverHistory(ID);

    String preivousDriverString = eif.getPreviousDriver(ID);

    listhistory listDriverHistory = new listhistory();
    listhistory listPreviousDriver = new listhistory();


    listDriverHistory.fromJson(preivousDriverString);
    listDriverHistory.fromJson(driverHistoryString);


    for (history i  : listPreviousDriver.getList()) {
        out.println("i");
        out.print(i.getName() + "<br>");
        out.print(i.getComment() + "<br>");
    }

    for (history i  : listDriverHistory.getList()) {
        out.println("i");
        out.print(i.getName() + "<br>");
        out.print(i.getComment() + "<br>");
    }

%>
</body>
</html>
