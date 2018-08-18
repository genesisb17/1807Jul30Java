window.onload = function() {
    //alert('JS is loaded!');
    //ADD EVENT LISTENER TO BUTTON
    //Parameters are event, function, and propagate
    document.getElementById("logIn").addEventListener(
        "click", getUserInfo, true);
}

function getUserInfo(z) {
    console.log("in get user4 function");
    var uname = document.getElementById("username").value;
    var pw = document.getElementById("password").value;
    console.log(uname);
    console.log(pw);
}