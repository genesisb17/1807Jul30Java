//Number 1
document.getElementById("fibSubmit").addEventListener("click", fib, true);

function fib() {
    var fibNum = document.getElementById("fib").value;

    var fibbArray = [];
    fibbArray[0] = 0;
    fibbArray[1] = 1;
    for(let i = 2; i <= fibNum; i++) {
        fibbArray[i] = fibbArray[i - 1] + fibbArray[i - 2];
    }

    document.getElementById("fibbOutput").innerHTML = fibbArray[fibNum];
    
}

//Number 2
let bubbleArray = [];
document.getElementById("bubbleAdd").addEventListener("click", bubbleAdd, true);
document.getElementById("bubbleSort").addEventListener("click", bubbleSort, true);

function bubbleAdd() {
    var bubbleNum = parseInt(document.getElementById("bubble").value);
    document.getElementById("bubbleAdded").innerHTML = `${bubbleNum} added!`;
    bubbleArray.push(bubbleNum);
}

function bubbleSort() {

    for(let i = 0; i < bubbleArray.length - 1; i++) {

            while(bubbleArray[i] > bubbleArray[i+1]) {

                let temp = bubbleArray[i];
                bubbleArray[i] = bubbleArray[i+1];
                bubbleArray[i+1] = temp;
                i = 0;

            }
        
    }

    document.getElementById("bubbleOutput").innerHTML = bubbleArray;
}

//Number 3
document.getElementById("reStringSubmit").addEventListener("click", reString, true);

function reString() {

    let stringSplit = (document.getElementById("reverse").value).split("");
    let repeatString = [];
    let reverseCount = stringSplit.length;

    for(let i = 0; i < stringSplit.length + 1; i++) {

        repeatString[i] = stringSplit[reverseCount];
        --reverseCount;
        
    }

    let reverseString = repeatString.join("");
    document.getElementById("reStringOutput").innerHTML = reverseString;
}

//Problem 4
document.getElementById("factorialSubmit").addEventListener("click", fact, true);

function fact() {

    let factNum = parseInt(document.getElementById("factorialNum").value);
    factorial(factNum, factNum);
}

function factorial(n, counter) {

    if(counter > 1) {
        n *= counter-1;
        counter--;
        return factorial(n, counter);
    }

    document.getElementById("factorialOutput").innerHTML = n;

}

//Number5
document.getElementById("substringSubmit").addEventListener("click", offsetString, true);

function offsetString() {

    let stringy = (document.getElementById("stringSub").value).split('');
    let offsetNum = parseInt(document.getElementById("offset").value);
    let length = parseInt(document.getElementById("length").value);

    let stringTemp = [];

    for(let i = 0; i < length; i++) {
        stringTemp[i] = stringy[offsetNum + i];
    }

    document.getElementById("subStringOutput").innerHTML = stringTemp.join('');
}

//Number 6
document.getElementById("eoSubmit").addEventListener("click", eo, true);

function eo() {
    var eoNum = document.getElementById("eoNum").value;

    while(eoNum > 1) {
        eoNum = eoNum - 2;
    }

    if(eoNum == 0) {
        document.getElementById("eoOutput").innerHTML = 'The number is even!';
    } else {
        document.getElementById("eoOutput").innerHTML = 'The number is odd!';
    }

}

//Number 7
document.getElementById("palinSubmit").addEventListener("click", palin, true);

function palin() {

    var palinOG = document.getElementById("palinString").value;
    var palinOGArray = (document.getElementById("palinString").value).split('');

    var reversePalinArray = [];

    for(let i = 0; i < palinOGArray.length; i++) {

        reversePalinArray[i] = palinOGArray[palinOGArray.length - i - 1];

    }

    let tempReverse = reversePalinArray.join('');

    if(tempReverse == palinOG) {
        document.getElementById("palinOutput").innerHTML = 'True';
    } else {
        document.getElementById("palinOutput").innerHTML = 'False';
    }
}

//Number 8
document.getElementById("descSubmit").addEventListener("click", desc, true);

function desc() {

    var descArray = (document.getElementById("descNum").value).split('');

    for(let i = 0; i < descArray.length-1; i++) {

        while(descArray[i] < descArray[i+1]) {
            let temp = parseInt(descArray[i+1]);
            descArray[i+1] = parseInt(descArray[i]);
            descArray[i] = temp;
            i = 0;
        }  
    }

    document.getElementById("descOutput").innerHTML = descArray.join('');
}

//Number 9
document.getElementById("timeStart").addEventListener("click", startTime, true);

function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('time').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};
    return i;
}

//Number 10

function getPerson(name, age) {
    var person = {name1: name, age1: age};
    return person;
}

var john = getPerson("John", 30);

//document.getElementById("timeStart").addEventListener("click", getPerson, true);
document.getElementById("objLitOutput").innerHTML = `Name: ${john.name1} | Age: ${john.age1}`;





