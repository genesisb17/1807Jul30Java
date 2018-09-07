/**
 *  Single JS script for entire bookstore app. 
 *  Separate functionality into methods and keep as 
 *  organized as possible.. as this will get lengthy
 */

window.onload=function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#booksNav').on('click', loadBooksView);
	$('#genreNav').on('click', loadGenreView);
	$('#authorNav').on('click', loadAuthorView);

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

function loadBooksView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){

		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#toggleAdd').on('click', function(){
				$('#booksView').removeAttr('hidden');		
				$('#toggleAdd').remove();
			});
			
			$('#addBook').on('click', submitBook);
			//once view is loaded, populate table and add eventlisteners
			populateBookTable();
		}

	}
	xhr.open("GET", "books.view");
	xhr.send();
}





function submitBook(){
	var i = $('#isbn').val();
	var t = $('#title').val();
	var p = $('#price').val();
	var g = $('#genre').val();

	var book = {
			isbn: i, 
			title: t,
			price: p,
			genreId: g
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			console.log(xhr.responseText);
			let b = JSON.parse(xhr.responseText);
			addBookToTable(b);
		}
	}
		xhr.open('POST', 'books', true);
		xhr.setRequestHeader("Content-type", "application/json");
		//set content type here 
		xhr.send(JSON.stringify(book));
	}





	function populateBookTable(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				books = JSON.parse(xhr.responseText);
				console.log(books);
				for(var b of books){
					addBookToTable(b); //helper function to create elements
				}
			}

		}
		xhr.open("GET", "books");
		xhr.send();
	}

	function addBookToTable(b){
		var row = document.createElement("tr");
		var cell1 = document.createElement("td");
		var cell2 = document.createElement("td");
		var cell3 = document.createElement("td");
		var cell4 = document.createElement("td");
		console.log(b);
		cell1.innerHTML = b.isbn;
		cell2.innerHTML = b.title;
		cell3.innerHTML = b.price;
		cell4.innerHTML = b.genreId;

		row.appendChild(cell1);
		row.appendChild(cell2);
		row.appendChild(cell3);
		row.appendChild(cell4);

		document.getElementById("bookTable").appendChild(row);
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