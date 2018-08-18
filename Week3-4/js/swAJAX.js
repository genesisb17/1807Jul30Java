window.onload = function() {
    $("#getInfo").on('click', getInfo);
}

function getInfo() {
    var id = $('#id').val();

    //AJAX//
    //STEP 1 - create new XHR
    var xhr = new XMLHttpRequest();

    //STEP 2 - define callback function
    xhr.onreadystatechange = function() {
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200) {
            //DEFINE functionlaity for response
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
        }
    }

    //STEP 3 - OPEN REQUEST
    var url = `https://swapi.co/api/people/${id}/`
    xhr.open("GET", url, true);

    //STEP 4 - SEND REQUEST
    xhr.send();
}