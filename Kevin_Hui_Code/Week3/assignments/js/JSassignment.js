window.onload = function() {
    document.getElementById("fibsubmit").addEventListener("click", function() {
        let passIn = document.getElementById("fibinput").value;
        document.getElementById("fiboutput").innerHTML = "Fibonacci term at position " + passIn + " is " + fib(passIn) + ".";
    }, true);
}

// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib(n) {
    if (n == 0 | n == 1) {
        return n;
    }
    return fib(n - 1) + fib(n - 2);
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

function bubbleSort(numArray) {
    for (let i = numArray.length - 1; i >= 0; i--) {
        for (let k = 0; k < i; k++) {
            if (numArray[k] > numArray[k + 1]) {
                let temp = numArray[k];
                numArray[k] = numArray[k + 1];
                numArray[k + 1] = temp;
            }
        }
        
    }
    return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseStr(someStr) {
    let resultString = "";
    for (let i = someStr.length - 1; i >= 0; i--) {
        resultString += someStr[i];
    }
    return resultString;
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function factorial(someNum) {
    return (someNum == 0) ? 1 : someNum * factorial(someNum - 1);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset) {
    if (offset < 0 || length < 0 || someStr.length < offset + length) {
        alert("Offset and/or length exceed string length.");
        return;
    }
    let resultString = "";
    for (let i = offset; i < offset + length; i++) {
        resultString += someStr[i];
    }
    return resultString;
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

function isEven(someNum) {
    return (someNum & 1) ? false : true;
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
    for (let i = 0; i < someStr.length / 2; i++) {
        if (someStr[i] != someStr[someStr.length - i - 1]) {
            return false;
        }
    }
    return true;
}

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *

function printShape(shape, height, character) {
    if(isEven(height) | (character.length != 1)) {
        alert("Bad input(s): Height must be odd and one character.");
        return;
    }
    let printedShape = "";
    switch (shape) {
        case "Square":
            for (let i = 0; i < height; i++) {
                for (let k = 0; k < height; k++) {
                    printedShape += character;
                }
                printedShape += "\n";
            }
            break;
        case "Triangle":
            for (let i = 0; i < height; i++) {
                for (let k = 0; k <= i; k++) {
                    printedShape += character;
                }
                printedShape += "\n";
            }
            break;
        case "Diamond": //WORK IN PROGRESS
            for (let i = 0; i < height; i++) {
                for (let k = 0; k <= i; k++) {
                    printedShape += character;
                }
                printedShape += "\n";
            }
            break;
        default:
            console.log("No such shape.")
            return;
    }

    console.log(printedShape);
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject(someObj) {
    for (let prop in someObj) {
        console.log(prop + ": " + someObj[prop]);
    }
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

function Person(name, age) {
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);

function getPerson(name, age) {
    return {name: name, age: age}
}
 
// 14. Display the current time on the top right of your HTML page, 
// updating every second

// 15.  Descending order
// Your task is to make a function that can take any non-negative 
// integer as a argument and return it with its digits in descending 
// order. Essentially, rearrange the digits to create the highest possible number.