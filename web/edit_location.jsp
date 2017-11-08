<%@ page import="ws.OjekWSImplService" %>
<%@ page import="ws.OjekWS" %><%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/7/17
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="location_data.jsp"%>
<%@include file="profile_data.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Peferred Locations</title>
    <link rel="stylesheet" href="css/edit-location.css" type="text/css">
</head>
<body>
<div id="frame">
    <h2>EDIT PREFERRED LOCATIONS</h2>
    <table id="locations">
        <tr>
            <th class="padd">No</th>
            <th class="padd">Location</th>
            <th class="padd">Actions</th>
        </tr>
        <%
            for( int i = 0; i < tempat.tempat.size() ; i++) {
                int key = i+1;
                String value = tempat.tempat.get(i);
                out.print("<tr>");
                out.print("<td id=\"column1-" + key + "\" class=\"center padd\">" + key + "</td>");
                out.print("<td id=\"column2-" + key + "\" class=\"padd\">" + value + "</td>");
                out.print("<td id=\"column3-" + key + "\" class=\"center padd\">");
                out.print("<span id=\"edit_" + key + "\" class=\"edit\">");
                out.print("<a href=\"edit_location_data.jsp\" id=\"edit_" + key + "\"><img id=\"edit-icon-" + key + "\" src=\"img/pencil-edit-button.png\" alt=\"edit\" class=\"icon\"></a>");
                out.print("</span>");
                out.print("<span id=\"space\"></span>");
                out.print("<a href=\"edit-location-proses.php?id_active=" + user.ID + "&method=delete&value=" + value + \"><img src=\"img/cross.png\" alt=\"delete\" class=\"icon\"></a>");
                out.print("</td>");
                out.print("</tr>");
            }
        %>

    </table>
    <form action="edit_location_data.php?id_active=<?php echo $user_id; ?>&method=add" method="post" onsubmit="return validateName()">
        <label>ADD NEW LOCATION:</label><br>
        <table>
            <td><input type="text" name="location" id="add_loc"></td>
            <td><input type="submit" value="ADD" id="add"></td>
        </table>
    </form>
    <a id='back' href="profile.php?id_active=<?php echo $user_id; ?>">BACK</a>
</div>
<script src="js/edit-location.js"></script>
</body>
</html>