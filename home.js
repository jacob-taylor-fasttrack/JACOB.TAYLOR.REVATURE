function getUser() {
    console.log("In get User function!");
    var xhr = new XMLHttpRequest();
    var user = '';
    xhr.onreadystatechange = function () {
        //alert("In ORSC " + xhr.readyState + xhr.status);
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);
            user = JSON.parse(xhr.responseText);
            loadUserHome(user);
            console.log(user);
            
        }
    }
    
    xhr.open("GET", "http://localhost:7000/TRMS/user", true);
    xhr.send();
}

window.onload = function(){
	var curUser = getUser();
	console.log(curUser)
}