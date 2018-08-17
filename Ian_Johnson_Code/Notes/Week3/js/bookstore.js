window.onload = function() {
  loadGenres();
  document.getElementById('add-book').addEventListener('click', addBook, true);
};

function loadGenres() {
  const genres = ['Cooking', 'Fiction', 'History', 'Non-fiction'];
  for (let genre of genres) {
    const element = document.createElement('option');
    element.value = genre;
    element.textContent = genre;
    document.getElementById('genre').appendChild(element);
  }
}

let nextId = 1;
function addBook() {
  const id = nextId++;
  const title = document.getElementById('title').value;
  const isbn = document.getElementById('isbn').value;
  const price = document.getElementById('price').value;
  const genre = document.getElementById('genre').value;

  const books = document.getElementById('books');
  const row = document.createElement('tr');
  for (let col of [id, title, isbn, price, genre]) {
    const td = document.createElement('td');
    td.innerHTML = col;
    row.appendChild(td);
  }
  books.appendChild(row);
}
