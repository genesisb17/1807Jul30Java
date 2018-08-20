window.onload = function()
{
    $("#login").on("click", logIn);
}

function logIn()
{
    //Log in function
    let username = $("#username").val();
    let password = $("#password").val();

    if(username.length > 0 && password.length > 0)
    {
        //send ajax request to get user by username
        $("#message").attr("hidden", "true");

        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function()
        {
            if(xhr.readyState == 4 && xhr.status == 200)
            {
                console.log(xhr.responseText);
                var arr = JSON.parse(xhr.responseText);
                if(arr.length==1)
                {
                    //got back user
                    let user = arr[0];
                    if(user.password == password)
                    {
                        console.log("logged in");
                        $("#ladningView").attr("hidden", "true");
                        $("#homeView").removeAttr("hidden");
                        $("#greeting").html(`Welcome ${user.firstName}`);
                    }
                }
                else
                {
                    //do not have user by user name or there is more than 1 whichh is also bad
                    console.log("not correct")
                }
            }
            else
            {

            }
        }
        
        xhr.open("GET", `http://localhost:3000/users?username=${username.toLowerCase()}`, true);
        xhr.send();
    }
    else
    {
        //tell user to not attempt to submit empty fields
        var elem = $("#message");
        elem.html("Please fill out all form fields!");
        elem.removeAttr("hidden");
        //innerHTML = text is vanilla JS. html(text) is jQuery
    }
}

/*window.onload = function(){
    $('#login').on('click', logIn);
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
}*/