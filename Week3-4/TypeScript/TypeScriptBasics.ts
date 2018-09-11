/**
 * Intro to TS:
 * 
 * In order to understand Angular, we must first understand TypeScript.
 * 
 * - Strict typing, arrow notation, interfaces, classes, constructors, access modifiers
 *  properties, modules, etc.
 * 
 * TS is a superset of JS, meaning that any valid JS code is also valid TS code
 * TS code, however, must be transpiled into JS code.
 * 
 * TS Data Types - one of the main features of TS that sets it apart from
 * JS is its (optional) use of strong typing. The types are as follows:
 * - number, boolean, string, void, null, undefined, never, any
 * - A variable initialized with undefined means that the var has no value or object
 * assigned to it whereas null means that it has been set to an object whose value is
 * undefined
 */

 //Strict Typing
 let greeting: string;
 greeting = 'hello';

 let a: number;
 let b: boolean;
 let c: string;
 let d: object;
 let e: string[]; //strictly typed arrays
 let tup: [1, 'this is a string', {}]; //a tuple is a heterogeneous array
 let f: null;
 //f = 5; //reassignment does not compile due to strict typing
 let g: any;
 let h: never;
//  h = false;
//return type of functions that never return. type guards that are never true;

//Return Types
function add(a: number, b: number): number {
    return a + b;
}

let test = add(5, 6);
//let test2 = add('oops', 'shouldnt be allowed'); return type should be number and take in numbers due to strict typing

function neverReturns(a: string): never { //never reaches end of method
    while(true) {

    }
}

function anyReturn(a: any): any {
    return undefined;
}

//TS supports enum data types
enum DaysOfWeek {
    MONDAY = 1,
    TUESDAY = 2,
    WEDNESDAY = 3,
    THURSDAY = 4,
    FRIDAY = 5,
    SATURDAY = 6,
    SUNDAY = 7
}

let today = DaysOfWeek.THURSDAY;
let tomorrow = DaysOfWeek[4];

//Arrow Notation
let sayHi = function(welcome: string) {
    console.log(`${welcome}!!!`);
}

let sayHelloo = (welcome: string) => console.log(`${welcome} again!!!`);
sayHelloo('hi');

//Interfaces
interface Human {
    name: string;
    age: number;
    hairColor?: string; //optional properties
    speak(): void;
}

let sam: Human = {
    name: 'Sammy';
    age: 22;
    hairColor: 'black';
    speak: () => {console.log('Yoyoyo');}
}

//Classes
class Point {
    x: number;
    y: number;

    constructor(x: number, y: number) {
        this.x = x;
        this.y = y;
    }

    //In classes, functions are called methods

    getDistance() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
}

//Inheritance
class Point3D extends Point {
    z: number;

    constructor(x: number, y: number, z: number) {
        super(x,y);
        this.z = z;
    }

    //overriding
    getDistance() {
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}