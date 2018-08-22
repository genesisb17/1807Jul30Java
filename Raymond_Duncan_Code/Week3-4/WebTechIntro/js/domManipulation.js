window.onload = function(){
    this.alert('JS is loaded!')
    //ADD EVENT LISTENER TO BUTTON
    //addEventListener(event,function,propogate);
    document.getElementById("logIn").addEventListener(
        //Common types of events: blur, mouserover, keyboardevent, etc.
        'click', getUserInfo, true
    );
}

function getUserInfo(){
    console.log("In getUserInfo function")
    var uname = document.getElementById("username").value;
    var pw = document.getElementById("password").value;

    console.log(uname);
    console.log(pw);
}