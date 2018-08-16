window.onload = function(){
    loadGenres();
    document.getElementById("addBook").addEventListener("click", addBook);
}

function loadGenres(){
    var genres=["Cooking", "Fiction", "History", "Non-Fiction"];
    for(let i = 0; i < genres.length; i++){
        var element = document.createElement("option");
        element.value = genres[i];
        element.innerHTML = genres[i];
        document.getElementById("genres").appendChild(element);
    }
}

function addBook(){
    console.log("add book!\nTEST");
    var isbn = document.getElementById("isbn").value;
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var el= document.getElementById("genres");
    var genre = el.options[el.selectedIndex].value;

    console.log(genre);
}