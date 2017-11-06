<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %>
<%@ page import="profile.profile" %>
<%@ page import="com.sun.org.apache.regexp.internal.RE" %><%--
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

        profile user = new profile();
        user.fromJson(Result);

        out.print(user.ID +"<br>");
        out.print(user.Name + "<br>");
        out.print(user.Username + "<br>");
        out.print(user.Phone + "<br>");
        out.print(user.Email + "<br>");
        out.print(user.Driver + "<br>");
        out.print(user.Foto + "<br>");
    %>
</body>
</html>
