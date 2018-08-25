/**
 *  Single JS script for entire bookstore app. 
 *  Separate functionality into methods and keep as 
 *  organized as possible.. as this will get lengthy
 */

window.onload=function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#booksNav').on('click', loadBooksView);
}


function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			//once view is loaded, populate table and add eventListeners
			populateBookTable();
		}
		
	}
	xhr.open("GET", "home.view");
	xhr.send();
	
}

function populateBookTable() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var books = JSON.parse(xhr.responseText);
			for( var b in books) {
				addBook(b); //helper function to create elements
			}
		}
	}
}

function addBook(b) {
	var row = document.createElement("tr");
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	var cell4 = document.createElement("td");
	
	cell1.innerHTML = b.isbn;
	cell2.innerHTML = b.title;
	cell3.innerHTML = b.price;
	cell4.innerHTML = b.genreId;
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	
	document.getElementbyId("bookTable").appendChild(row);

}

function loadBooksView(){
	
}