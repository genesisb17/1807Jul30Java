window.onload = function(){
    console.log("Window Loaded!");
    $("#button").on("click",search1);
}


tUrl = "https://api.twitter.com/1.1/search/tweets.json";
search1 = function(){
    let phrase = $("#phrase").val();
    console.log(phrase);

    //FOUR STEPS
    //Step 1 - create XHR object
    let xhr = new XMLHttpRequest();

    //Step 2 - define callback function
    xhr.onreadystatechange = function(){
        console.log(xhr.state);
        if(xhr.readyState == 4 && xhr.status == 200){
            //Define functionality for response
            resp = xhr.responseText;
            stuff = JSON.parse(resp);
            document.getElementById("results").innerHTML = stuff;
        }

    }

    //Step 3 - open
    url = `${tUrl}?q=${phrase}&result_type=recent`;
    xhr.open("GET",url,true);

    //Step 4 - send
    xhr.send();

}