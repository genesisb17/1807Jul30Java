window.onload=function(){
    $('#login').on('click',login);

}
function login(){
    let username=$('#username').val();
    let password=$('#password').val();

    if(username.length>0 && password.length>0){
//send ajax request to get user by username
    }
    else{
// tell user to not attempt to submit empty fields
var elem=$('#message');
//elem.removeAttribute('hidden');
elem.html="Please fill out all form fields";
    }
}