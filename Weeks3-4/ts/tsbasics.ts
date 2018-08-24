/*
intro to TS:

in order to understand Angular, we must understand typescript

-strict typeing, arrow notation, interfaces, classes,
    constructors, access modifiers, properties, modules*

TS is a superset of JS, meaning that any valid JS code is
also valid ts code. Ts code, however, must be TRANSPILED
into js code.

TS Data Types - one of the main featues of ts that sets it
apart from js is its (optional) use of strong typing. The 
types are as follows:
    number, boolean, string, void, null, undefined, never, any
    -a variable is initialized with undefined means that 
    the car has no value or object assigned to it.
    whereas null means that is has been set to an object whose
    value is undefined
*/

//strict typing
let greet: string;
greet = 'hello';

let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[];
let tup: [1, 'this is a string', {}];
let f: null;
//f= 4; //reassignment does not compile due to strict typing
let g: any;
let h: never;
//return type of functions that never return. type guards that
//are never true;

//return types of functions
function add(a: number,b: number):number{
    return a +b;
}

let test = add(5,6);
// let test2 = ('this is',' a string'); //now type is num

//ts supports enum data type
enum DaysOfWeek{
    MONDAY=0,
    TUESDAY=1,
    WEDNESDAY=2,
    THURSDAY=3,
    FRIDAY = 4,
    SATURDAY =5,
    SUNDAY=6
};

let today = DaysOfWeek.THURSDAY;
let tomorrow = DaysOfWeek[4];

//arrow notation
let sayHi= function(welcome: string){
    console.log(`${welcome}!!!!`);
}

let sayHello = (welcome:string) => console.log(`${welcome}!!!`)
sayHello("hi");

//interfaces
interface Human{
    name: string;
    age: number;
    hairColor?: string; //optional property
    speak(): void;
}

let gen: Human = {
    name: 'my name',
    age: 100,
    speak: () => console.log('TS is fun');
    hairColor: 'brown'
}

//classes
class Point{
    x: number;
    y: number;

    constructor(x: number, y:number){
        this.x = x;
        this.y = y;
    }

    //in classes, functions are called methods

    getDistance(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
}

//inheritance
class point3D extends Point{
    z:number;

    constructor(x: number, y:number,z:number){
        super(x,y);
        this.z = z;
    }

    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}

let pointZ = new point3D(1,2,3);
console.log(pointZ.getDistance())