window.onload = function(){
    document.getElementById("logIn").addEventListener(
        "click", getUserInfo, true);

}

function getUserInfo(){
    console.log("bloopers")
    var uname = document.getElementById("username");
    var pw = document.getElementById("password");
    console.log(uname);
    console.log(pw);
}