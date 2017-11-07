function checkUsername(str) {
  if (str.length == 0) { 
    document.getElementById("check1").innerHTML = "";
    return;
  } else {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        document.getElementById("check1").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "check.php?cusername=" + str, true);
    xhttp.send();
  }
}

function checkEmail(str) {
  if (str.length == 0) { 
    document.getElementById("check2").innerHTML = "";
    return;
  } else {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        document.getElementById("check2").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "check.php?cemail=" + str, true);
    xhttp.send();
  }
}