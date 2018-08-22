window.onload =function(){
    $('#getInfo').on("click", doAJAX);

}
function doAJAX(){
    var id = $('#swID').val();
    
    //AJAX!!!!!
    //STEP 1 - create new XHR
    var xhr = new XMLHttpRequest();

    //STEP 2 - ddefine callback function
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200 ){
            //DEFINE FUNCTIONALITY FOR RESPONSE
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
            console.log(swPerson);
            
        }
    }


    var url = `https://swapi.co/api/people/${id}/`;
    xhr.open("GET", url, true);

    xhr.send();
}

function returnInfo(){

}
