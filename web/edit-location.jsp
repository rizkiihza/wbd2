<%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/7/17
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <?php foreach ($locations as $key => $value) {
        $key += 1;
        echo '<tr>
        <td id="column1-'.$key.'" class="center padd">'.$key.'</td>
        <td id="column2-'.$key.'" class="padd">'
            .$value.'
        </td>
        <td id="column3-'.$key.'" class="center padd">
                  <span id="edit_'.$key.'" class="edit">
                    <a onclick="editName(\''.$user_id.'\', \''.$key.'\', \''.$value.'\')" href="#" id="edit_'.$key.'"><img id="edit-icon-'.$key.'" src="img/pencil-edit-button.png" alt="edit" class="icon"></a>
                  </span>
            <span id="space"></span>
            <a onclick="return confirm(\'Delete '.$value.' from your preferred location?\')" href="edit-location-proses.php?id_active='.$user_id.'&method=delete&value='.$value.'"><img src="img/cross.png" alt="delete" class="icon"></a>
        </td>
    </tr>';
        }
        ?>
    </table>
    <form action="edit-location-proses.php?id_active=<?php echo $user_id; ?>&method=add" method="post" onsubmit="return validateName()">
        <label for="location">ADD NEW LOCATION:</label><br>
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