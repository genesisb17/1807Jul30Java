/**
 * @author Raymond
 * @name Core-JS-Concepts
 * @since 8/14/18
 */

/* JavaScript is a scripting language for client side operations
(though there are frameworks that enable server-side js)
It is:
    - Loosely typed - variable types are dynamically allocated
    - Declare variables with var, let, and const
    - Supports prototypal inheritance
    - Important related concepts: var types, scopes, type coercion, hoisting, semicolon injection,
        anonymous functions, template literals, callback functions, IIFE, arrow notation...
*/


function truthyFalsey(cond){
    if(cond) {
        console.log("condition is truthy");
    } else {
        console.log("condition is falsey");
    }
}
/* -- TYPE COERCION --
As a loosely typed programming language that is interpreted and not compiled, JS has to accomodate functions that operate on variables
of different types. JS uses type coercion in order to do so
Falsy - 0, NaN, null, undefined, '', false

When comparing variables/literals we can use == or === operators
== uses type coercion
=== prevents type coercion
*/

var obj = {
    name: 'Raymond',
    age: 777,
    saysHi: function(){
        console.log(name + 'says hi!');
    }
}

//How to access object properties:
obj.name
obj[name]

//delete properties;
delete obj.name;

obj.other = true;
obj.bio = "This is really cool JS stuff";

//Template literals - another way to enter variables into a string
var temp = `${obj.name} is the object name`




// DAY TWO!
function scopes(){
    var functionVar = "This is declared using var in a function";
    let functionLet = "This is declared using let in a function";
    const functionConst = "declarfed using const in a function";
    if(cond){   //Here to show that we are declaring vars in a block
        var blockV = "block var";
        let blockL = "block let";
        const blockC = "block const";
        console.log(`IN IF BLOCK --- var ${blockV}, let ${blockL}, const ${blockC}`)
        // blockC = 5;  CANNOT REASSIGN VARIABLES ASSIGNED WITH CONST
        console.log(`changed value of blockC = ${blockC}`)

    }

    console.log(functionVar);
    console.log(functionLet);
    console.log(functionConst)
    console.log(blockV);
    // console.log(blockL); 
    // console.log(blockC); Block and let can either be global, function, or block scoped
    //Var can only be global or function scoped!
    var functionVar;
    console.log(functionVar);
    noDeclaration = "this variable was never declared, but is used in a function...What scope is it?"
    console.log(noDeclaration);
    

}
