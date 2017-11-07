var driver_id = 0;
var pick;
var dest;

function next() {
    document.getElementById('select-destination').style.display = 'none';
    document.getElementById('step1').className = 'division';

    document.getElementById('select-driver').style.display = 'block';
    document.getElementById('step2').className += " active";

}

function choose(idx) {
    driver_id = document.getElementById('choose-id' + idx).innerHTML;
    var user = document.getElementById('choose-user' + idx).innerHTML;
    var name = document.getElementById('choose-name' + idx).innerHTML;
    var img = document.getElementById('choose-img' + idx).getAttribute('src');
    var str1 = document.getElementById('choose-rate' + idx).innerHTML;
    var rate = str1.split(" ")[1];
    var str2 = document.getElementById('choose-vote' + idx).innerHTML;
    var vote = str2.split(" ")[0];

    document.getElementById('step2').className = 'division';
    document.getElementById('step3').className += ' active';

    document.getElementById('select-driver').style.display = 'none';
    document.getElementById('complete-order').style.display = 'block';

    document.getElementById('username').innerHTML = "@"+user;
    document.getElementById('fullname').innerHTML = name;
    document.getElementById('rating').innerHTML = rate;
    document.getElementById('img').src = img;

}

function choosePrefer(idx) {
    driver_id = document.getElementById('choose-id-prefer' + idx).innerHTML;
    pick = document.getElementById('choose-pick-prefer' + idx).innerHTML;
    dest = document.getElementById('choose-dest-prefer' + idx).innerHTML;
    var user = document.getElementById('choose-user-prefer' + idx).innerHTML;
    var name = document.getElementById('choose-name-prefer' + idx).innerHTML;
    var img = document.getElementById('choose-img-prefer' + idx).getAttribute('src');
    var str1 = document.getElementById('choose-rate-prefer' + idx).innerHTML;
    var rate = str1.split(" ")[1];
    var str2 = document.getElementById('choose-vote-prefer' + idx).innerHTML;
    var vote = str2.split(" ")[0];

    document.getElementById('step2').className = 'division';
    document.getElementById('step3').className += ' active';

    document.getElementById('select-driver').style.display = 'none';
    document.getElementById('complete-order').style.display = 'block';

    document.getElementById('username').innerHTML = "@"+user;
    document.getElementById('fullname').innerHTML = name;
    document.getElementById('rating').innerHTML = rate;
    document.getElementById('img').src = img;

}

function setDriverId() {
    document.getElementById('complete-driver-id').value = driver_id;
    document.getElementById('complete-driver-pick').value = pick;
    document.getElementById('complete-driver-dest').value = dest;
}

function validateField() {
    validatePick();
    validateDest();
    return (validatePick() && validateDest());
}

function validatePick() {
    var inName = "driver-pick-point";
    if (document.getElementById(inName).value!="") {
        document.getElementById(inName).style.borderWidth="2px";
        document.getElementById(inName).style.borderColor="initial";
        return true;
    }
    else {
        document.getElementById(inName).style.borderColor="red";
        document.getElementById(inName).style.borderWidth="medium";
        document.getElementById(inName).placeholder="Enter your picking point!";
        return false;
    }
}

function validateDest() {
    var inName = "driver-destination";
    if (document.getElementById(inName).value!="") {
        document.getElementById(inName).style.borderWidth="2px";
        document.getElementById(inName).style.borderColor="inital";
        return true;
    }
    else {
        document.getElementById(inName).style.borderColor="red";
        document.getElementById(inName).style.borderWidth="medium";
        document.getElementById(inName).placeholder="Enter your destination!";
        return false;
    }
}