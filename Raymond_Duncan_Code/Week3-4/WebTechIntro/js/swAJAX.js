window.onload = function(){
    console.log("Window loaded");
    $("#getInfo").on('click', getInfo);
}

function getInfo(){
    var id = $('#id').val();

    //AJAX
    //Step 1 - Create new XMLHTTPRequest object
    var xhr = new XMLHttpRequest();

    //Step 2 - define callcack function
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 &&  xhr.status == 200){
            //Define functionality for response
            /* This is the only place that we can process our response */
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
            console.log(resp);
            console.log(swPerson);
            document.getElementById("results").innerHTML = JSON.stringify(swPerson);

        }
    }

    //Step 3 - Open
    var url = `https://swapi.co/api/people/${id}/`;
    xhr.open("GET", url, true);

    //Step 4 - Send the request
    xhr.send();
}