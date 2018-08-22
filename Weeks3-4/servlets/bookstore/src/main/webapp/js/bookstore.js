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
		}
		
	}
	xhr.open("GET", "home.view");
	xhr.send();
	
}

function loadBooksView(){
	
}