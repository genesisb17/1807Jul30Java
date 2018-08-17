window.onload = function(){
    //add event listener to sw button
    //get element w/ id = getInfo
    $("#getInfo").on('click', doAJAX);
    getNASA();    
}
var swPerson;

function doAJAX() {
    var id =$('#swId').val();

    //AJAX
    //step 1. create new xhr
    var xhr = new XMLHttpRequest(); //CASE SENSITIVE FUNCTIONS

    //step 2. define callback function
    xhr.onreadystatechange= function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            //DEFINE FUNCITONALITY FOR RESPONSE
            //this is the only place we can process the response to an http request
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
        }
    }

    //step 3. open request
    var url = `https://swapi.co/api/people/${id}/`;
    //type of request, url, true indicates this is an asynchronous request
    xhr.open("GET", url, true);

    //step 4. send request
    xhr.send(); //get request do not have a request body so this is empty
}

function getNASA() {
    var id =$('#swId').val();

    var url = "https://api.nasa.gov/planetary/apod?api_key=MSLmZRm0lJJJHtnDsmevLKWwmQ6CAdBM8mtFOOiL";
    $.ajax({
        url: url,
        success: function(result){
        if("copyright" in result) {
          $("#copyright").text("Image Credits: " + result.copyright);
        }
        else {
          $("#copyright").text("Image Credits: " + "Public Domain");
        }
        
        if(result.media_type == "video") {
          $("#apod_img_id").css("display", "none"); 
          $("#apod_vid_id").attr("src", result.url);
        }
        else {
          $("#apod_vid_id").css("display", "none"); 
          $("#apod_img_id").attr("src", result.url);
        }
        $("#reqObject").text(url);
        $("#returnObject").text(JSON.stringify(result, null, 4));  
        $("#apod_explaination").text(result.explanation);
        $("#apod_title").text(result.title);
      }
      });

}

