window.onload = function(){
    
    document.getElementById("q1compute").addEventListener("click", calcFib, true);
    document.getElementById("q3compute").addEventListener("click", reverseString, true);
    document.getElementById("q4compute").addEventListener("click", factorial, true);
    document.getElementById("q5compute").addEventListener("click", evenNumber, true);
    document.getElementById("q6compute").addEventListener("click", palindrome, true);

}

function calcFib()
{
    let x = 1;
    let y = 1;
    let z = 0;
    let input = document.getElementById("input1").value;

    if (input == 1)
    {
        
    }
    else if((input == 2) || (input == 3))
    {
        z = 1;
    }
    else
    {
        for (let i = 1; i < Math.abs(input - 2); ++i)
        {
            z = x + y;
            y=x;
            x=z;
        }
    }   
    
    document.getElementById("q1").innerHTML = z;
}

function reverseString()
{
    let input = document.getElementById("input3").value;
    
    let newString = "";
    for (let i = input.length - 1; i >= 0; i--) 
    {
        newString += input[i];
    }

    document.getElementById("q3").innerHTML = newString;
}

function factorial()
{
    let input = document.getElementById("input4").value;
    let newNumber = 1;
    for(let i = 0; i <= input - 1; ++i)
    {
        newNumber = newNumber * (input - i); 
    }
    document.getElementById("q4").innerHTML = newNumber;
}

function evenNumber()
{
    let input = document.getElementById("input5").value;
	let isEven = false;
    if((input & 1) == 0)
    {
        isEven = true;
    }
    else
    {
        isEven = false;
    }

    document.getElementById("q5").innerHTML = isEven;
}

function palindrome()
{
    let input = document.getElementById("input6").value;
    let isPalindrome = false;
    let newString = "";
    for (let i = input.length - 1; i >= 0; i--) 
    {
        newString += input[i];
    }

    if(newString == input)
    {
        isPalindrome = true;
    }
    document.getElementById("q6").innerHTML = isPalindrome;
}



function person(name, age)
{
    this.firstName = name;
    this.age = age;
}
var john = getPerson("John", 30);

var getPerson ={
    setName: function(name){
        this.name = name;
    },
    setAge: function(age){
        this.age = age;
    }
}
var john = getPerson("John", 30);