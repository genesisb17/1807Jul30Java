window.onload = () => {
	loadView('home')();
	
	document.getElementById('home').addEventListener('click', loadView('home'));
	document.getElementById('books').addEventListener('click', loadView('book', populateBookTable));
	document.getElementById('authors').addEventListener('click', loadView('author'));
	document.getElementById('genres').addEventListener('click', loadView('genre'));
};

function loadView(view, after) {
	return () => {
		const xhr = new XMLHttpRequest();
		xhr.onreadystatechange = () => {
			if (xhr.readyState === 4 && xhr.status === 200) {
				document.getElementById('view').innerHTML = xhr.responseText;
				after && after();
			}
		};
		xhr.open('GET', view + '.view');
		xhr.send();
	};
}

function populateBookTable() {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.readyState === 4 && xhr.status === 200) {
			const books = JSON.parse(xhr.responseText);
			for (const book of books) {
				addBook(book);
			}
		}
	};
	xhr.open('GET', 'books');
	xhr.send();
}

function addBook(book) {
	const tr = document.createElement('tr');
	for (const col of ['title', 'isbn', 'price', 'genreId']) {
		const td = document.createElement('td');
		td.textContent = book[col];
		tr.appendChild(td);
	}
	document.getElementById('book-table').appendChild(tr);
}