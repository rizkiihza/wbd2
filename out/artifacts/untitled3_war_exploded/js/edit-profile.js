
function browseFile() {
  document.getElementById('file').click();
  return false;
}

function setFilename(val) {
  var fileName = val.substr(val.lastIndexOf("\\")+1, val.length);
  document.getElementById("filename").value = fileName;
}

function validateName() {
	var inName = "name";

	if (document.getElementById(inName).value!="") {
    document.getElementById(inName).style.borderColor="";
    document.getElementById(inName).style.borderWidth="";
		return true;
  }
  else {
    document.getElementById(inName).value="";
    document.getElementById(inName).placeholder="Enter your name!";
    document.getElementById(inName).style.borderColor="red";
    document.getElementById(inName).style.borderWidth="medium";
    return false;
  }
}

function validatePhoneNumber() {
	var inName = "phone";

	if (document.getElementById(inName).value!="") {
		if (/\d{9,12}$/.test(document.getElementById(inName).value)) {
      document.getElementById(inName).style.borderColor="";
      document.getElementById(inName).style.borderWidth="";
			return true;
		} else {
			document.getElementById(inName).value="";
			document.getElementById(inName).placeholder="Incorrect phone number format!";
			document.getElementById(inName).style.borderColor="red";
			document.getElementById(inName).style.borderWidth="medium";
			return false;
		}
	}
  else {
    document.getElementById(inName).style.borderColor="red";
    document.getElementById(inName).style.borderWidth="medium";
    if (document.getElementById(inName).placeholder!="Incorrect phone number format!") {
			document.getElementById(inName).placeholder="Enter your phone number!";
		}
    return false;
  }
}

function validateInput() {
  validateName();
  validatePhoneNumber();
  return (validateName() && validatePhoneNumber());
}
