function populateResults(json) {
  const results = document.getElementById('results');
  results.innerHTML = '';

  for (let i = 0; i < json[1].length; i++) {
    const tr = document.createElement('tr');
    const title = document.createElement('td');
    title.textContent = json[1][i];
    const description = document.createElement('td');
    description.textContent = json[2][i];
    const linkData = document.createElement('td');
    const link = document.createElement('a');
    link.href = json[3][i];
    link.textContent = json[3][i];
    linkData.appendChild(link);

    tr.appendChild(title);
    tr.appendChild(description);
    tr.appendChild(linkData);
    results.appendChild(tr);
  }
}

function search() {
  const searchText = document.getElementById('search-box').value;
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4 && xhr.status === 200) {
      const json = JSON.parse(xhr.responseText);
      populateResults(json);
    }
  };
  xhr.open(
    'GET',
    `https://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=${encodeURIComponent(
      searchText
    )}&origin=*`
  );
  xhr.send();
}

window.onload = () => {
  document.getElementById('search-button').addEventListener('click', search);
};
