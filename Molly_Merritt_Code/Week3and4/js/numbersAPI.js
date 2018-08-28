window.onload = function() {
    $("#getInfo").on('click', doAJAX);
}

function doAJAX() {
    var numId = $("#numId").val();
    var typeId = $("#typeId").val();

    // create new XHR
    var xhr = new XMLHttpRequest();

    // define callback function
    xhr.onreadystatechange = function() {
        console.log(xhr.readystate);
        if (xhr.readyState == 4 && xhr.status == 200) {
            resp = xhr.responseText;
            console.log(resp);
            // numFact = JSON.parse(resp);
            // console.log(numFact);
            $("#resp").html(resp);
        }
    }

    // open
    var url = `http://numbersapi.com/${numId}/${typeId}`;
    xhr.open("GET", url, true);

    // send request
    xhr.send();
}