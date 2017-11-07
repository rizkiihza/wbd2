<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %><%--
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
    String ID = request.getParameter("ID");
    String Name = request.getParameter("Name");
    String Phone = request.getParameter("Phone");
    String Foto = request.getParameter("Foto");
    eif.editProfileData(ID, Name, Phone, Foto);
%>
