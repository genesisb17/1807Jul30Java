window.onload = function(){
    doAJAX();
}

function doAJAX(){
    var id = $('#id').val();

    //AJAX!!!!!!!
    //STEP 1 - create new XHR
    var xhr = new XMLHttpRequest();


    //STEP 2 - define callback function
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            //DEFINE FUNCTIONALITY FOR RESPONSE
            resp = xhr.responseText;
            console.log(resp);
            swPerson = JSON.parse(resp);
            console.log(swPerson);
            console.log(swPerson.mass);
        }
    }

    //STEP 3 - OPEN REQUEST
    var url = `https://swapi.co/api/people/${id}/`;
    xhr.open("GET", url, true);
    

    //STEP 4 - SEND REQUEST
    xhr.send(); 
}