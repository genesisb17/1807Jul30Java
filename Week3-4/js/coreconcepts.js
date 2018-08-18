/**
 * @author Sammy Eang
 * @name Core-JS-Concepts
 * @since 8/14/18
 */

 /*
 Javascript is a scripting language for client sude operations (though
    there are frameworks that enable server side JS)
    - loosely typed -- variable types are dynamically allocated
    - declare variables with var, let, const
    - supports prototypal inheritance
    - important related concepts: var types, scopes, type coercion, callback functions, hoisting
        semicolon injection, anonymous functions, template literals, IIFE,  arrow notation...
*/

   function truthyFalsy(cond) {//if true console.log, same as sysout
        if(cond) {
            console.log("condition is truthy");
        } else {
            console.log("condition is falsy");
        }
    }

/* -- Type Coercion
    As a loosely typed programming language that is interpreted and not compiled,
    JS has to accomodate functions that operate on variable of diff types. JS
    uses type coercion in order to do so
    Falsy - 0, NaN, null, undefined, '', false
    Truthy - everything else

    When compairing variables or literals, we can use == or === operators
    == uses type coercion
    === prevents
*/

var obj = {
    name: 'Hungry',
    age: 110,
    sayHello: function() {
        console.log(name+'says hi!');
    }
}

//how to access obj properties
obj.name
obj["name"]

//delete properties
delete obj.name

for(var prop in obj) {
    console.log(obj.prop);
}

/* Operators
    Guard and default - in one note
*/

//guard
var currentSession = null;
var userInfo = {username: "seang", password: 123};

var getUser = currentSession && userInfo;

//default
var earlyLeave = 1;
var regularLeave = 530;
var timeOut = earlyLeave || regularLeave;