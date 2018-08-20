window.onload = function(){
    $('#reverseB').on('click', reverseStringSetup);
    $('#fact').on('click', factorialSetup);
    $('#part').on('click', subStringSetup);
    $('#palCheck').on('click', palindromeSetup);
    $('#spliceEl').on('click', spliceElSetup);
    $('#deleteEl').on('click', deleteElSetup);
    $('#storyTime').on('click', storySetup);
    $('#storyTime2').on('click', story2Setup);
}
/*------------------------------------------------------------------------------------------*/
                    /* 13. Creating an object using object literals*/
                    
function story2Setup(){
    let person = {
        iname: $('#iname').val(), //initiated values of input to name and age from previous answer
        iage: $('#iage').val()
    }

    story2(person);
}

function story2(object){
    console.log(object.iage);
    newage = 3 + parseInt(object.iage, 10);
    text = "Three years later you are " + newage + " and you've fought countless" +
    "\nof monsters and enemies." + " You truly are amazing, " + object.iname + "." + 
    "\nI can't wait to see what's in store for you next..";
    document.getElementById("storypt2").innerHTML = text;
}
/*------------------------------------------------------------------------------------------*/
                     /* 12. Creating an object using constructors*/

function storySetup(){
    let iname = $('#iname').val(); 
    let iage = $('#iage').val();
    let storySet = new story(iname, iage);
    
}

function story(name, age){
    this.storyName = name;
    this.storyAge = age;
    text = "So your name is: " + this.storyName + "..."
    + "\nYes, this is where your story begins.\n" +
    "Welcome to Ossyria, your current age is " + this.storyAge
    + " and you are going to embark on a journey so perilous."
    + "\nI wish you the best of luck, " + this.storyName + ".";
    document.getElementById("story").innerHTML = text;
}
/*------------------------------------------------------------------------------------------*/
                          /* 11. Splicing the third element*/

function spliceElSetup(){
    let orrArr = $('#elementS').val(); //set original array
    $('#printLen').val(orrArr.length); 
    spliceEl(orrArr);
}

function spliceEl(someArr){
    let splitArr = someArr.split(" "); //split function to split an array [, , , , ,]
    splitArr[2] = splitArr[3];
    for(let i = 3; i < someArr.length-1; i++){ //replaces the 3rd element with the next element
                                            //continues looping until end of array
        splitArr[i] = splitArr[i+1];
}

    console.log(splitArr.join(" "));     //joins back into object
    $('#splicedEl').removeAttr('hidden'); 
    $('#splicedEl').val(splitArr.join(" ")); 
    $('#newLen').removeAttr('hidden');
    console.log(splitArr.length);
    $('#newLen').val(splitArr.length);

}

/*------------------------------------------------------------------------------------------*/
                        /* 10. Deleting the third element*/

function deleteElSetup(){
    let arrayToDel = $('#deleteS').val(); //initiate object to delete
    $('#printDeLen').val(arrayToDel.length);
    deleteEl(arrayToDel);
}

function deleteEl(someArr){
    let splitArr = someArr.split(" ");  //splits into array [, , , ,]
    let splitThird = splitArr[2].split("");  //splits the third element even further [, , ,]
    for(let i = 0; i < splitThird.length; i++){ //replaces all values in third element with " "
        splitThird[i] = " ";
    }
    let splitThirdJoin = splitThird.join(""); //joins back into and object
    splitArr[2] = splitThirdJoin; //replaces 3rd element
    let connect = splitArr.join(" "); //joins back into object
    $('#deleteEle').removeAttr('hidden');
    $('#deleteEle').val(connect);
    $('#newDeLen').removeAttr('hidden');
    $('#newDeLen').val(connect.length);
}

/*------------------------------------------------------------------------------------------*/
                             /* 7. Check for Palindrome*/

function palindromeSetup(){
    let word = $('#palindrome').val();
    palindromeCheck(word);
}

function palindromeCheck(someStr){
    let splitSt = someStr.split("");
    let reverseSt = splitSt.reverse();
    let joinSt = reverseSt.join("");
    if(joinSt == someStr){
        $('#palVal').removeAttr('hidden');
        $('#palVal').val("Sir, I am quite sure this is a palindrome.");
    }else{
        $('#palVal').removeAttr('hidden');
        $('#palVal').val("Well I'll be... It's not.");
    }
}
/*------------------------------------------------------------------------------------------*/
                             /* 5. Substring method*/

function subStringSetup(){
    let offset = $("#offset").val();
    let length = $("#length").val();
    let range = (parseInt(offset) + parseInt(length)); //had to parse object into an int
    let offsetInt = parseInt(offset);
    subString(offsetInt, range);
}

function subString(a, b){
    let phrase = $("#parting").val();             
    $("#parting").val(phrase.substring(a, b)); //used substring method to substring values from a to b
}
/*------------------------------------------------------------------------------------------*/
                             /* 4. Factorial of a number*/

function factorialSetup(){
    let b = $('#factorial').val(); //assigned initial value
    let c = parseInt(b, 10); //parsed the initial v alue into an int
    let d = factorial(c); //assigns variable to function and returns value
    $('#factorial').val(d); //shows calculated facotiral
}

function factorial(a){
    
    if(a == 0) {
        return 1;
    }
    else {
        return a*factorial(a-1); 
    }
}

/*------------------------------------------------------------------------------------------*/
                             /* 3. Reverseing a string*/

function reverseStringSetup(){
    let someStr = $('#reverse').val();
    reverseString(someStr);
}

function reverseString(someStr){
    let splitSt = someStr.split("");
    let reverseSt = splitSt.reverse();
    let joinSt = reverseSt.join("");
    $('#reverse').val(joinSt);
}
                            