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

    }
}

// 3. Reverse String
function reverseStr(someStr) {
    let newString = "";

    for (let i = someStr.length - 1 ; i >= 0 ; i-- ){
        newString += someStr[i];
    }
    
    document.getElementById("output").innerHTML=newString;
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
