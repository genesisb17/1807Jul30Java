/*
    In order to understand angular, we must first understand TypeScript

    - strict typing, arrow notation, interfaces, classes, constructors
    access modifiers, properties, modules

    TS is a superset of javascript, meaning that any valid JS code is also valid
    TS code. TS code, however, must be TRANSPILED into JS code.

    TS data types - one off the main features of TS taht sets it apart from 
    js is its (options) use of strong typing. The types are as follow:
    - nuber, boolean, string, void, null, undefiend, never, any
    - variable intialized with undefiened means that the car has no value 
    or object assigned to it
    whereas null means that it has been set to an object whose value is undefined
    */

    //Strict Typing

    let greeting: String;
    greeting = 'hello';

    let a: number;
    let b: boolean;
    let c: string;
    let d: object;
    let e: string[]; // strictly typed arrays
    let tup: [1, "This is a string", {}]; //a tuple is a heterogeneous array
    let f: null; 
    // f = 5; // reassignment does not compile due to strict typing
    let g: any;
    let h: never; //return type of afunctions that neer return. type gaurds taht are never true;

    //Return types
    function add (a: number, b: number):number
    {
        return a + b;
    }

    let test = add(5, 6)
    //let test2 = add("this is", "a string");

    function neverReturns(a: string):never
    {
        while(true)
        {

        }
    }

    //allows return type to be any
    function AnyReturn(a: any):any
    {
        return undefined;
    }

    // TS supports Enum data type
    enum DaysOfWeek
    {
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

    //Arrow notation
    let sayHi = function(welcome: string)
    {
        console.log(`${welcome} !!!!`);
    }

    let sayHello = (welcome:string) => console.log(`${welcome}!!!`)
    sayHello("hi");

    interface Human
    {
        name: string;
        age: number;
        hairColor?: string; // option by using '?'
        speak(): void;
    }

    let zac: Human = 
    {
        name: "my name",
        age: 100,
        speak: () => console.log("TS is fun")
    }

    // Classes
    class Point 
    {
        x: number;
        y: number;

        constructor(x: number, y: number)
        {
            this.x = x;
            this.y = y;
        }

        // in classes, functions are called methods

        getDistance()
        {
            return Math.sqrt(this.x*this.x + this.y*this.y);
        }
    }

    //Instantiate class
    let poitnA = new Point(10, 10);
    console.log(poitnA.getDistance());

    //Inheritance
    class Point3D extends Point
    {
        z: number;

        constructor(x: number, y: number, z: number)
        {
            super(x, y);
            this.z = z;
        }

        //overriding getDistance() method
        getDistance()
        {
            let dist = super.getDistance();
            return Math.sqrt(dist*dist + this.z*this.z);
        }
    }

    