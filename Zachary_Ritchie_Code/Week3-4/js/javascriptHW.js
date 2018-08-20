window.onload = function(){
    
    document.getElementById("q1compute").addEventListener("click", calcFib, true);
    document.getElementById("q2compute").addEventListener("click", bubblesort, true);
    document.getElementById("q3compute").addEventListener("click", reverseString, true);
    document.getElementById("q4compute").addEventListener("click", factorial, true);
    document.getElementById("q5compute").addEventListener("click", evenNumber, true);
    document.getElementById("q6compute").addEventListener("click", palindrome, true);
    document.getElementById("q15compute").addEventListener("click", descendingOrder, true);
    clock();
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
var john = person("John", 30);

var getPerson = {
    firstname: "John",
    age: "30"
}
var john = getPerson;

function clock()
{
    var d = new Date();
    var n = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    var t = setTimeout(clock, 500);
    document.getElementById("q14").innerHTML = n;    
}

function splice()
{
    let input = document.getElementById("input2").value;    
    let output =  JSON.parse("[" + input + "]");
    output.splice(2, 1, null);
    console.log(output.length);
    document.getElementById("q2").innerHTML = output.length;   

}

function bubblesort()
{
    let input = document.getElementById("input2").value;
    let array = Array.from(input);
    let length = input.length;
    for(let i = 0; i < length; i++)
    {
        for(let j = 0; j < (length - i - 1); j++)
        {
            if(array[j] > array[j+1])
            {
                var tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;                
            }
        }
    }
    document.getElementById("q2").innerHTML = array;   

}

function descendingOrder()
{
    let input = document.getElementById("input15").value;
    let array = Array.from(input);
    let length = input.length;
    for(let i = 0; i < length; i++)
    {
        for(let j = 0; j < (length - i - 1); j++)
        {
            if(array[j] > array[j+1])
            {
                var tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;                
            }
        }
    }
    let reversed = "";
    for (var i = array.length - 1; i >= 0; i--)
    {        
        reversed += array[i];
    }    
    
    document.getElementById("q15").innerHTML = reversed;  
}