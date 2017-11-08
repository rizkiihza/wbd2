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
<%@ page import="com.sun.org.apache.regexp.internal.RE" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    OjekWSImplService service = new OjekWSImplService();
    OjekWS eif = service.getPort(OjekWS.class);

    String ID = "1";

    String result = eif.getDriverHistory(ID);

    listhistory list = new listhistory();

    out.println("coba");

    list.fromJson(result);

    for (history i  : list.getList()) {
        out.println("i");
        out.print(i.getName() + "<br>");
        out.print(i.getComment() + "<br>");
    }

%>
</body>
</html>
