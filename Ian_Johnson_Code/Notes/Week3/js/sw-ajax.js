'use strict';

function getInfo() {
  const number = document.getElementById('input-number').value;
  // Let's make an AJAX request.
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4 && xhr.status === 200) {
      // Here's where we process the response.
      const responseJSON = JSON.parse(xhr.responseText);
      document.getElementById('output').textContent = JSON.stringify(
        responseJSON,
        null,
        2
      );
    }
  };
  xhr.open('GET', `https://www.swapi.co/api/people/${number}/`);
  xhr.send();
}

window.onload = () => {
  document.getElementById('get-info').addEventListener('click', getInfo);
};
