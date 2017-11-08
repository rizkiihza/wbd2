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
<%@ page import="com.sun.org.apache.regexp.internal.RE" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    OjekWSImplService service = new OjekWSImplService();
    OjekWS eif = service.getPort(OjekWS.class);

    String ID = "1";

    ArrayList<String> result = eif.getDriverHistory(ID);

    out.println("coba");

    for (String i  : result) {
        out.println("i");
        history driver_history = new history();
        driver_history.fromJson(i);
        out.print(driver_history.getName() + "<br>");
        out.print(driver_history.getComment() + "<br>");
    }

%>
</body>
</html>
