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
//	$('#authorNav').on('click', loadAuthorView);
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

function loadBooksView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		// showing what we're getting back for now
//		console.log(xhr.responseText);
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			// cross origin resource sharing - must add more headers
			
			// once view is loaded, populate table and add eventlisteners
			populateBookTable();
		}
	}
	xhr.open("GET", "books.view");
	xhr.send();
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

function loadGenreView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
		
	}
	xhr.open("GET", "genre.view");
	xhr.send();
}

function loadAuthorView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
		
	}
	xhr.open("GET", "author.view");
	xhr.send();
}