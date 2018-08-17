'use strict';

function getAccountsForUser(userId, callback) {
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4 && xhr.status === 200) {
      callback(JSON.parse(xhr.responseText));
    }
  };
  xhr.open('GET', `http://localhost:3000/accounts?owner=${userId}`);
  xhr.send();
}

function getUserByUsername(username, callback) {
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4 && xhr.status === 200) {
      const found = JSON.parse(xhr.responseText);
      callback(found.length === 1 ? found[0] : null);
    }
  };
  xhr.open(
    'GET',
    `http://localhost:3000/users?username=${encodeURIComponent(
      username.toLowerCase()
    )}`
  );
  xhr.send();
}

function addNewUser(user, callback) {
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4) {
      callback(xhr.status, JSON.parse(xhr.responseText));
    }
  };
  xhr.open('POST', 'http://localhost:3000/users');
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(JSON.stringify(user));
}

function addAccountForUser(userId, callback) {
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4) {
      callback(xhr.status, JSON.parse(xhr.responseText));
    }
  };
  xhr.open('POST', 'http://localhost:3000/accounts');
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(JSON.stringify({ balance: 0, owner: userId }));
}

function userSession(user) {
  // Make the welcome header.
  const welcomeHead = document.getElementById('welcome-header');
  welcomeHead.textContent = `Welcome, ${user.firstName} ${user.lastName}!`;
  // Populate the accounts table.
  const accountsTable = document.getElementById('accounts');
  getAccountsForUser(user.id, accounts => {
    for (const account of accounts) {
      const tr = document.createElement('tr');
      const id = document.createElement('td');
      id.textContent = account.id;
      const balance = document.createElement('td');
      balance.textContent = account.balance;
      tr.appendChild(id);
      tr.appendChild(balance);
      accountsTable.appendChild(tr);
    }

    document.getElementById('landing-view').setAttribute('hidden', 'true');
    document.getElementById('welcome-view').removeAttribute('hidden');
  });

  // Add the event handler for the "add account" button.
  document.getElementById('add-account').addEventListener('click', () => {
    console.log(user.id);
    addAccountForUser(user.id, (status, account) => {
      if (status === 201) {
        const tr = document.createElement('tr');
        const id = document.createElement('td');
        id.textContent = account.id;
        const balance = document.createElement('td');
        balance.textContent = account.balance;
        tr.appendChild(id);
        tr.appendChild(balance);
        accountsTable.appendChild(tr);
      }
    });
  });
}

function login() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const message = document.getElementById('message');

  if (username.length > 0 && password.length > 0) {
    // Send AJAX request to get user by username.
    message.setAttribute('hidden', 'true');
    const user = getUserByUsername(username, user => {
      if (user) {
        if (user.password === password) {
          // Password correct.
          userSession(user);
        } else {
          message.textContent = 'Password incorrect.';
          message.removeAttribute('hidden');
        }
      } else {
        message.textContent = 'User not found.';
        message.removeAttribute('hidden');
      }
    });
  } else {
    // Tell user to fill in username and password.
    message.textContent = 'Please enter a username and password first.';
    message.removeAttribute('hidden');
  }
}

function showRegistration() {
  // Show registration components.
  const firstName = document.getElementById('first-name');
  const lastName = document.getElementById('last-name');
  const register = document.getElementById('register');
  firstName.removeAttribute('hidden');
  lastName.removeAttribute('hidden');
  register.removeAttribute('hidden');
  // Hide others.
  document.getElementById('login').setAttribute('hidden', 'true');
  document.getElementById('register-message').setAttribute('hidden', 'true');
}

function register() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const firstName = document.getElementById('first-name').value;
  const lastName = document.getElementById('last-name').value;

  // Make sure the username isn't taken.
  getUserByUsername(username, user => {
    if (user) {
      const message = document.getElementById('message');
      message.textContent = 'Username already taken.';
      message.removeAttribute('hidden');
    } else {
      addNewUser(
        { firstName, lastName, username, password },
        (status, user) => {
          if (status === 201) {
            userSession(user);
          }
        }
      );
    }
  });
}

function validateUsername() {
  const username = document.getElementById('username').value;
  const registerMessage = document.getElementById('register-message');
  console.log(registerMessage);
  getUserByUsername(username, user => {
    if (user) {
      registerMessage.setAttribute('hidden', 'true');
    } else {
      registerMessage.removeAttribute('hidden');
    }
  });
}

window.onload = () => {
  document.getElementById('login').addEventListener('click', login);
  document
    .getElementById('register-link')
    .addEventListener('click', showRegistration);
  document
    .getElementById('username')
    .addEventListener('blur', validateUsername);
  document.getElementById('register').addEventListener('click', register);
};
