<%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/8/17
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pic</title>
</head>
<body>
    <form action="change_pic_data.jsp" method="post" enctype="multipart/form-data">
        <div id="input-img">
            <label id="profile-pic-label">Update profile picture</label>
            <table id="input-file-table">
                <input type="file" name="profile-pic" accept="image/jpeg" id="file"
                       onchange="setFilename(this.value);
                               document.getElementById('profile-pic').src = window.URL.createObjectURL(this.files[0]);"/><br>
                <input type="submit" value="SAVE" id="submit">
            </table>
        </div>
    </form>
</body>
</html>
