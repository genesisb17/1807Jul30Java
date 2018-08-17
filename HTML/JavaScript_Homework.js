// Checks the drop-down box for whichever
function checkFunction() {
    var dropdown = document.getElementById("functionselect");
    var selected = dropdown.options[dropdown.selectedIndex].value;
    var textbox = document.getElementById("input").value;

    // New function = new case part
    switch (selected) {
        case "reversestring" : 
        reverseStr(textbox);
        break;
        case "factorial" :
        factorial(textbox);
        break;
        case "evennumber" :
        isEven(textbox);
        break;
        case "palindrome" :
        isPalindrome(textbox);
        break;
        case "fibonacci" :
        fib(textbox);
        break;
        case "bubblesort" :
        bubbleSort(textbox);
        break;
        case "deleteelement" :
        deleteElement(textbox);
        break;
        case "spliceelement" :
        spliceElement(textbox);
        break;

    }
}

// 1. Fibonacci
function fib(n) {
    let newNum = Number(n);
    let a = 1;
    let b = 0;
    let temp;


    if (newNum < 0) {
        document.getElementById("output").innerHTML="Please enter a non-negative number.";
        return 0;
    }

    if (newNum <= 1) {
        document.getElementById("output").innerHTML=newNum;
        return;
    }

    while (newNum >= 0) {
        temp = a;
        a = a + b;
        b = temp;
        newNum = newNum - 1;
    }
    
    document.getElementById("output").innerHTML=b;
}

// 2. Bubble Sort
function bubbleSort(array) {
    var newArr = array.split(', ');
    var newArr2 = newArr.map(Number);

    var swapped;
    do {
        swapped = false;
        for (var i=0; i < newArr2.length-1; i++) {
            if (newArr2[i] > newArr2[i+1]) {
                var temp = newArr2[i];
                newArr2[i] = newArr2[i+1];
                newArr2[i+1] = temp;
                swapped = true;
            }
        }
    }
    while (swapped);
    document.getElementById("output").innerHTML=newArr2;
    return;
}

// 3. Reverse String
function reverseStr(someStr) {
    let newString = "";

    for (let i = someStr.length - 1 ; i >= 0 ; i-- ){
        newString += someStr[i];
    }
    
    document.getElementById("output").innerHTML=newString;
    return;
}

// 4. Factorial
function factorial(someNum) {
    let newNum = Number(someNum);
    let numOne = "1";
    let result = 1;

    if (newNum === 0 || newNum === 1) {
        document.getElementById("output").innerHTML=numOne;
        return 0;
    }

    while (newNum > 0) {
        console.log(newNum);
        result *= newNum;
        newNum--;
    }
    document.getElementById("output").innerHTML=result;
}

// 6. Even Number
function isEven(someNum) {
    let newNum = Number(someNum);

    if (newNum < 0) {
        document.getElementById("output").innerHTML="Please enter a non-negative number.";
        return 0;
    }

    while (newNum > 1) {
        console.log(newNum);
        newNum = newNum - 2;
        console.log("After " + newNum);
    }

    console.log("End result: " + newNum);

    if (newNum == 1) {
        document.getElementById("output").innerHTML=someNum + " is odd.";
        return;
    }
    else if (newNum == 0) {
        document.getElementById("output").innerHTML=someNum + " is even."
        return;
    }
}

// 7. Palindrome
function isPalindrome(someStr) {
    var re = /[^A-Za-z0-9]/g;
    someStr = someStr.toLowerCase().replace(re, '');
    var len = someStr.length;
    for (var i = 0; i < len/2; i++) {
        if (someStr[i] !== someStr[len - 1 - i]) {
            document.getElementById("output").innerHTML="Not a palindrome.";
            return;
        }
    }
    document.getElementById("output").innerHTML="Is a palindrome.";
    return;
}

// 10. Delete Element
function deleteElement(someArr) {
    var newArr = someArr.split(', ');

    console.log(newArr.length);
    console.log(newArr);

    if (newArr.length < 3) {
        document.getElementById("output").innerHTML="The string entered is not long enough!";
        return;
    }

    delete newArr[2];

    console.log(newArr.length)
    console.log(newArr);
}

//11. Splice Element
function spliceElement(someArr) {
    var newArr = someArr.split(', ');

    console.log(newArr.length);
    console.log(newArr);

    if (newArr.length < 3) {
        document.getElementById("output").innerHTML="The string entered is not long enough!";
        return;
    }

    newArr.splice(2,1);

    console.log(newArr.length);
    console.log(newArr);
}

