window.onload = function(){
    doDate();

    document.getElementById("abort").addEventListener("click", revealAbort);
    document.getElementById("xhr").addEventListener("click", revealxhr);
    document.getElementById("async").addEventListener("click", revealasync);
    document.getElementById("states").addEventListener("click", revealstates);
    document.getElementById("requestHeader").addEventListener("click", revealheader);
    document.getElementById("ajax").addEventListener("click", revealajax);
    
}

function revealAbort(){
    $("#abort2").attr("hidden",false);
     
}
function revealxhr(){
    $("#xhr2").attr("hidden",false);
}
function revealasync(){
    $("#async2").attr("hidden",false);
     
}
function revealstates(){
    $("#states2").attr("hidden",false);
     
}
function revealheader(){
    $("#requestHeader2").attr("hidden",false);
     
}
function revealajax(){
    $("#ajax2").attr("hidden",false);
     
}

function doDate()
{
    var str = "";

    let days = new Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    let months = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    let now = new Date();

    str += "Current Time: " + now.getHours() +":" + now.getMinutes() + ":" + now.getSeconds();
    document.getElementById("timekeeper").innerHTML = str;
}

setInterval(doDate, 1000);

