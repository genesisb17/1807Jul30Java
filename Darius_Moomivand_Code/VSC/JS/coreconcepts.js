/*
* Darius M $ 14Aug2018
* Core Concepts
*/

/*
JavaScript is a scripting language for client side operations ( though there are frameworks that enable server-side JS
- loosely typed -- variable types are dynamically allocated 
-declare variables with var, let, const
- supports prototypal inheritance
-important related concepts: var types, scopes, type coercion, hoisting, semicolon injection, anonymous functions, 
    template literals, callback functions, IIFE, arrow notation...)
*/

function truthyFalsy(cond){
    if(cond){console.log(
        "condition is truthy");} 
    
    else{ console.log("condition is falsy");}}

/* -- Type Corecion
As a loosely typed programming lang that is interpreted and not compiled, JS has to accomodate funcions that operate on variables of different types.
JS uses type corercion in order to do so 
Falsy - 0, NaN, null, undefined, '', false
        def: anything that defines to a false.
Truthy - everything else

When comparing variables/literals we can use the == or === operators
== forces type coercion, === prevents it.3


Object


*/

var obj = {
    name: 'Darius', 
    age: 55,
    saysHi: function(){
        console.log(this.name + ' says hi!');
    }
    
}



//how to access object properties
obj.name
obj["name"]

//delete properties
delete obj.name

// This is a guard. First operator acts as a "guard" for the function. Must be true to see second operand.
function guard(op1, op2){
    return op1 && op
;}

// This function put emphasis on the first operand. If first one is falsey, then returns second. If truthy, returns first operand.
function defaultOp(op1, op2) { return op1 || op2; }


var currentSesion =null;
var userInfo = { username: "goods", password: 123};
var getuser = currSession && userInfo;