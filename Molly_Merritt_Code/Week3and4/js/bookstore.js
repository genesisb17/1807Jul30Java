window.onload = function() {    /* waits until the page is fully loaded before executing javascript */
                                /* also gives you a place to call all your functions */
    loadGenres();
    document.getElementById("addBook").addEventListener("click", addBook);
}

function loadGenres() {
    var genres=["Cooking", "Fiction", "History", "Non-Fiction"];
    for(let i = 0; i < genres.length; i++) {
        var element = document.createElement("option");
        element.value = genres[i];  /* value represents a value you can extract */
        element.innerHTML = genres[i];  /* innerHTML is everything between the element tags */
        document.getElementById("genres").appendChild(element);
    }
}
var count = 1;

function addBook() {
    // get input values
    var isbn = document.getElementById("isbn").value;   /* want value of input field, not entire element */
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var el = document.getElementById("genres");
    var genre = el.options[el.selectedIndex].value;
    var id = ++count;

    // generate new DOM elements
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");

    // assign our cells appropriate data
    cell1.innerHTML = id; /* here, we could do innerHTML or innerText */
    cell2.innerHTML = isbn;
    cell3.innerHTML = title;
    cell4.innerHTML = price;
    cell5.innerHTML = genre;

    // append elements to DOM
    row.appendChild(cell1); /* must append these in the correct order */
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);

    document.getElementById("booksTable").appendChild(row);

}