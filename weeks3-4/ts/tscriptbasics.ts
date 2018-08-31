/*

In order to understand Angular we must first understand TypeScript

strict typing,arrow notation, interfaces,classes,constructors,acess modifiers,properties,modules

*/


let greeting='hello';
greeting='hello';

let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[];//Strictly typed arrays
let tup: [1,'This is a string',{}];// a tuple is a heterogenous array
let f:null;
//f=5;//cant do this because f is not strictly null object type
let g:any;
let h:never;//return type of function s that never return type guards that are never true;


//Return Types- the number outsider after the colon is the type that must be returned
function add(a:number,b:number):number{

    return a+b;
}
let test=add(5,6);


function neverReturns(a:string):never{//never reaches end of method
while(true){

}
}



enum DaysOfWeek{

    MONDAY=0,
    TUESDAY=1,
    WEDNESDAY=2,
    THURSDAY=3,
    FRIDAY=4,
    SATRUDAY=5,
    SUNDAY=6
};

let today=DaysOfWeek.THURSDAY;
let tommorow=DaysOfWeek[4];


//Arrow Notation
let sayHi=function(welcome:string){

    console.log(`${welcome}!!!!`)
}

let sayHello=(welcome:string)=>(console.log(`${welcome}!!!`))
sayHello('Hi')

//Interfaces
interface Human{
    name:string;
    age:number;
    hairColor?:string;//optional properties add in a question mark
    speak():void;

}

let gen:Human={
    name:"Mike",
    age:100,
    speak:()=>{console.log('my name is mike');},
    hairColor:"Black"
}

/*
Classes
*/
class Point{
x:number;
y:number;
constructor(x:number,y:number){
this.x=x;
this.y=y;
}

getDistance(){
    return Math.sqrt(this.x*this.x+this.y*this.y);
}
}

class Point3D extends Point{

    z:number;

    constructor(x:number,y:number,z:number){
        super(x,y);
        this.z=z;
    }
    getDistance(){
        let dist=super.getDistance();
        return Math.sqrt(dist*dist+this.z*this.z)
    }
}

let Poinz=new Point3D(1,4,5);
console.log(Poinz.getDistance);



class Car{
    readonly brand:string;
}
//read only means that i cant change this without setting a constructor

class car2{

    readonly brand:string;
    constructor(brand:string){
        this.brand=brand;
    }
}