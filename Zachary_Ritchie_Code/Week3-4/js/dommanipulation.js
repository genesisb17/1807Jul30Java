window.onload = function(){
    //alert("java script is loaded");

    // Add event listener to button
    //addEventListener(event, function, propagate)
    document.getElementById("Login").addEventListener(
        "click", getUserInfo, true);
}

function getUserInfo()
{
    console.log("In get user function");
    var uname = document.getElementById("username").value;
    var pword = document.getElementById("password").value;
    console.log(uname);
}