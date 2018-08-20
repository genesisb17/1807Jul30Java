window.onload = function() {
   onLoadFunctions();
   
}

function loginFunction() {
    var x,y,z;
    x = document.getElementById("username").value;
    y = document.getElementById("password").value;
    z = document.getElementById("problems");

    if(x == "test" && y == "test") {
        z.removeAttribute("hidden");
    } else {
        alert("wrong credentials");
    }
}

function onLoadFunctions() {
    document.getElementById("login").addEventListener(
        "click", loginFunction, true
    );
    document.getElementById("login").addEventListener(
        "click", getUserInfo, true);
    document.getElementById("submit1").addEventListener(
        "click", returnFibonacci, true
    );
    document.getElementById("submit2").addEventListener(
        "click", bubbleSort, true
    );
    
   document.getElementById("submit3").addEventListener(
       "click", reverseString, true
   );

   document.getElementById("submit4").addEventListener( 
    "click", calculateFactorial, true
   );
   document.getElementById("submit5").addEventListener(
       "click", evenOrNot, true
   );
   document.getElementById("submit6").addEventListener(
       "click", isPalinDrome, true
   );

   document.getElementById("submit7").addEventListener(
       "click", printShape, true
   );
   document.getElementById("submit8").addEventListener(
       "click", person, true
   );
}

function getUserInfo() {
   
    var uname = document.getElementById("username").value;
    var pass = document.getElementById("password").value;
    console.log(uname,pass);
}

function printOutNumbers() {
    var x = 1;
    var y = 2;
   
    console.log(`The answer is ${x + y}`);
}

function returnFibonacci() {
    var x,y,result,n;
    x = 0;
    y = 1;
    n = document.getElementById("1inpt").value;
    for(var i = 0; i + 1 < n; i++) {    
        result = x + y;
        x = y;
        y = result;   
    }
   let answer = document.createElement("h3");
   answer.innerHTML = result;
   document.getElementById("card1").appendChild(answer); 
}

function bubbleSort() {
    var str, n;
    str = document.getElementById("2inpt").value;
    n = str.split(",");
    
    for(var i=0; i < n.length; i++) {
        for( var j = i+1; j<n.length; j++) {
          let temp = n[i];
            if(n[i] > n[j]) {
                
            
            n[i] = n[j];
            n[j] = temp;
            }	
        }
    }
    
    let answer = document.createElement("h3");
    answer.innerHTML = n.toString();
    document.getElementById("card2").appendChild(answer);

}

function reverseString() {
    var n, result;
    n = document.getElementById("3inpt").value;
    result = "";

    for(let i = n.length - 1; i > -1; i--) {
        result = result + n.charAt(i);
    }
    
    let answer = document.createElement("h3");
    answer.innerHTML = result;
    document.getElementById("card3").appendChild(answer);
}

function calculateFactorial() {
    var n, span;
    n = document.getElementById("4inpt").value;

    for(let i = n - 1; i>0; i--) {
        n = n * i;
    }
    span = document.getElementById("span4");
    span.innerHTML = n;

}

function evenOrNot(){
    var x, y;
    x = document.getElementById("5inpt").value;
    y = document.getElementById("span5");

    if((x % 2) == 0) {
        y.innerHTML = "The number is even."
    } else {
        y.innerHTML = "The number is odd.";
    }

}

function isPalinDrome() {
    var n, result, y;
    n = document.getElementById("6inpt").value;
    result = "";
    y = document.getElementById("span6");
    for(let i = n.length - 1; i > -1; i--) {
        result = result + n.charAt(i);
    }

    if (n == result) {
        y.innerHTML = `${n} is the same as ${result}.`;
    } else {
    y.innerHTML = `${n} is not the same as ${result}.`;
    }
}

function printShape() {
    var tag,w, x, y, z;
    w = document.getElementById("7inpt").value;
    tag = document.getElementById("span7");
    x = "square";
    y = "triangle";
    z = "diamond"
    switch (w) {
        case x :
            tag.innerHTML = "<br> %%% <br>\
                %%% <br>\
                %%%";
            
            break; 
        case y :
            tag.innerHTML = "<br>%<br>\
                   %%<br>\
                   %%%";
            
            break;
        case z :
            tag.innerHTML = "<br>%<br>\
                 %%<br>\
                 %%%<br>\
                 %%<br>\
                 %";
            
            break;
    }

}
function personObject(name){
    this.name = name;
}
function person() {
    var x,z;
    x = document.getElementById("8inpt").value;
    z = document.getElementById("span8");
  var y = new personObject(x);
    console.log(y.toString);
    z.innerHTML = y.name; 
    
}
