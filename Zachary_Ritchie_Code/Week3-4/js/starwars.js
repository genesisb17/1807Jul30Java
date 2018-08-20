window.onload = function()
{
    $("#getInfo").on("click", doAJAX);
    $("#getInfoMovie").on("click", getMovie);
}

function getMovie()
{
    var id = $("#movieID").val();

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function()
    {
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200)
        {
            //Define functionality for response
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
        }        
    }

    var url = `http://www.omdbapi.com/?apikey=${id}&`;
    xhr.open("GET", url, true);

    xhr.send();
}

function doAJAX()
{
    var id = $("#swID").val();
    ///AJAX///
    //Step 1 - create new XHR
    var xhr = new XMLHttpRequest();

    //Step 2 - define callback function
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200)
        {
            //Define functionality for response
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
        }
    }

    //Step 3 - open request
    var url = `https://swapi.co/api/people/${id}/`;
    xhr.open("GET", url, true);

    //Step 4 - send a request
    xhr.send();

}