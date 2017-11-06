<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %><%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/5/17
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%
        OjekWSImplService service = new OjekWSImplService();
        OjekWS eif = service.getPort(OjekWS.class);
        String Result = eif.getProfileData(request.getParameter("ID"));
        out.print(Result);
    %>
</body>
</html>
