window.onload = function() {
    // alert('JS is loaded!');

    // ADD EVENT LISTENER TO BUTTON
    // addEventListener(event, function, propagate)
    document.getElementById("logIn").addEventListener(
        "click", getUserInfo, true);    // getUserInfo has no parentheses because we don't want
                                        // it to be called as soon as we load our page
}

function getUserInfo() {
    console.log("in user function");
    var uname = document.getElementById("username");
    var pw = document.getElementById("password");
    console.log(uname);
    console.log(pw);
}