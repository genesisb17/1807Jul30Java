window.onload = () => {
  // addEventListener(event, function, propagate)
  document
    .getElementById('login-button')
    .addEventListener('click', getUserInfo, true);
};

function getUserInfo() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  console.log(`Username: ${username}`);
  console.log(`Password: ${password}`);
}
