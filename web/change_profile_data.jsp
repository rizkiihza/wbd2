<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/7/17
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    OjekWSImplService service = new OjekWSImplService();
    OjekWS eif = service.getPort(OjekWS.class);
    String ID = session.getAttribute("IDUserAktif").toString();
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String driver = "";

    String[] drivers = request.getParameterValues("driver_stat");

    if (drivers != null) {
        driver = "1";
    } else {
        driver = "0";
    }

    eif.editProfileData(ID, name, phone, driver);
%>

<%
    // New location to be redirected
    String site = new String("profile.jsp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
