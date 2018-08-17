// -----------------------------------------------------------------------------------
// Create an HTML file that takes in input and carries out at least 8
// of the following functions and manipulates the DOM to show the outcome.
// (Can include #1, though we've completed it together in class)
// Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------
window.onload = function() {
    // fib();
    document.getElementById("goFib").addEventListener("click", fib, true);

    // bubbleSort();
    document.getElementById("goBubble").addEventListener("click", bubbleSort, true);

    // reverseStr();
    document.getElementById("goReverse").addEventListener("click", reverseStr, true);

    // factorial();
    document.getElementById("goFact").addEventListener("click", factorial, true);

    // isPalindrome();
    document.getElementById("goPal").addEventListener("click", isPalindrome, true);

    // spliceElement();
    document.getElementById("goSplice").addEventListener("click", spliceElement, true);

    clock();

    // descOrder();
    document.getElementById("goDesc").addEventListener("click", descOrder, true);


}

//1. Fibonacci
function fib(){
    var num = document.getElementById('fib').value;
    let arr = [0, 1];
    for (let i = 2; i < num + 1; i++){
        arr.push(arr[i - 2] + arr[i -1])
    }
    var b = arr[num]
    // return b;
    document.getElementById("fb").innerHTML = b;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

// var a = [3,8,4,2,5,1,7,6];

function bubbleSort(){//-   -   -   -   -   -   -   -   -   -   -   -   -
    var someStr = document.getElementById('bubble').value;
    
    var array = someStr.split(" ");
    
    var arrayLength = array.length;
    var i; var j; var temp; var count = 0;
    for(i = 0; i < arrayLength; i++) {
        for(j = 0; j < arrayLength - 1; j++) {
            if(array[j] < array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    var b = "";
    for(var i = 0; i<array.length; i++){
        b += array[i] + "  ";
    }
    document.getElementById("bb").innerHTML = b;
}
// bubbleSort(a);

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseStr(){
    var someStr = document.getElementById('reverse').value;
                    //return an array split into individual characters
    var splitStr = someStr.split("");
                                        //reverse
    var reverseArr = splitStr.reverse();
                                        //bring the chars back together
    var joinArr = reverseArr.join("");

    //return joinArr;
    document.getElementById("rs").innerHTML = joinArr;
}
// reverseStr("HELLO, WORLLLLLLLDDDDD");

// 4. Factorial 
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(){
    var num = document.getElementById('fact').value;
    var result = num;
    if (num === 0 || num === 1){ 
        result = 1; 
    }
    while (num > 1) { 
        num--;
        result *= num;
    }
    // return result;
    document.getElementById("fc").innerHTML = result;
}

// 7. Palindrome 
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(){
    var someStr = document.getElementById('pal').value;
    var isPal = false;
    var newStr = "";
    for(var i = someStr.length - 1; i >=0; i--){
        newStr += someStr[i];
    }
    if(newStr == someStr){
        isPal = true;
    }
    document.getElementById("pl").innerHTML = isPal;
}
// 11. Splice Element 
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
var b = [3,8,4,2,5,1,7,6];
function spliceElement(){            //- -   -   -   - CHECK
    var someArr = document.getElementById('splice').value;
    var arr = someArr.split(" ");
    console.log(arr)
    var lenArr = arr.length;
    document.getElementById("sp").innerHTML = lenArr;
    //js uses splice to remove an index
    arr.splice(2,1);
    //but make the length the same??? not sure
    var lenArr2 = arr.length;
    document.getElementById("sp2").innerHTML = lenArr2;
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age){
    this.firstName = name;
    this.age = age;
}
var john = new Person("John", 30);
// console.log(john.firstName);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
var  getPerson = {
    //name: "John"
    setName: function(newName){
        this.name = newName;
    },
    setAge: function(newAge){
        this.age = newAge;
    }
}
//not sure that var john = getPerson("John", 30); works, but

// 14. Display the current time on the top right of your HTML page, -----------CHECK
// updating every second
function clock(){
    var d = new Date();
    var now = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    //setting the content of the element with the ID time
    document.getElementById('time').innerHTML = now;
    var t = setTimeout(clock, 500);
    //return now;
}
// 15.  Descending order    
// Your task is to make a function that can take any non-negative 
// integer as a argument and return its with its digits in descending 
// order. Essentially, rearrange the digits to create the highest possible number.
function descOrder(){
    var num = document.getElementById('desc').value;
    var str = "";
    if(num >= 0){
        str = parseInt(String(num).split('').sort().reverse().join(''))
        document.getElementById("do").innerHTML = str;
    } else{
        var message = "Enter a positive number";
        document.getElementById("do").innerHTML = message;
    }
    
    // return str;
    
}