window.onload = function () {
    // alert('JS is loaded!');
    //ADD EVENT LISTENER TO BUTTON
    //addEventListener(event, function, propagate)
    document.getElementById("logIn").addEventListener(
        "click", logIn, true);

    document.getElementById("username").addEventListener("blur", validateUser, true);

}

function validateUser() {
    var uname = document.getElementById("username").value;
    if (!existsByUserName(uname)) {
        document.getElementById("message").innerText = "Invalid Username";
        let classes = "alert alert-danger form-control";
        addClassToElement("message", classes.split(" ")); //helper function to add classes to element
        /*   document.getElementById("message").classList.add("alert");
           document.getElementById("message").classList.add("alert-danger");
           document.getElementById("message").classList.add("form-control"); */
        document.getElementById("message").hidden = false;
    }
    else {
        document.getElementById("message").hidden = true;
    }
}

function getUsers() { //in memory store of users
    var users = [
        { username: "Genesis", password: "123", balance: 0 },
        { username: "testUser", password: "pass", balance: 0 },
        { username: "Ravi", password: "manager", balance: 0 },
        { username: "test", password: "user", balance: 0 }
    ]
    return users;
}

function existsByUserName(username) {
    var user = getUsers().filter(u => (u.username).toLowerCase() == username.toLowerCase());
    return user.length > 0;
}

function logIn() {
    console.log("in log in function");
    var uname = document.getElementById("username").value;
    var pw = document.getElementById("password").value;
    console.log(uname + ' ' + pw);
    if (uname.length == 0 || pw.length == 0) {
        //add input validation
    }
    else {
        console.log("fields filled");
        document.getElementById("logIn").disabled = false;
        let logged = getUsers().filter(u => (u.username).toLowerCase() == uname.toLowerCase())[0];
        console.log(logged);
        if (logged["password"] == pw) {
            console.log("correct");
            loadHomePage(logged);
        }
        else {
            //send error message
        }
    }
}

function loadHomePage(user) {
    var elem = document.getElementById("logInView");
    elem.parentNode.removeChild(elem);
    document.getElementById("homeView").removeAttribute("hidden");
    document.getElementById("greeting").innerText = `Welcome ${user.username}! Your Balance is ${user.balance}.`;

}

///////////////////helper functions
function addClassToElement(element, classes) {
    for (let c of classes) {
        document.getElementById(element).classList.add(c);
    }
}