window.onload = function(){
    $("#getInfo").on('click', doAJAX);
}

function doAJAX(){
    var id = $('#swID').val();

    //AJAX!!!!!!!
    //STEP 1 - create new XHR
    var xhr = new XMLHttpRequest();


    //STEP 2 - define callback function
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            //DEFINE FUNCTIONALITY FOR RESPONSE
            resp = xhr.responseText;
            Pokemon = JSON.parse(resp);
        }
    }

    //STEP 3 - OPEN REQUEST
    var url = `https://pokeapi.co/api/v2/pokemon/${id}/`;
    xhr.open("GET", url, true);

    //STEP 4 - SEND REQUEST
    xhr.send(); 
}