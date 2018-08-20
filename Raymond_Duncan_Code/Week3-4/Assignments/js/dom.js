// Javascript Homework
// Due Monday 8/20 -- to be pushed by 5PM in your branch

// -----------------------------------------------------------------------------------
// Create an HTML file that takes in input and carries out at least 8
// of the following functions and manipulates the DOM to show the outcome.
// (Can include #1, though we've completed it together in class)
// Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------
window.onload = function(){
    $("#menu-toggle").on("click", function(e){
        e.preventDefault();
        $("#something").toggleClass("toggled");
    });
    

}


// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
fib  = function(n) {
    let seq = [1];
    let func = function(a,b,i){
        if(i <= 1) return b;
        return [b].concat(func(b,a+b,i-1));
    }
    return seq.concat(func(1,1,n-1));
}
testFibonacci = function(){
    for(let i = 0; i < 10; i++){
        console.log(`Fib ${i} returns\n${fib(i)}`)
    }
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
bubbleSort = function(numArray){
    let sortedArray = numArray;
    let sorted = false;
    while(!sorted){
        sorted = true;
        for(let i = 0; i < sortedArray.length-1; i++){
            if(sortedArray[i] > sortedArray[i+1]){
                sorted = false;
                for(let j = 0; j < sortedArray.length-1; j++){
                    if(sortedArray[j] > sortedArray[j+1]){
                        let k = sortedArray[j];
                        sortedArray[j] = sortedArray[j+1];
                        sortedArray[j+1] = k;
                    }
                }
            }
        }
    }
    return sortedArray;
}
testBubbleSort = function(){
    arr = [4,1,7,9,7,4,2,3];
    console.log(`Array:\t${arr}\nSorted:\t${bubbleSort(arr)}`);
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
reverseStr = function(str){
    let reversedStr = "";
    for(let i = str.length-1; i >= 0; i--){
        reversedStr = reversedStr.concat(str[i]);
    }
    return reversedStr;
}
testReverseStr = function(){
    console.log(`"Shout out" reversed is: ${reverseStr("Shout out")}`);
    console.log(`"Wasp" reversed is: ${reverseStr("Wasp")}`);
    console.log(`"We run this" reversed is: ${reverseStr("We run this")}`);
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
factorial = function(n) {
    if(n < 1) return 1;
    else return n * factorial(n-1);
}
testFactorial = function(){
    for(let i = 0; i < 10; i++){
        console.log(`Factorial of ${i} = ${factorial(i)}`)
    }
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
substring = function(str,len,offset){
    if(typeof(len) !== "number" || typeof(offset) !== "number") alert("Len and Offset must be numbers");
    else if(len < 1 || offset < 0) alert("Len and Offset must be positive");
    else if(len + offset > str.length) alert("Len and Offset exceed the length of Str");
    else{
        let substr = "";
        for(let i = offset; i < len+offset; i++){
            substr += str[i].toString();
        }
        return substr;
    }
}
testSubstring = function() {
    let str = "This is the string";     //length = 18
    console.log(substring(str,5,10))    //success
    console.log(substring(str,3,10))    //success 
    console.log(substring(str,-1,10))   //should be positive
    console.log(substring(str,5,-10))   //Should be positive
    console.log(substring(str,17,10))   //too long
    console.log(substring(str,5,17))    //too long
    console.log(substring(str,"sp",10)) //must be number
    console.log(substring(str,5,"list"))//must be number
    console.log(substring(str,10,0))    //success 
    console.log(substring(str,18,0))    //full string
}


// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
isEven = function(n){
    if((n/2).toString().split(".").length > 1 || n/n !== 1) return false;
    return true;
}
testIsEven = function(){
    for(let i = 0; i < 11; i++){
        console.log(`${i} is even: ${isEven(i)}`);
    }
    console.log(`"This" is even: ${isEven("This")}`);
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
isPalindrome = function(str){
    if(str.toLowerCase() == reverseStr(str.toLowerCase())) return true;
    return false;
}

testIsPalindrome = function(str){
    console.log(`"This" is a palindrome: ${isPalindrome("This")}`);
    console.log(`"Something" is a palindrome: ${isPalindrome("Something")}`);
    console.log(`"Sarah" is a palindrome: ${isPalindrome("Sarah")}`);
    console.log(`"tacocat" is a palindrome: ${isPalindrome("tacocat")}`);
    console.log(`"Hannah" is a palindrome: ${isPalindrome("Hannah")}`);
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
printShape = function(shape,height,character){
    output = ""
    switch(shape.toLowerCase()){
        case "square": 
            for(let i = 0; i < height; i++){
                let row = character.repeat(height)
                console.log(row);
                output = output.concat(`${row}\n`);
            }
            break;
        case "triangle":
            for(let i = 1; i <= height; i++){
                let row = character.repeat(i);
                console.log(row);
                output = output.concat(`${row}\n`);
            }
            break;
        case "diamond":
            let spaces = (height-1)/2;
            for(let i = 0; i < height; i++){
                let row = `${" ".repeat(spaces)}${character.repeat(height-2*spaces)}${" ".repeat(spaces)}`
                console.log(row);
                output = output.concat(`${row}\n`);
                if(i+1 < height/2) spaces--;
                else spaces++;
            }
    }
    return output;
}
testPrintShape = function(){
    for(let i = 3; i < 8; i+=2){
        printShape("Square",i,"*");
        printShape("Triangle",i,"+");
        printShape("Diamond",i,"%");
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
traverseObject = function(obj){
    for(i in obj){
        console.log(`${i} : ${obj[i]}`);
    }
}
testTraverseObject = function(){
    obj = {
        a : 1,
        b : "b",
        c : [1,2,3],
        d : {}
    }
    console.log(obj.length);
    console.log(obj);
    console.log(traverseObject(obj));

}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
deleteElement = function(arr,i){
    arr[i] = undefined;
    return arr;
}
testDeleteElement = function(){
    arr = [15,3,5,6,7,76,4,3];
    console.log(arr);
    console.log(arr.length);
    deleteElement(arr,2);
    console.log(arr.length);
    console.log(arr);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
spliceElement = function(arr,e){
    let spliced = [];
    for(let i = 0; i < arr.length; i++){
        if(i != e){
            console.log("Not skipping");
            spliced = spliced.concat(arr[i]);
        } else console.log("Skipping")
    }
    return spliced;
}
testSpliceElement = function() {
    var arr = [15,3,5,6,7,76,4,3];
    console.log(arr);
    arr = spliceElement(arr,2);
    console.log(arr);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
 
// 14. Display the current time on the top right of your HTML page, 
// updating every second

// 15.  Descending order
// Your task is to make a function that can take any non-negative 
// integer as a argument and return it with its digits in descending 
// order. Essentially, rearrange the digits to create the highest possible number.

var funcs = [testSpliceElement,testDeleteElement,testTraverseObject,testPrintShape,testIsPalindrome,testIsEven,testSubstring,testFactorial,testReverseStr,testFibonacci,testBubbleSort];
$("#funcTest").on("click",function(){
    console.log("click");
    var selector = document.getElementById("funcPicker");
    // var funcToTest = selector.options[selector.selectedIndex].value;
    funcs[selector.selectedIndex]();
});




