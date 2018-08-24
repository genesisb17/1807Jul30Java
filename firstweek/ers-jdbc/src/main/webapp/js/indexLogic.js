window.onload = function() {
    windowLoad();
}

function windowLoad() {
    document.getElementById("loginbtn").addEventListener(
        "click", login, false
    );
    document.getElementById("createbtn").addEventListener(
        "click", createAccount, false
    );
    document.getElementById("loginbtn2").addEventListener(
        "click", backLogin, false
    );
    document.getElementById("createbtn2").addEventListener(
        "click", createsAccount, false
    );
}
function loggedIn() {
    $("#jumbodiv").attr("hidden","true");
}
function hideLogin() {
    $("#logindiv").attr("hidden","true");
}
function hideCreate() {
    $("#creatediv").attr("hidden","true");
}
function unhideLogin() {
    $("#logindiv").removeAttr("hidden");
}


function login() {
    var uname,upass;
    uname = document.getElementById("username").value;
    upass = document.getElementById("password").value;

    if(uname == "Dylan" && upass == "pass") {
        loggedIn();
        $("#whoslog").removeAttr('hidden');
        document.getElementById("whoslog").innerHTML = uname;

    } else {
        alert("Please enter in valid credentials.");
        $("#username").val('');
        $("#password").val('');
    }
}
// hides the login button and shows the button to take back to the log in
function hideLoginBtn() {
    $('#loginbtn').attr('hidden', 'true');
    $("#loginbtn2").removeAttr('hidden');
}

// hides the button that takes back to login and shows the real login button
function hideLoginBtn2() {
    $('#loginbtn2').attr('hidden', 'true');
    $("#loginbtn").removeAttr('hidden');
}

function hideCreateBtn() {
    $('#createbtn').attr('hidden', 'true');
    $("#createbtn2").removeAttr('hidden');
}

function hideCreateBtn2() {
    $('#createbtn2').attr('hidden', 'true');
    $("#createbtn").removeAttr('hidden');
}

function createAccount() {

    hideLogin();
    document.getElementById("creatediv").removeAttribute('hidden');
    hideLoginBtn();
    hideCreateBtn();
}

// Back to the login page
function backLogin() {
    hideCreate();
    unhideLogin();
    hideCreateBtn2();

}

function createsAccount() {
    
}
    


