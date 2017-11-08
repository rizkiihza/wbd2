<%--
  Created by IntelliJ IDEA.
  User: lelouch
  Date: 11/7/17
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?php
require 'db.php';

$user_id = $_GET['id_active'];
$result = $mysqli->query("SELECT * FROM users WHERE id='$user_id'");
$user = $result->fetch_assoc();

if ( $user['is_driver'] == 1) {
$is_driver = True;
} else {
$is_driver = False;
}


$users = [];
$db_user = $mysqli->query("SELECT id, name FROM users");
while ($r = $db_user->fetch_array()) {
$users += [$r['id'] => $r['name']];
}

//Get passenger history
$passenger_history = [];
$db_passenger = $mysqli->query("SELECT * FROM order_history  WHERE pass_id = $user_id");
while ($row = $db_passenger->fetch_array()) {
array_push($passenger_history,
array("name" => $users[$row['driver_id']],
"id" => $row['id'],
"hide" => $row['is_hidden'],
"rate" => $row['rate'],
"comment" => $row['comment'],
"date" => $row['order_date'],
"pick" => $row['pick'],
"dest" => $row['destination'],
"img" => "img/profile-".$row['driver_id'].".jpg"));
}

//Get driver history
$driver_history = [];
$db_driver = $mysqli->query("SELECT * FROM order_history  WHERE driver_id = $user_id");
while ($row = $db_driver->fetch_array()) {
array_push($driver_history,
array("name" => $users[$row['pass_id']],
"id" => $row['id'],
"hide" => $row['is_hidden'],
"rate" => $row['rate'],
"comment" => $row['comment'],
"date" => $row['order_date'],
"pick" => $row['pick'],
"dest" => $row['destination'],
"img" => "img/profile-".$row['pass_id'].".jpg"));
}

?>

<!DOCTYPE html>
<html>
<head>
    <title>History</title>
    <link rel="stylesheet" href="css/history.css" type="text/css">
</head>
<body>
<div id="frame">
    <header class="clearfix">
        <div id=logo>
            <h2 id="main-logo"><span id="logo1">PR-</span><span id="logo2">OJEK</span></h2>
            <p id="sub-logo">wush... wush... ngeeeeeenggg...</p>
        </div>
        <div id=user-stat>
            <p id=greeting>Hi, <b><?php echo $user['username']; ?></b> !</p>
            <a href="index.php">Logout</a>
        </div>
    </header>
    <div id="navbar">
        <ul>
            <li><a href="order.php?id_active=<?php echo $user_id; ?>">ORDER</a></li>
            <li><a href="#" class="active">HISTORY</a></li>
            <li><a href="profile.php?id_active=<?php echo $user_id; ?>">MY PROFILE</a></li>
        </ul>
    </div>
    <div id="history-title">
        <h2>HISTORY</h2>
    </div>

    <div id="history-step">
        <div id="step1" class="division active" onclick="previousOrder()">
            <p>MY PREVIOUS ORDERS</p>
        </div>
        <div id="step2" class="division" onclick="driverHistory()">
            <p>DRIVER HISTORY</p>
        </div>
    </div>

    <div id="previous-order">
        <?php foreach($passenger_history as $key => $data) :
        ?>
        <div class="driver" <?php if ($data['hide'] != 0) echo "style='display:none;'"?> >
        <form action="update-history.php" method="post">
            <img id="img<?=$key?>" class="img-driver" src="<?=$data['img']?>" alt="<?=$data['name']?>">
            <p id="date<?=$key?>" class="date-driver"><?=$data['date']?></p>
            <p id="name<?=$key?>" class="name-driver"><?=$data['name']?></p>
            <p id="path<?=$key?>" class="path-driver"><?=$data['pick']?> - <?=$data['dest']?></p>
            <p id="rate<?=$key?>" class="rate-driver" >&#9734 <?=$data['rate']?></p>
            <p id="comment<?=$key?>" class="comment-driver">comments : <?=$data['comment']?></p>
            <input id="user-id<?=$key?>" type="hidden" name="user_id" value="<?=$user_id?>" />
            <input id="data-id<?=$key?>" type="hidden" name="data_id" value="<?=$data['id']?>" />
            <button type="submit" class="button-hide-driver" name="hide" />Hide</button>
        </form>
    </div>
    <?php endforeach; ?>
</div>

<div id="driver-history">
    <?php foreach($driver_history as $key => $data) :
    ?>
    <div id="driver<?=$data['id']?>" class="driver" <?php if ($data['hide'] != 0) echo "style='display:none;'"?> >
    <form action="update-history.php" method="post">
        <img id="img-pass<?=$key?>" class="img-driver" src="<?=$data['img']?>" alt="<?=$data['name']?>">
        <p id="date-pass<?=$key?>" class="date-driver"><?=$data['date']?></p>
        <p id="name-pass<?=$key?>" class="name-driver"><?=$data['name']?></p>
        <p id="path-pass<?=$key?>" class="path-driver"><?=$data['pick']?> - <?=$data['dest']?></p>
        <p id="rate-pass<?=$key?>" class="rate-driver" >&#9734 <?=$data['rate']?></p>
        <p id="comment-pass<?=$key?>" class="comment-driver">comments : <?=$data['comment']?></p>
        <input id="position-id<?=$key?>" type="hidden" name="position_id" value="2" />
        <input id="content-id<?=$key?>" type="hidden" name="content_id" value="<?=$key?>" />
        <input id="user-id<?=$key?>" type="hidden" name="user_id" value="<?=$user_id?>" />
        <input id="data-id<?=$key?>" type="hidden" name="data_id" value="<?=$data['id']?>" />
        <button class="button-hide-driver" name="hide" />Hide</button>
    </form>
</div>
<?php endforeach; ?>
</div>

</div>

<script>
    function driverHistory() {
        document.getElementById("previous-order").style.display = 'none';
        document.getElementById("driver-history").style.display = 'block';

        document.getElementById('step1').className = 'division';
        document.getElementById('step2').className += ' active';
    }

    function previousOrder() {

        document.getElementById("driver-history").style.display = 'none';
        document.getElementById("previous-order").style.display = 'block';

        document.getElementById('step2').className = 'division';
        document.getElementById('step1').className += ' active';
    }

    // function reload(x) {
    //     // location.reload();

    //     // if (x == 1) {
    //     //     // previousOrder();
    //     //     driverHistory();
    //     // } else {
    //     //     driverHistory();
    //     // }

    // }

    // function hide(x, y) {
    //     // location.reload()
    //     var t = x-1;
    //     if (y == 2) {
    //         document.GetElementById("driver" + t).style.display = 'none';
    //     }
    //     driverHistory();
    // }

</script>


<?php
    if (count($_POST) > 0) {
$user_id = $_POST['user_id'];
$data_id = $_POST['data_id'];
$content_id = $_POST['content_id'];
$position_id = $_POST['position_id'];

$update_data = "UPDATE order_history SET is_hidden = 1 WHERE id = $data_id";

if ($mysqli->query($update_data) === TRUE) {
// echo "succes";
// echo "<script> window.location.reload(); </script>";

} else {
echo "Error: " . $update_data . "<br>" . $mysqli->error;
}
}

?>


</body>
</html>
