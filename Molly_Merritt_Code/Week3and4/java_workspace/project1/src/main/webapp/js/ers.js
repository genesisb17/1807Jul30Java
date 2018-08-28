/**
 * Single JS script for entire bookstore app.
 * Separate functionality into methods and keep as organized as 
 * possible.. as this will get lengthy
 */

window.onload=function() {
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#accountNav').on('click', loadAccountView);
	$('#reimbNav').on('click', loadReimbursementsView);
}

function loadHomeView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
	
}

function loadAccountView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			populateUserTable();
		}
	}
	xhr.open("GET", "account.view", true);
	xhr.send();
	
}

function loadReimbursementsView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "reimbursements.view", true);
	xhr.send();
	
}

function submitReimbursement() {
//	var rAmount = $('#amount').val();
//	var rDescription = $('#description').val();
//	var rReceipt = $('receipt').val();
//	var rType = $('#reimbType').val();
}

function populateUserTable() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			var users = JSON.parse(xhr.responseText);
			console.log(users);
			for(var u of users) {
				addUser(u);	// helper function to create elements
			}
		}
	}
	xhr.open("GET", "account");
	xhr.send();
}

function addUser(u) {
	var row = document.createElement("tr");
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	var cell4 = document.createElement("td");
	console.log(u);
	
	cell1.innerHTML = u.username;
	cell2.innerHTML = u.password;
	cell3.innerHTML = u.firstname;
	cell4.innerHTML = u.lastname;
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	
	document.getElementById("userTable").appendChild(row);
}