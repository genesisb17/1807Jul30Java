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
