// TypeScript is a superset of JavaScript which adds many useful features. It
// must be transpiled to JS in order to use it in the browser or Node.

// TS offers (optional) strict typing. The types are as follows:
// number, boolean, string, void, null, undefined, never, any
// A variable initialized with undefined means that the variable has no value or
// object assigned to it, whereas null means that it has been set to an object
// whose value is undefined.

// Using types:
let greeting: string;
greeting = 'hello';
// greeting = 2; // Illegal!

let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[]; // Strictly typed arrays!
let tup: [1, 'this is a string', {}]; // A tuple is a heterogeneous array.
let f: null;
let g: any;
// never is the return type of functions that never return and of variables that
// can never have a value.
let h: never;

function add(a: number, b: number): number {
  return a + b;
}

let test = add(5, 6);
// let test2 = add('this is', 'a string'); // Illegal

function anyReturn(a: any): any {
  return a;
}

// TS supports enums:
enum DaysOfWeek {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY,
}

let today = DaysOfWeek.THURSDAY;

// Arrow notation
let sayHi = function(welcome: string) {
  console.log(`${welcome}!`);
};

let sayHello = (welcome: string) => console.log(`${welcome}!`);

// Interfaces
interface Human {
  name: string;
  age: number;
  speak(): void;
  hairColor?: string; // Optional property
}

let ian: Human = {
  name: 'Ian',
  age: 22,
  speak() {
    console.log('TS is fun!');
  },
  hairColor: 'brown',
};

// Classes
class Point {
  x: number;
  y: number;

  constructor(x: number, y: number) {
    this.x = x;
    this.y = y;
  }

  // In classes, functions are called methods.
  getDistance(other: Point): number {
    return Math.sqrt((other.x - this.x) ** 2 + (other.y - this.y) ** 2);
  }
}

// Inheritance
class BetterPoint extends Point {
  doAwesomeThing(): void {
    console.log('Yay');
  }

  getDistance(other: Point): number {
    return super.getDistance(other) + 1;
  }
}

// Abstract classes
abstract class Abstract {
  abstract test(): void;
}

class ReadOnly {
  readonly point: Point = new Point(1, 1);
}

let ro = new ReadOnly();
ro.point.x = 2;
