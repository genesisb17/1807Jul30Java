/*
Into to TS:

In order to understand Angular, we must first understand TypeScript. 

- strict typing, arrow notation, interfaces, classes, constructors, 
access modifiers, properties, modules*

TS is a superset of JS, meaning that any valid JS code is also valid 
TS code. TS code, however, must be TRANSPILED into JS code. 

TS Data Types - one of the main features of TS that sets it apart from 
JS is its (optional) use of strong typing. The types are as follows:
 - number, boolean, string, void, null, undefined, never, any
- a variable initialized with undefined means that the car has no value
or object assigned to it
whereas null means that it has been set to an object whose value is undefined


Helpful resources:
https://blog.mariusschulz.com/2016/11/18/typescript-2-0-the-never-type

*/

//STRICT TYPING
let greeting: string;
greeting = 'hello';

let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[]; //strictly typed arrays
let tup: [1, 'this is a string', {}]; //a TUPLE is a heterogeneous array
let f: null;
//f = 5; //reassignment does not compile due to strict typing
let g: any;
let h: never;
//h = false;

//return type of functions that never return. type guards that are never true;

//RETURN TYPES
function add(a: number, b: number):number { 
    return a + b;
}

let test = add(5, 6);
//let test2 = add('this is', 'a string');

function neverReturns(a: string):never{ //never reaches end of method
    while(true){

    }
}

function anyReturn(a:any):any{
    return undefined;
}

//TS supports Enum data type 
enum DaysOfWeek{
    MONDAY = 0,
    TUESDAY = 1,
    WEDNESDAY = 2,
    THURSDAY = 3, 
    FRIDAY = 4,
    SATURDAY = 5,
    SUNDAY = 6
};

let today = DaysOfWeek.THURSDAY;
let tomorrow = DaysOfWeek[4];

//ARROW NOTATION
let sayHi = function(welcome: string){
    console.log(`${welcome}!!!! ${9+10}`);
}

let sayHelloo = (welcome:string) => console.log(`${welcome}!!!!`);
sayHelloo("hi");

/*INTERFACES
Defining an interface in TS allows you to type-check combinations
of variables. They do not transpile to JS. They exist solely to 
help developers. 
*/
interface Human{
    name: string;
    age: number;
    hairColor?: string; //optional properties
    speak(): void;
}

let gen:Human  = {
    name: 'my name',
    age: 100,
    speak: ()=> {
        console.log('arrow notation functionality uses ' +
        'brackets and semicolons when there is more than one line of code');    
        console.log('TS is fun');
    },
    hairColor: 'brownish w overly bleached ends'
}

/*CLASSES
Classes in TS are similar to classes in most OOP languages. 
Properties are made public by default but can be made private
    - when a member is private, it cannot be accessed from 
      outside of its containing class
    - the protected modifier acts similarly to private, except
      members declared protected can also be accessed within 
      deriving classes
      
Constructors are used to simplify creating new objects 
*/
class Point{
    x: number;
    y: number;

    constructor(x: number, y:number){
        this.x = x;
        this.y = y;
    }

    // in classes, functions are called methods
    getDistance(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
}

let pointA = new Point(10, 10);
console.log(pointA.getDistance());

//inheritance
class Point3D extends Point{
    z: number;

    constructor(x: number, y:number, z:number){
        super(x, y);
        this.z = z;
    }

    //overriding getDistance() method
    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
}

let pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance());

//understanding private 
class Animal{
    private name: string;
    constructor(name: string){
        this.name = name;
    }

    getName(): string{
        return this.name;
    }

    setName(name: string): void{
        this.name = name;
    }
}

let animal = new Animal('Puppy');
//console.log(animal.name); //will not work; name is private
console.log(animal.getName()); //works. using Encapsulation***
//animal.name = 'Tomcat'; //same; still does not work
animal.setName('Tomcat');

//understanding protected 
class Person {
    protected name: string;
    constructor(name: string){
        this.name = name;
    }
}

class Employee extends Person{
    private department: string;
    constructor(name: string, department: string){
        super(name);
        this.department = department;
    }

    public getElevatorPitch(){
        return `Hello, my name is ${this.name} and I work
        in ${this.department}.`;
    }
}

let emp1 = new Employee("John", "Sales" );
//console.log(emp1.name); //cannot access name directly outside of subclass
console.log(emp1.getElevatorPitch()); //works fine


/* READONLY modifier
    You can make properties read only. 
    These properties must be initialized at their declaration or in the constructor
    Allows you to work in a functional way(unexpected mutation is bad)
    Can use modifier in interfaces as well. Can be initialized but not reassigned
*/

class Car{
    readonly brand: string;
    readonly numWheels: 4;
}

let c1 = new Car();
//c1.brand = 'Honda'; //does not work as car is created without brand
console.log(c1.numWheels); //can access
console.log(c1.brand);
// c1.numWheels = 10; // reassignment will not work

class Car2{
    readonly brand: string;
    readonly numWheels: 4;
    constructor(brand: string){
        this.brand = brand;
    }
}

let c2 = new Car2('Honda');//can be set via constructor
//c2.brand = 'Hyundai'; //still not able to be reassigned


/*  STATIC
Thus far, we've only discussed instance members of a class. But it's important
to note that we have static members, which are visible on the class itself
and not instances
*/

class Calculator{
    static add(a: number, b: number):number{
        return a+b;
    }

    static subtract(a:number, b:number):number{
        return a-b;
    }
}

let num = Calculator.add(10, 3);

/* ABSTRACT CLASS
Abstract classes are base classes from which other classes may be derived. They
may not be instantiated directly. Unlike an interface, an abstract class may
contain implementation details for its members. The abstract keyword is used
to define abstract classes as well as abstract methods within an abstract class

Methods within an abstract class that are marked abstract have no implementation
and must be implemented in derived classes; they must use the abstract keyword;
*/
abstract class Account{
    abstract generateReports():void;
}

class CheckingAccount extends Account{
    generateReports(){
        console.log('concrete');
    }
}


//Typescript also supports 
//https://www.typescriptlang.org/docs/handbook/generics.html
