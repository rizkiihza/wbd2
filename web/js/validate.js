function validateLogin() {
	validatePass();
	validateUsername();
	return (validateUsername() && validatePass());
}

function validateRegister() {
	validateName();
	validateUsername2();
	validateEmail();
	validatePass();
	validateCoPass();
	validatePhoneNumber();
	return validateUsername2() && validatePass() && validateName() && validatePhoneNumber() && validateEmail() && validateCoPass() ;
}
	
function validateUsername() {
	var inName = "username";
	if (document.getElementById(inName).value!="") {
		document.getElementById(inName).style.borderWidth="2px";
		document.getElementById(inName).style.borderColor="#02702c";
		return true;
	}
	else {
		document.getElementById(inName).style.borderColor="red";
		document.getElementById(inName).style.borderWidth="medium";
		document.getElementById(inName).placeholder="Enter your username!";
		return false;
	}
}

function validateUsername2() {
	var inName = "username";
	if (document.getElementById(inName).value!="" && document.getElementById('cun').src.substr(document.getElementById('cun').src.length-5) == 'v.png') {
		document.getElementById(inName).style.borderWidth="2px";
		document.getElementById(inName).style.borderColor="#02702c";
		return true;
	}
	else {
		document.getElementById(inName).style.borderColor="red";
		document.getElementById(inName).style.borderWidth="medium";
		document.getElementById(inName).placeholder="Enter your username!";
		return false;
	}
}
	
function validatePass() {
	var inName = "password";
	if (document.getElementById(inName).value!="") {
		document.getElementById(inName).style.borderWidth="2px";
		document.getElementById(inName).style.borderColor="#02702c";
		return true;
	}
	else {
		document.getElementById(inName).style.borderColor="red";
		document.getElementById(inName).style.borderWidth="medium";
		document.getElementById(inName).placeholder="Enter your password!";
		return false;
	}
}

function validateName() {
	var inName = "name";

	if (document.getElementById(inName).value!="") {
		if (document.getElementById(inName).value.length > 20) {
			document.getElementById(inName).value="";
			document.getElementById(inName).placeholder="Max 20 character!";
			document.getElementById(inName).style.borderColor="red";
			document.getElementById(inName).style.borderWidth="medium";
			return false;
		} else {
			document.getElementById(inName).style.borderWidth="2px";
			document.getElementById(inName).style.borderColor="#02702c";
			return true;
		}
	}
	else {
		document.getElementById(inName).style.borderColor="red";
		document.getElementById(inName).style.borderWidth="medium";
		if (document.getElementById(inName).placeholder!="Max 20 character!") {
			document.getElementById(inName).placeholder="Enter your name!";
		}
		return false;
	}
}

function validateEmail() {
	var inName = "email";
	if (document.getElementById(inName).value!="") {
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.getElementById(inName).value) && document.getElementById('cem').src.substr(document.getElementById('cem').src.length-5) == 'v.png') {
			document.getElementById(inName).style.borderWidth="2px";
			document.getElementById(inName).style.borderColor="#02702c";
			return true;
		} else {
			if (document.getElementById('cem').src.substr(document.getElementById('cem').src.length-5) == 'v.png') {
				document.getElementById(inName).placeholder="Incorrect email format!";
				document.getElementById(inName).value="";	
			}
			document.getElementById(inName).style.borderColor="red";
			document.getElementById(inName).style.borderWidth="medium";
			return false;
		}
	}
	else {
		document.getElementById(inName).style.borderColor="red";
		document.getElementById(inName).style.borderWidth="medium";
		if (document.getElementById(inName).placeholder!="Incorrect email format!") {
			document.getElementById(inName).placeholder="Enter your email!";
		}
		return false;
	}
}

function validateCoPass() {
	var inName = "copassword";
	var inName2 = "password";
	if (document.getElementById(inName).value!="") {
		if (document.getElementById(inName).value == document.getElementById(inName2).value) {
			document.getElementById(inName).style.borderWidth="2px";
			document.getElementById(inName).style.borderColor="#02702c";
			return true;
		} else {
			document.getElementById(inName).style.borderColor="red";
			document.getElementById(inName).style.borderWidth="medium";
			document.getElementById(inName).placeholder="Password not match!";
			document.getElementById(inName).value="";
			return false;
		}
	}
	else {
		document.getElementById(inName).style.borderColor="red";
		document.getElementById(inName).style.borderWidth="medium";
		if (document.getElementById(inName).placeholder!="Password not match!") {
			document.getElementById(inName).placeholder="Enter your password again!";
		}		
		return false;
	}
}

function validatePhoneNumber() {
	var inName = "phone_number";

	if (document.getElementById(inName).value!="") {
		if (/\d{9,12}$/.test(document.getElementById(inName).value)) {
			document.getElementById(inName).style.borderWidth="2px";
			document.getElementById(inName).style.borderColor="#02702c";
			return true;
		} else {
			document.getElementById(inName).placeholder="Incorrect phone number format!";
			document.getElementById(inName).value="";
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