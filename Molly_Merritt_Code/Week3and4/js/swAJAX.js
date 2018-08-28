window.onload = function() {
    $("#getInfo").on('click', doAJAX);
}

function doAJAX() {
    var id = $("#id").val();
    console.log(id);

    // AJAX
    // STEP 1 - create new XHR
    var xhr = new XMLHttpRequest();

    // STEP 2 - define callback function
    xhr.onreadystatechange = function() {
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200) {   // we can't access this info outside b/c it's asynchronous
                                                        // the rest of the program doesn't wait for this to be done
            // DEFINE FUNCTIONALITY FOR RESPONSE
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);    // turn JSON string into an object using JSON.parse()
        }
    }

    // STEP 3 - open
    var url = `https://swapi.co/api/people/${id}/`;
    xhr.open("GET", url, true);

    // STEP 4 - send request
    xhr.send();
}