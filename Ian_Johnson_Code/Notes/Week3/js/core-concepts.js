/**
 * @file
 * @author Ian Johnson
 */
// JavaScript is a scripting language for client-side operations (though there
// are frameworks that enable server-side JS). It is loosely typed, meaning that
// the variable types are set dynamically. Variables are declared with var, let
// and const. It supports prototypal inheritance.

// Important related concepts: var types, scopes, type coercion hoisting,
// semicolon injection, anonymous functions, template literals, callback
// functions, IIFEs, arrow notation...

function isTruthy(cond) {
  if (cond) {
    return true;
  } else {
    return false;
  }
}

// Type coercion

// As a loosely-typed programming language that is interpreted and not compiled,
// JS has to accommodate functions that operate on variables of different types.
// JS uses type coercion in order to do so.

// Falsy values (anything that evaluates to false): 0, NaN, null, undefined, '',
// false. Truthy values are everything else.

// When comparing variables or literals, we can use == or ===. The former uses
// type coercion, while the latter does not (e.g. 0 == '' but 0 !== '').

// Scopes

// Using the var keyword, we can only use global and function scope. Using the
// let or const keywords, we can also use block scope.

function scopes(cond) {
  var functionVar = 'Uses var in a function';
  let functionLet = 'Uses let in a function';
  const functionConst = 'Uses const in a function';
  if (cond) {
    var blockVar = 'Block var';
    let blockLet = 'Block let';
    const blockConst = 'Block const';
    console.log('In if block');
  }
  console.log(functionVar);
  console.log(functionLet);
  console.log(functionConst);
  console.log(blockVar); // This will not cause an error!
  // console.log(blockLet);
  // console.log(blockConst);
  testGlobal = 5;
  i = 2;
  console.log(i);
  var i = 5;
  console.log(i);
}

// The for...in loop iterates over all non-Symbol, enumerable properties of an
// object.
for (let prop in {hello: 'string'}) {
  console.log(prop);
}

// The guard operator is used to ensure a value is truthy before evaluating the
// second expression:
let x = null && 15; // x === null
let y = 15 && 27; // y === 27
// Basically, it evaluates to the first operand if it is falsy, and the second
// operand if not.
// The default operator is similar: it evaluates to the first operand if it is
// truthy, and the second operand if not:
let z = null || 15; // z === 15
let z2 = 15 || 16; // z2 === 16
