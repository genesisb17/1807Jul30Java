window.onload = function(){
   // alert('JS is loaded!');
   //ADD EVENT LISTENER TO BUTTON
   //addEventListener(event, function, propagate)
   document.getElementById("logIn").addEventListener(
       "click", getUserInfo, true);

}

function getUserInfo(){
    console.log("in get user function");
    var uname = document.getElementById("username").value;
    var pw = document.getElementById("password").value;
    console.log(uname);
    console.log(pw);
}