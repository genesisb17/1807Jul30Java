/**
 * @author Zachary Ritchei
 * @name Core-JS-Concepts
 * @since 8-14-18
 */

 /**
  * Javascript is a scripting language for client sie opperations
  * thought there are framework that enable server-side JS)
  * - loosely typed -- variable are dynamically allocated
  * - declare variables with var, let, const
  * - supports prototypal inheritance
  * - important related concepts: var types, scopes, type coercion
  * hoisting semicolon injection, anonymous functions, 
  * template literals, callbacks functions, IIFE, arrow notation
  */

  function truthyfalsy(cond){
    if (cond){
    console.log(
        "condition is truthy"
    );}
    else{console.log("condition is falsy");}
}

/**
 * 
 * Falsy - 0, Null, null, undefined, '', false
 * Truthy - everything else
 * 
 * when compairing variables/literals we can use == or === operators 
 * == use type coercion
 * === prevents
 */

 // objects

 var obj = {
     name: "zack",
     age: 70,
     sayHI: function() {
         console.log(this.name + ' says hi!')
     }
 }

 //how to access object properties:
 obj.name
 obj["name"]

 //delete properties
 delete obj.name

 