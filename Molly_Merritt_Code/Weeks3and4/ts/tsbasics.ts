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

function neverReturns(a: string): never {   // never returns
    while(true) {}
}

function anyReturn(a: any): any {
    return undefined;   // you can return anything for return type any
}


// TS supports Enum data type
enum DaysOfWeek {
    MONDAY = 0,
    TUESDAY = 1,
    WEDNESDAY = 2,
    THURSDAY = 3,
    FRIDAY = 4,
    SATURDAY = 5,
    SUNDAY = 6
}

let today = DaysOfWeek.THURSDAY;
let tomorrow = DaysOfWeek[4];


// ARROW NOTATION
let sayHi = function(welcome: string) {
    console.log(`${welcome}!!! ${9+10}`);   // can have mathematical expressions in `concatenation`
}

let sayHelloo = (welcome: string) => console.log(`${welcome}`);
sayHelloo('hi');


// INTERFACES
interface Human {
    name: string;
    age: number;
    hairColor?: string; // optional properties
    speak(): void;  // function with no return type
}

let gen: Human = {
    name: 'my name',
    age: 100,
    speak: ()=> {
        console.log('arrow notation functionality uses ' +
        'brackets and semicolons when there is more than one line of code');
        console.log('TS is fun');
    },
    hairColor: 'brownish w overly bleached ends'
}


/*
CLASSES
*/
class Point {
    x: number;
    y: number;

    constructor(x: number, y: number) {
        this.x = x;
        this.y = y;
    }

    // in classes, functions are called methods

    getDistance() { // don't say "function"
        return Math.sqrt(this.x*this.x + this.y*this.y);    // have to say "this" here
    }
}

let pointA = new Point(10, 10);
console.log(pointA.getDistance());


// INHERITANCE
class Point3D extends Point {
    z: number;

    constructor(x: number, y:number, z:number) {
        super(x,y); // MUST contain super call
        this.z = z;
    }

    // overriding getDistance() method
    getDistance() {
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}

let pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance());