/* 1. Fibonacci 
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence. */

    $("#calcFib").on('click', function(){
        var num = $("#fibNum").val()-1;
        let myFibNum = fib(num);
        if (num < 0) {
            $("#showFib").html("You must enter a positive number");
        } else{
            let res;
            if (((num+1)%10 == 1) && (num+1 != 11)) {
                res = `The ${num+1}st Fibonacci number is ${myFibNum}`;
            } else if (((num+1)%10 == 2) && (num+1 != 12)) {
                res = `The ${num+1}nd Fibonacci number is ${myFibNum}`;
            } else if (((num+1)%10 == 3) && (num+1 != 13)) {
                res = `The ${num+1}rd Fibonacci number is ${myFibNum}`;
            }
            else if (num+1 > 3) {
                res = `The ${num+1}th Fibonacci number is ${myFibNum}`;
            }
            $("#showFib").html(res);
            $("#fibNum").val('');
        }
    });
    function fib(n) {
        if (n <= 1) { return n; }
        else { return (fib(n-1) + fib(n-2)); }
    };


/* 2. Bubble Sort
    Define function: bubbleSort(numArray)
    Use the bubble sort algorithm to sort the array.
    Return the sorted array. */
    $("#calcBubbleSort").on('click', function(){
        var arr = $("#inputArr").val().split(",");
        console.log(arr);
        let tmp = [arr.length];
        for (let i=0; i<arr.length; i++) {
            tmp[i] = arr[i];
        }
        console.log(tmp);
        let sortedArr = bubbleSort(arr);
        console.log(sortedArr);
        let res =  `The sorted result of ${tmp} is ${sortedArr}`;
        $("#showArr").html(res);
        $("inputArr").val('');
    });
    function bubbleSort(numArray) {
        for (let i=0; i<numArray.length; i++) {
            for (let j=1; j<numArray.length; j++) {
                if (numArray[j-1] > numArray[j]) {
                    swap(numArray, j-1, j);
                }
            }
        } return numArray;
    }
    function swap(arr, i, j) {
        var tmp = arr[i];;
        arr[i] = arr[j];
        arr[j] = tmp;
    }


/* 3. Reverse String
    Define function: reverseStr(someStr)
    Reverse and return the String. */
    $("#calcReverse").on('click', function(){
        var str = $("#str").val();
        let myStr = reverseString(str);
        let res =  `The reverse of "${str}" is "${myStr}"`;
        $("#showReverse").html(res);
        $("str").val('');
    });
    function reverseString(str) {
        var newStr = "";
        for (i=str.length-1; i>=0; i--) {
            newStr += str[i];
        } return newStr;
    }


/* 4. Factorial
    Define function: factorial(someNum)
    Use recursion to compute and return the factorial of someNum. */
    $("#calcFact").on('click', function(){
        var num = $("#fact").val();
        let myFact = fact(num);
        let res = `The value of ${num}! is ${myFact}`;
        $("#showFact").html(res);
        $("#fact").val('');
    });
    function fact(n) {
        if (n<=1) { return 1; }
        else { return n*fact(n-1); }
    }


/* 5. Substring
    Define function substring(someStr, length, offset)
    Return the substring contained between offset and (offset + length) inclusively.
    If incorrect input is entered, use the alert function and describe why the input was incorrect. */


/* 6. Even Number
    Define function: isEven(someNum)
    Return true if even, false if odd.
    Do not use % operator. */
    $("#calcIsEven").on('click', function(){
        var num = $("#isEvenNum").val();
        let isNumEven = isEven(num);
        let res = `The number ${num} is ${isNumEven}`;
        $("#showIsEven").html(res);
        $("#isEvenNum").val('');
    });
    function isEven(n) {
        if (((n/2) - Math.floor(n/2)) == 0) {
            return "even";
        } else { return "odd"; };
    }


/* 7. Palindrome
    Define function isPalindrome(someStr)
    Return true if someStr is a palindrome, otherwise return false */
    $("#calcPalindrome").on('click', function(){
        var str = $("#inputText").val();
        console.log(str);
        let isStrPalindrome = isPalindrome(str);
        console.log(isStrPalindrome);
        let res = `The word "${str}" is ${isStrPalindrome} a palindrome`;
        $("#showPalindrome").html(res);
        $("#inputText").val('');
    });
    function isPalindrome(str) {
        let backwards = reverseString(str);
        if (str.toLowerCase() == backwards.toLowerCase()) {
            return "";
        } else { return "not"; }
    }


/* 8. Shapes
    Define function: printShape(shape, height, character)
    shape is a String and is either "Square", "Triangle", "Diamond".
    height is a Number and is the height of the shape. Assume the number is odd.
    character is a String that represents the contents of the shape. Assume this String contains just one character.
    Use a switch statement to determine which shape was passed in.
    Use the console.log function to print the desired shape.
    Example for printShape("Square", 3, "%");
    %%%
    %%%
    %%%
    Example for printShape("Triangle", 3, "$");
    $
    $$
    $$$
    Example for printShape("Diamond", 5, "*");
    *
    ***
    *****
     ***
     * */

     
/* 9. Object literal
    Define function traverseObject(someObj)
    Print every property and it's value. */


/* 10. Delete Element
    Define function deleteElement(someArr)
    Print length
    Delete the third element in the array.
    Print length
    The lengths should be the same. */


/* 11. Splice Element
    Define function spliceElement(someArr)
    Print length
    Splice the third element in the array.
    Print length
    The lengths should be one less than the original length. */


/* 12. Defining an object using a constructor
    Define a function Person(name, age)
    The following line should set a Person object to the variable john:
        var john = new Person("John", 30); */


/* 13. Defining an object using an object literal
    Define function getPerson(name, age)
    The following line should set a Person object to the variable john:
        var john = getPerson("John", 30); */
        

/* 14. Display the current time on the top right of your HTML page, 
    updating every second */


/* 15.  Descending order
    Your task is to make a function that can take any non-negative 
    integer as a argument and return it with its digits in descending 
    order. Essentially, rearrange the digits to create the highest possible number. */
    $("#calcDescendingOrder").on('click', function(){
        var num = $("#inputNum").val();
        let sortedNum = descendingNum(num);
        let res = `The number ${num} with its digits sorted in descending order is ${sortedNum}`;
        $("#showDescending").html(res);
        $("#sortedNum").val('');
    });
    function descendingNum(number) {
        var numDigits = number.toString().length;
        var arr = number.toString().split("");
        return sortedArr = bubbleSortDescending(arr);
    }
    function bubbleSortDescending(numArray) {
        for (let i=0; i<numArray.length; i++) {
            for (let j=1; j<numArray.length; j++) {
                if (numArray[j-1] < numArray[j]) {
                    swap(numArray, j-1, j);
                }
            }
        } return numArray;
    }