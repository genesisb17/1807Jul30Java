/**
 * @author Molly Merritt
 * @name Core-JS-Concepts
 * @since 8/14/18
 */

 /*
    JavaScript is a scripting language for client-side operations (though there are frameworks
    that enable server-side JS)
        - loosely typed - variable types are dynamically allocated
        - declare variables with var, let, const
        - supports prototypal inheritance
        - important related concepts: variable types, scopes, type coercion, noisting, semicolon injection,
          anonymous functions, template literals, callback functions, IIFE, arrow notation, ...
  */

  function truthyFalsy(cond) {  // don't need to specify type since JS is loosely typed
      if(cond) {
          console.log("Condition is truthy");   // same as sysout
      } else {
          console.log("Condition is falsy");
      }
  }

  /* -- TYPE COERCION
    As a loosely typed programming language that is interpreted and not compiled, JS has to accommodate
    functions that operate on variables of different types. JS uses type coercion in order to do so.

    Falsy - 0, NaN, null, undefined, '', false
    Truthy - everything else

    When comparing variables/literals we can use == or ===
        == uses type coercion
        === prevents
  */


  // OBJECTS
  var obj = {
      name: 'Molly',
      age: 70,
      saysHi: function(){
          console.log(this.name + ' says hi!');
      }
  }

  // how to access object properties:
  obj.name
  obj["name"]

  // delete properties:
  delete obj.name