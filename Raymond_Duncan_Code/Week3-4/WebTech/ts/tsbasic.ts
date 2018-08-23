/* 
    INTRO TO TS:
    

    In order to understand Angular, we myst first understand TypeSript

    - Strict typing, arrow notation, interfaces, classes, constructors, access modifiers, properties, modules *

    TS is a superset of JS, meaning that any valid JS code is also valid TS code. TS code, however, myst be TRANSPILED into js code.

    TS Data Types - one of the main features of TS that sets it apart fro mJS is its (optional) use of strong typing. The types are as follows:
     - number, bookean, string, void, null undefined never, any
     - A variable initialized with undefined means that the car has no value or object assigned to it wheras null means that it has been set to an object whose value is undefined
*/

//STRICT TYPING
let greeting: string;   //This is the concept of strict typing. This enforces that greeting will always be of type string.
greeting = 'hello'; 

let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[];    //Strictly typed array
let tup: [1, 'this is a string', {}];
let f: null;
//f = 5; //reassigbment does not compile due to strict typing!
let g: any;
let h: never; //Return type of functions that never return. Type guards that are never true
// h = 6;
// h = 0;
// h = false;

//RETURN TYPES
function add(a:number, b:number): number {
    return a + b;
}

let test = add(5,6);
// let test2 = add('this','is a test');

function neverReturns(a: string): never {
    while(true){}
}

function anyReturn(a: any): any {
    return undefined;
}

function anyReturnsNever(a: any): any {
    let ret: never;
    return ret;
}

//NEVER is generally used for functions. They either have an endless loop, or they throw some error exception

//TS supports Enum data type
enum DaysOfWeek{
    Mon = 0,
    Tue = 1,
    Wed = 2,
    Thurs = 3,
    Fri = 4,
    Sat = 5,
    Sun = 6
};

let today = DaysOfWeek.Thurs;
let tomorrow = DaysOfWeek[4];

//ARROW NOTATION
let sayHi = function(welcome: string) {
    console.log(`${welcome}!!!`);
}

let sayHelloo = (welcome: string) => console.log(`${welcome}!!!`);
sayHelloo("hi");


//INTERFACES
interface Human{
    name: string;
    age: number;
    hairColor?: string; //Question marks denote optional fields
    speak(): void;
}

let ray: Human = {
    name: "ray",
    age: 22,
    speak: ()=>console.log("What's good homie??")
}

/* 
CLASSES

*/
class Point{
    x: number;
    y: number;

    constructor( x: number, y: number){
        this.x = x;
        this.y = y;
    }

    //In classes, functions are called methods

    getDistance(): number {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

}

//inheritance
class Point3D extends Point {
    z: number;

    constructor(x: number, y: number, z: number){
        super(x,y);
        this.z = z;
    }

    //Override getDistance
    getDistance(): number {
        return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
    }
}

let pointZ = new Point3D(1,2,3);
console.log(pointZ.getDistance);