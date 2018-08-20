window.onload = function(){
    doDate();
 
    document.getElementById("fibsubmit").addEventListener("click", fib);
    document.getElementById("reversesubmit").addEventListener("click", reverseString);
    document.getElementById("factorialsubmit").addEventListener("click", factorial);
    document.getElementById("evensubmit").addEventListener("click", isEven);
    document.getElementById("palindromesubmit").addEventListener("click", palindrome);
    document.getElementById("personsubmit").addEventListener("click", makePerson);
    document.getElementById("deletesubmit").addEventListener("click", deleteFromArray);
}

function fib(){

    let userinput=document.getElementById("fibinput").value;
    let calc=0;
    for(var i=0;i<userinput;i++){
        calc=calc+(i+1);
    }
    var item = document.createElement('li');
    item.innerText = calc;
    $("#answer").append(item);
     //console.log(calc);
}
function reverseString(){

   let userz=document.getElementById("reverseinput").value;
    var test= userz.split("").reverse().join("");
   var item = document.createElement('li');
   item.innerText = test;
   $("#reverseanswer").append(item);
}


function factorial(){
    let userinput=document.getElementById("factorialinput").value;
    let calc=userinput;
    for(var i=userinput-1;i>0;i--){
        calc=calc*i;
    }
    var item = document.createElement('li');
    item.innerText = calc;
    $("#facanswer").append(item);
    // console.log(calc);
}

function isEven(number){
    let userinput=document.getElementById("eveninput").value;


    let calc="";

    if(userinput%2!=0){
        calc=userinput+" is Odd";
    }
    else{
        calc=userinput+" is Even";
    }
    var item = document.createElement('li');
    item.innerText = calc;
    $("#evenanswer").append(item);
    
}

function palindrome(){
    let userz=document.getElementById("palindromeinput").value;

    var test= userz.split("").reverse().join("");
    var answer="";

    if(userz==test){
        answer=userz+" is a palindrome";
    }
    else answer=userz+" is not a palindrome";
    
   var item = document.createElement('li');
   item.innerText = answer;
   $("#panswer").append(item);
}
function makePerson(){
    let namez=document.getElementById("nameinput").value;
    let agez=document.getElementById("ageinput").value;
    var Person = {
        name: namez,
        age: agez
      
    };
   
    let b="New Person as object String: "+JSON.stringify(Person);
    //var answer="New Car name:"+namez+", New Car Color:"+colorz+",Number of wheels:"+wheels;
    var item = document.createElement('li');
    item.innerText = b;
    $("#personanswer").append(item);

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

function deleteFromArray(){
    
    let userz=document.getElementById("deleteInput").value;
    var test= userz.split(",")
    var t1length=0;

    for(var i=0;test[i]!=null;i++){
        t1length+=1;
    }
    
    test[2]='null';
    var tlength=0;

    for(var i=0;test[i]!=null;i++){
        tlength+=1;
    }
    var item = document.createElement('li');
    item.innerText = test;
    $("#deleteanswer").append(item);
    $("#deleteanswer").append("Old length: "+t1length+"NewLength: "+tlength);

}