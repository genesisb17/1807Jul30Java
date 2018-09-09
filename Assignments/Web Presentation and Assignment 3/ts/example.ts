/*
    Intro to TS:

    In order to understand angular, we must first understand TypeScript.

    -strict typing, arrow notation, interfaces, classes, constructors,
    access modifiers, properties, modules*

    TS is a superset of JavaScript, meaning that any valid JS code is valid TS code.
    However, must be TRANSPILED into JS code.
        -transpiled meaning inserting fluidly 
    
        TS Data Types - one of the main features of TS that sets it apart from
        JS is its optional use of strong typing. The types are as follows:
            -number, boolean, string, void, null, undefined, never, any
                -null and undefined types are used for return types
                undefined have no value or objects assigned to it.
                null means that it has been assigned to an object whose value is undefined
    */

    //STRICT TYPING

    let greeting : string;
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
    //return type of functions that never return. type guards that are never true;

    function add(a: number, b: number): number{
        return a + b;
    }

    let test = add(5,6);
    //let test2 = add('this is', 'a string');

    function neverReturns(a: string):never{
        while(true){

        }
    }

    function anyReturn(a: any):any{
    
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
    }

    let today = DaysOfWeek.MONDAY;
    let tomorrow = DaysOfWeek[4];

    //ARROW NOTATION

    let sayHi = function(welcome: string){
        console.log(`${welcome}!!!! ${9+10}`);
    }

    let sayHello = (welcome:string)=>
        console.log(`${welcome}!!!! ${9+10}`);
    
    sayHello('Hi');

    //INTERFACES

    interface Human{
        name: string;
        age: number;
        hairColor?: string; //optional 
        speak(): void;
    
    }

    let ken: Human ={
        name: 'Kenneth',
        age: 24,
        speak: ()=>{
            console.log('Bon jour');
        },
        hairColor: 'black and brown, black and brown'
    }

    class Point{
        x:number;
        y:number;

        constructor(x: number, y: number){
            this.x = x;
            this.y = y;
        }

        //in classes, functions are called methods
        getDistance(){
            return Math.sqrt(this.x*this.x + this.y*this.y);
        }
    }

    class Point3D extends Point{
        z: number;

        constructor(x: number, y:number, z:number){
            super(x, y);
            this.z = z;
        }

        getDistance(){
            let dist = super.getDistance();
            return Math.sqrt(dist*dist + (this.z*this.z));
        }
    }

    let pointZ = new Point3D(1, 2, 3);
    console.log(pointZ.getDistance());
    
    