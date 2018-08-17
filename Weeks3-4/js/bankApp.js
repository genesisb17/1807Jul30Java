window.onload = function(){
    $('#logIn').on('click', logIn);
    $('#showRegView').on('click', showRegisterView);
}

function showRegisterView(){
    console.log("make new user");
    $('#logIn').detach();
    $('#firstname').removeAttr('hidden');
    $('#lastname').removeAttr('hidden');
    $('#register').removeAttr('hidden');
    $('#showRegView').attr('hidden', 'true');
    $('#register').on('click', register);
    $('#username').on('blur', validateUsername);
}

function validateUsername(){
    console.log("BLURRED!");
    let username = $('#username').val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var arr = JSON.parse(xhr.responseText);
            if(arr.length==1){
                var elem = $('#message');
                elem.removeAttr("hidden");
                elem.html("Sorry, you have an invalid username");   
            }
            else{
                $('#message').attr('hidden', 'true');
            }
        }
    }

    xhr.open("GET", 
    `http://localhost:3000/users?username=${username.toLowerCase()}`, true);
    xhr.send();
}

function register(){
    //add new user
    let uname = $('#username').val();
    let pw = $('#password').val();
    let fn = $('#firstname').val();
    let ln = $('#lastname').val();
    let user = {
        firstName: fn,
        lastName: ln,
        username: uname,
        password: pw
    };

    let reqBody = JSON.stringify(user);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status==201){
            let user = JSON.parse(xhr.responseText);
            $('#landingView').attr('hidden', 'true');
            $('#homeView').removeAttr('hidden');
            $('#greeting').html(`Welcome ${user.firstName}`);
        }

    }
    xhr.open("POST", "http://localhost:3000/users", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(reqBody);

}

function logIn(){
    //Log in function
    let username = $('#username').val();
    let password = $('#password').val();
    if(username.length>0 && password.length>0){
        //send ajax request to get user by username 
        $('#message').attr('hidden', 'true');

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4 && xhr.status == 200){
                var arr = JSON.parse(xhr.responseText);
                if(arr.length==1){
                    //got back user
                    let user = arr[0];
                    if(user.password == password){
                        //successfully logged in
                        $('#message').attr('hidden', 'true');
                        console.log("logged in");
                        $('#landingView').attr('hidden', 'true');
                        $('#homeView').removeAttr('hidden');
                        $('#greeting').html(`Welcome ${user.firstName}`);
                    }
                    else{
                        var elem = $('#message');
                        elem.removeAttr("hidden");
                        elem.html("Invalid Credentials");
                    }
                    
                }
                else{
                    //do not have user by username OR there is more than 1
                    //which is also bad
                    var elem = $('#message');
                    elem.removeAttr("hidden");
                    elem.html("Sorry, you have an invalid username");
                }
            }
        }

        xhr.open("GET", 
        `http://localhost:3000/users?username=${username.toLowerCase()}`, true);
        xhr.send();

    }
    else{
        //tell user to not attempt to submit empty fields
        var elem = $('#message');
        elem.removeAttr("hidden");
        elem.html("Please fill out all form fields!");
        //innerHTML = text is vanilla JS. html(text) is jQuery
    }
}