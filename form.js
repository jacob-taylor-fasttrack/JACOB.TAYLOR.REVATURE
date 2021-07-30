var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; // January is 0
var yyyy = today.getFullYear();
var ckObj = {};
var ball;
var deptsObj = [];

if (dd < 10) {
	dd = '0' + dd;
}

if (mm < 10) {
	mm = '0' + mm;
}

today = yyyy + '-' + mm + '-' + dd;

window.onload = function () {
    var ck = decodeURIComponent(document.cookie);
    var cks = ck.split(';');
    for (var i = 0; i < cks.length; i++) {
        var tempCk = cks[i].split('=');
        tempCk[0] = tempCk[0].trim();
        tempCk[1] = tempCk[1].trim();
        ckObj[tempCk[0]] = tempCk[1];
        console.log(tempCk[0]);
        console.log(ckObj[tempCk[0]]);
    }
    var data = 0;
    document.getElementById("cost").addEventListener("change", alerter);
    document.getElementById("typeOfEvent").addEventListener("change", alerter);
    handleOptions(data);
//document.getElementById("formSubmit").addEventListener("click", postForm,
//		false);
//document.getElementById("currentDate").value = today;
};

/*function postForm(){
	alert("in post form");
	//let vg = document.getElementById("vgForm").submit;
	var xhr2 = new XMLHttpRequest();
	xhr2.onreadystatechange = function() {
		console.log("in post form on ready change");
		console.log("in ORSC " + xhr2.readyState + xhr2.status);
		if (xhr2.readyState == 4 && xhr2.status == 200) {
			console.log(xhr.responseText);
		}
	}
	xhr2.open("POST","http://localhost:8080/TRMS/form",false);
	var trash=jsonBuilder();
	alert(trash);
	xhr2.send(trash); //Wtf, trash is not escapecharactered and also is escapecharactered? Also why is this json stuff so reeeeeeeeeeee
}
function jsonBuiilder() {
	var elements = document.getElementById("form").elements;
	//var elements = document.getElementsByClassName("form-control");
	var obj ={};
	for(var i = 0 ; i < elements.length; i++){
		var item = elements.item(i);
		console.log(item.tagName + " is type");
		if((item.tagName == "INPUT" || item.tagName == "SELECT") && item.id != "reimbursementamount"){
        obj[item.name] = item.value;
        console.log(obj);
		}
    }
    var json= JSON.stringify(obj);
    console.log(json);
    return json;
};*/

function inputDepts(depts) {
    var allIds = Object.keys(depts);
    var deptName = document.getElementById("deptId");
    var opt = document.createElement("option");
    opt.value = 0;
    opt.selected = "selected";
    opt.text = "Select Department";
    deptName.appendChild(opt);
    for (var i = 0; i < allIds.length; i++) {
        var opt = document.createElement("option");
        opt.value = allIds[i];
        opt.text = depts[opt.value];
        console.log(opt.value);
        console.log(opt.text);
        deptName.appendChild(opt);
    }

}

function handleOptions(data){
        var xhr = new XMLHttpRequest();
        var depts = '';
        xhr.onreadystatechange = function () {
            console.log("In ORSC " + xhr.readyState + xhr.status);
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                depts = JSON.parse(xhr.responseText);
                //var allDepts = xhr.responseTest + "";
                //console.log(allDepts);
                //allDepts = allDepts.split(',');
                //var tempDept;
                //var tempObj = {};
                //for (var i = 0; i < allDepts.length; i++) {
                //    tempDept = allDepts[i].split(':');
                //    tempObj.id = tempDept[0].substring(1, tempDept.length - 1)
                //    tempObj.name = tempDept[1].substring(1, tempDept[1].length - 1);
                //    deptsObj[i] = tempObj;
                //}
               // console.log();
                inputDepts(depts);
            }
        }
        xhr.open("GET", "http://localhost:8080/TRMS/getdepartments", true);
        xhr.send();
};

function alerter() {
	document.getElementById("cost").value = parseFloat(
			document.getElementById("cost").value).toFixed(2);
	var amount = document.getElementById("cost").value;

	var event = document.getElementById("typeOfEvent").value;
	var factor = 0;
	switch (event) {
	case "1":
		factor = 0.80;
		//document.getElementById("reimbamtEst").value = parseFloat(
		//		(amount )).toFixed(2);
		;
		break;
	case "2":
		factor = 0.60;
		//document.getElementById("reimbamtEst").value = parseFloat(
		//		(amount * .60)).toFixed(2);
		break;
	case "3":
		factor = 0.75;
		//document.getElementById("reimbamtEst").value = parseFloat(
		//		(amount * .80)).toFixed(2);
		break;
	case "4":
		factor =1.00;
		//document.getElementById("reimbamtEst").value = parseFloat(
		//		amount * .75)
		//		.toFixed(2);
		break;
	case "5":
		factor = 0.90;
		//document.getElementById("reimbamtEst").value = parseFloat(
		//		(amount * .90)).toFixed(2);
		break;
	case "6":
		factor = 0.30;
		//document.getElementById("reimbamtEst").value = parseFloat(
		//		(amount * .30)).toFixed(2);
		break;
	default:
		console.log("Reimbursement Amount Error");
	}
	document.getElementById("reimbursementamount").value = parseFloat(
			(amount * factor)).toFixed(2);
	    ball = 1000;//ckObj["remainingReimbursementAmount"].toString();

        document.getElementById("cost").max = (ball / factor);
	
}