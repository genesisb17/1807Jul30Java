/**
 * 
 */

window.onload=function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#viewusersNav').on('click', loadUsersView);
	$('#loginNav').on('click',loadLoginView );
	$('#viewAllNav').on('click',loadReimbView );
	$('#viewmyNav').on('click',loadmyReimbView);
	$('#createNav').on('click',loadaddReimbView );
	$('#logoutNav').on('click',logout );
	//$('#chosen').on('click',editSelected);
	
}

function loadmyReimbView(){
	console.log('Inside of Reimb')
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){

		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			populateReimbTable();
		
		}
	}
	xhr.open("GET", "reimb.view",true);
	xhr.send();
}


function editSelected(a){
	var xhr = new XMLHttpRequest();
	console.log("inside edit selected");
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			
			
			document.getElementById("selected").setAttribute('value',a);
		//console.log(xhr.responseText);
		}
	
	}
	xhr.open("GET","updateReimb.view",true);
	xhr.send();
	
}

function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			$('#view').html(xhr.responseText);
		}
	}
	document.getElementById("xxxx").style.visibility = "hidden";
	document.getElementById("xxx").style.visibility = "hidden";
	xhr.open("GET","logout",true);
	xhr.send();

}
function loadaddReimbView(){
	console.log('Inside of addReimb')
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			
		console.log(xhr.responseText);
		}
	}
	xhr.open("GET","addReimb.view",true);
	xhr.send();
}

function loadReimbView(){
	console.log('Inside of Reimb')
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){

		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			populateReimbTable();
		
		}
	}
	xhr.open("GET", "reimb.view",true);
	xhr.send();
}


function loadLoginView(){
	
	console.log('Inside of load login view')
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){

		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			//populateUserTable();
			document.getElementById("xxxx").style.visibility = "visible";
			document.getElementById("xxx").style.visibility = "visible";
		}
	}
	xhr.open("GET", "login.view",true);
	xhr.send();
}

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}

	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}


function populateReimbTable(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			reimbursements = JSON.parse(xhr.responseText);
			console.log(reimbursements);
			for(var r of reimbursements){
				addReimbursementToTable(r); //helper function to create elements
			}
		}
		
	}
	xhr.open("GET", "reimbursements");
	xhr.send();
}


function populateUserTable(){

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			users = JSON.parse(xhr.responseText);
			console.log(users);
			for(var u of users){
				addUserToTable(u); //helper function to create elements
			}
		}
		
	}
	
	xhr.open("GET", "users");
	xhr.send();
}

function clickedButton(a){
	console.log(a.getAttribute('value'));
	var rid=a.getAttribute('value');
	
	var xhr = new XMLHttpRequest();
	console.log("inside edit selected");
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			
			
			document.getElementById("selected").setAttribute('value',rid);
		//console.log(xhr.responseText);
		}
	
	}
	xhr.open("GET","updateReimb.view",true);
	xhr.send();
	
	
			//console.log($(this).attr("value"));
}

function addReimbursementToTable(r){

	var row = document.createElement("tr");
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	//var cell3 = document.createElement("td");
	//var cell4 = document.createElement("td");
	var cell5 = document.createElement("td");
	//var cell6 = document.createElement("td");
	var cell7 = document.createElement("td");
	var cell8 = document.createElement("td");
	var cell9 = document.createElement("td");
	var cell10 = document.createElement("td");
	var cell11 = document.createElement("td");

	console.log(r);
	 row.setAttribute('id',r.id);
	 row.setAttribute('class',"chosen")
	console.log("author name in js "+r.author);
	cell1.innerHTML = r.id;
	cell2.innerHTML = r.amount+"$";
	//cell3.innerHTML = r.submittedTime;
	//cell4.innerHTML = r.resolvedTime;
	cell5.innerHTML = r.description;
	//cell6.innerHTML =r.receipt;
	cell7.innerHTML =r.authorname;
	cell8.innerHTML = r.resolver;
	cell9.innerHTML = r.status;
	cell10.innerHTML = r.type;
	cell11.innerHTML="<button type='button' name='"+r.id+"' value="+r.id+" id='chosen' onclick='clickedButton(this)'>Approve or Deny</button>";
	//cell12.innerHtml="<button type='button' id="+r.id+">Deny</button>";

	
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	//row.appendChild(cell3);
	//row.appendChild(cell4);
	row.appendChild(cell5);
	//row.appendChild(cell6);
	row.appendChild(cell7);
	row.appendChild(cell8);
	row.appendChild(cell9);
	row.appendChild(cell10);
	row.appendChild(cell11);
	//row.appendChild(cell12);
	//reimbursementsTable
	document.getElementById("reimbursementsTable").appendChild(row);
	//document.getElementById("hider").setAttribute("hidden",true);
	document.getElementById("hider").style.visibility = "visible";
	//$('#reimbursementsTable').appendChild(row);
}

function addUserToTable(u){
	console.log('inside of the addUserTable');
	var row = document.createElement("tr");
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");

	console.log(u);
	cell1.innerHTML = u.username;
	cell2.innerHTML = u.email;
	cell3.innerHTML = u.userrole;


	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	document.getElementById("userTable").appendChild(row);
	//document.getElementById("hider1").style.visibility = "visible";
}
function loadUsersView(){

	console.log('Inside of loaduserview')
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){

		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			populateUserTable();
		
		}
	}
	xhr.open("GET", "users.view",true);
	xhr.send();
}

