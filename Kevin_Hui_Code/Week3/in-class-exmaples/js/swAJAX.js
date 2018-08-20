window.onload = function(){
    $("#getInfo").on('click', doAJAX);
}

function doAJAX(){
    //AJAX!!!!!!!
    //STEP 1 - create new XHR
    var xhr = new XMLHttpRequest();


    //STEP 2 - define callback function
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            //DEFINE FUNCTIONALITY FOR RESPONSE
            resp = xhr.responseText;
            parsed = JSON.parse(resp);
            console.log(parsed);
        }
    }

    //STEP 3 - OPEN REQUEST
    var url = `https://api.wmata.com/StationPrediction.svc/GetPrediction/All`;
    xhr.open("GET", url, true);
    //xhr.setRequestHeader('Host', 'api.wmata.com');
    //xhr.setRequestHeader('api_key', 'e13626d03d8e4c03ac07f95541b3091b');
    parameters = "api_key=e13626d03d8e4c03ac07f95541b3091b"


    //STEP 4 - SEND REQUEST
    xhr.send(parameters); 
}