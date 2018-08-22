baseUrl = "http://localhost:3000"
window.onload = function () {
    console.log("Welcome");
    $("#loginButton").on("click", logIn);
    $("#createAcctButton").on("click",registerAccount);
    $("#newAcctLink").on("click",loadRegisterView);
    $("#loginLink").on("click",loadLoginView);

}

logIn = function () {
    console.log("Loggin in");
    let username = $("#username").val();
    let password = $("#password").val();

    if (validUserCredentials(username, password)) {
        let loginMessage = $("#loginMessage")
        loginMessage.attr('hidden', 'true');

        //Send AJAX request to get user by username
        let xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                let users = JSON.parse(xhr.responseText);
                if (users.length == 1) {
                    //Success!
                    console.log("Log in now!")
                    loadHome(users[0]);

                } else {
                    //Failure!
                    loginMessage.html("Invalid Credentials!");
                    loginMessage.removeAttr("hidden");
                }
            }
        }

        let url = `${baseUrl}/users?uname=${username.toLowerCase()}&pword=${password}`;
        xhr.open("GET", url, true);
        xhr.send();


    } else {
        //Tell user not to submit empty fields
        var loginSpan = $("#loginMessage");
        loginSpan.removeAttr("hidden");
        loginSpan.html("Please fill out all form fields.");
    }
}

registerAccount = function () {
    let uname = $("#registerUname").val();
    let pw = $("#registerPwd").val();
    let fn = $("#firstname").val();
    let ln = $("#lastname").val();
    if (!validUserCredentials(uname, pw)) {
        return;
    }

    let user = {
        firstname: fn,
        lastname: ln,
        username: uname,
        password: pw
    }

    let reqBody = JSON.stringify(user);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 201) {
            let user = JSON.parse(xhr.responseText);
            console.log(user);
            loadHome(user);
        }
    }
}

loadRegisterView = function () {
    $("#loginView").attr("hidden", "true");
    $("#registerView").removeAttr("hidden");
}

loadLoginView = function () {
    $("#registerView").attr("hidden", "true");
    $("#loginView").removeAttr("hidden");

}

loadHome = function (user) {
    $("#landingPage").attr("hidden", "true");
    $("#homePage").removeAttr("hidden");
    $("#welcomeBanner").html(`Welcome ${user.firstname}`);

}

validUserCredentials = function (uname, pwd) {
    console.log(uname,pwd);
    if (uname.length == 0 && pwd.length == 0) {
        console.log("Invalid credentials")
        return false;
    }
    return true;
}

validFirstLast = function(firstname,lastname){
    if(firstname < 1 || lastname.length < 1){
        console.log("Firstname and Lastname fields cannot be empty");
        return false;
    } 
    return true;
}