/**
 * Single JS script for entire bookstore app. 
 * Separate functionality into methods and keep as organized as possible becasue this will be lengthy
 */

window.onload = function(){
    loadHomeView();
    $("#home-nav").on("click",loadHomeView);
    $("#books-nav").on("click",loadBooksView);
    $("#authors-nav").on("click",loadAuthorsView);
    $("#genres-nav").on("click",loadGenresView);
    
}

loadHomeView = function(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $("#view").html(xhr.responseText);
        }
    }
    xhr.open("GET","home.view");
    xhr.send();

}

loadBooksView = function(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $("#view").html(xhr.responseText);
            //Once view is loaded, populate table and add eventListener
            populateBookTable();
        }
    }
    xhr.open("GET","books.view");
    xhr.send();
}
 
populateBookTable = function(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            //console.log(xhr.responseText);
            for(let b of books){
                addBook(b) //helper function to create elements
            }
        }
    }
    xhr.open("GET","books");
    xhr.send();
}

addBooks = function(){
    let row =  document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");

    cell1.innerHTML = b.isbn;
    cell2.innerHTML = b.title;
    cell3.innerHTML = b.price;
    cell4.innerHTML = b.genreID;

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);

    document.getElementById("book-table").appendChild(row);
}

loadAuthorsView = function(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $("#view").html(xhr.responseText);
        }
    }
    xhr.open("GET","authors.view");
    xhr.send();
}

loadGenresView = function(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $("#view").html(xhr.responseText);
        }
    }
    xhr.open("GET","genres.view");
    xhr.send();
}