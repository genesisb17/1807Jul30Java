window.onload = function(){
    $('#logIn').on('click', logIn);
    $('#showRegView').on('click', showRegisterView);
}

function showRegisterView() {
    $('#logIn').detach();
    
}