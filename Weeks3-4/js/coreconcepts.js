/**
 * @author Genesis Bonds
 * @name Core-JS-Concepts
 * @since 8/14/18
 */

/*
JavaScript is a scripting language for client-side operations (
    though there are frameworks that enable server-side JS)
   - loosely typed-- variable types are dynamically allocated
   - declare variables with var, let, const
        -- variable scopes : global, function, block
        - global: declared any function or block OR variables initialized without declaration. accessible from browser
        - function: declared inside of a function
        - block: declared inside of a block. ONLY accessible via declaration with let or const
   - supports prototypal inheritance
   - some keywords in JS that we're familiar with - break, continue, 
     	do...while, for, if...else, return, switch, try...catch
  		There is also debugger - stops the execution of JS, and 
  		calls (if available) the debugging function
   - Load-and-Go delivery
   - important related concepts: var types, scopes, type coercion,
        hoisting, semicolon injection, anonymous functions, 
        template literals, callback functions, IIFE, arrow notation... 
*/

var a = 5;
var b = "hello"
var c = 'hello';
var d = 7/0
var e = {
    firstName: "genesis", 
    lastName: "bonds",
    age:30,
    getFullName: function(){
        return `${this.firstName} ${this.lastName}`;
    }};
e["age"] = 20;
e["about me"] = "I like food"; //can have obj properties with spaces. must use obj["prop"] not obj.prop syntax
var f = e.age;
var g = [0 , 2, 4, 6, 8];
var h = null;
var i;
var j = 1, k = 'hey', l = null; //can declare and initialize multiple variables at once. maintains scope
var b; //if you redeclare a JS variable, it will not lose its value
console.log(typeof(a)); //returns the type of variable or expression
var interpol = `Hi ${e.name}`;



function truthyFalsy(cond) { // if true
    if (cond) {
        console.log( // same as sysout; just browser console
            "condition is truthy");
    }
    else { console.log("condition is falsy"); }
}
/* -- TYPE COERCION
As a loosely typed programming language that is interpreted
and not compiled, JS has to accomodate functions that
operate on variables of different types. 
JS uses type coercion in order to do so 

Falsy - 0, NaN, null, undefined, '', false
Truthy - everything else 

When comparing variables/literals we can use == or === operators 
== uses type coercion 
=== prevents 

*/


/* Strings 
- 0 or more 16-bit characters
- " OR ', but cannot do things like 'hello" -> 'hello' or "hello"
- == similar strings are equal
- string.length
- charAt, concat, indexOf, replace, split, slice, substring, etc
- search -- regex
- immutable
*/

var str = 'hi';
x = str.indexOf('i');





//----------------------------------------------------OBJECTS---------------------------------------------------

var obj = {
    name: 'Genesis',
    age: 70,
    saysHi: function () {
        console.log(this.name + ' says hi!');
    }
}

//how to access object properties:
obj.name
obj["name"]

//delete properties:
delete obj.name



//------------------------------------------------LOOPS-----------------------------------------------------

//The for...in statement iterates over all non-Symbol, enumerable properties of an object.
for (var prop in obj) { console.log(prop) } //print out all properties of obj
for (var prop in obj) { console.log(obj[prop]) } //print out value of each property of obj