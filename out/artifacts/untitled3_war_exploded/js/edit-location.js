function editName(id,key,value) {
  document.getElementById('column2-' + key).innerHTML = '<form action="edit-location-proses.php?id_active=' + id + '&method=edit&value=' + value + '" method="post"><input type="text" name="location_name" id="location_name_' + key + '" value="' + value + '" onclick="this.select()" class="location_name">'
  // document.getElementById('edit_' + key).innerHTML = '<a href="#" onclick="document.getElementById(location_name_' + key + ').submit()">save</a>';
  document.getElementById('edit_' + key).innerHTML = '<input id="save" type="submit" value="save" class="save"></form>';
}

function validateName() {
	var inName = 'add_loc';

	if (document.getElementById(inName).value!="") {
    document.getElementById(inName).style.borderColor="";
    document.getElementById(inName).style.borderWidth="";
		return true;
  }
  else {
    document.getElementById(inName).value="";
    document.getElementById(inName).placeholder="Enter location!";
    document.getElementById(inName).style.borderColor="red";
    document.getElementById(inName).style.borderWidth="medium";
    return false;
  }
}
