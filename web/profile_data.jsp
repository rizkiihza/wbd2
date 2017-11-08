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

        String username = (String) session.getAttribute("UNUserAktif");

        String Result = eif.getProfileData(username);

        profile user = new profile();
        user.fromJson(Result);
        session.setAttribute("IDUserAktif", user.ID);

        user.Foto = "img/profile-" + user.ID + ".jpg";
    %>
</body>
</html>
