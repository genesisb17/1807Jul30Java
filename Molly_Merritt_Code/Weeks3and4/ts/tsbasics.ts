/*
Intro to TS:

In order to understand Angular, we must first understand TypeScript.

- strict typing, arrow notation, interfaces, classes, constructors, access modifiers,
  properties, modules*

TypeScript is a superset of JS, meaning that any valid JS code is also valid TS code,
however, must be transpiled into JS code.

TS Data Types - one of the main features of TS that sets it apart from JS is its optional
use of strong typing. The types are as follows:
- number, boolean, string, void, null, undefined, never, any
- a variable initialized with undefined means that the variable has no value or object
  assigned to it, whereas null means that it has been set to an object whose value is undefined
*/

// we still have all of the abilities to use JS in TS but we have some new functionality

// STRICT TYPING
// let greeting = 'hello'; // always use single quotes for strings
let greeting: string;
greeting = 'hello';

let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[];    // strictly typed arrays
let tup: [1,'this is a string', {}];    // a TUPLE is a heterogeneous array
let f: null;
// f = 5; // reassignment does not compile due to strict typing
let g: any;
let h: never;   // return type of functions that never return. for variables - type guards that are never true


// RETURN TYPES
function add(a, b) {
    return a + b;
}
let test = add(5,6);
let test2 = add('this is', ' a string');    // it would concatenate these strings

// to make this only work for numbers:
function addNum(a: number, b:number): number {
    return a + b;
}