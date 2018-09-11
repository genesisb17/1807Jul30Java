/* Static Typing

    A very distinctive feature of TypeScript is the support of 
    static typing. This means that you can declare the types of 
    variables, and the compiler will make sure that they aren't 
    assigned the wrong types of values. If type declarations are 
    omitted, they will be inferred automatically from your code.
*/

var burger: string = 'hamburger',
    calories: number = 300,
    tasty: boolean = true;

//Alternatively you can omit ':String' and just have var burger = 'hamburger';
//In a function, the type declaration is as so:

function speak(food: string, energy: number): void {    //returns void
    console.log('Our ' + food + ' has ' + energy + ' calories.');
}

speak(burger, calories);

/*  Though when converted into javascript, js won't have the same safeguards,
    it'll convert in a way that's code safe and intended like making sure the data types fit
    the variables or parameters
    Common data types: Number, String, Boolean, Any, Arrays, and Void
*/

/*  Interfaces

    Interfaces are used to type-check whether an object fits a certain structure. 
    By defining an interface we can name a specific combination of variables, 
    making sure that they will always go together. When translated to JavaScript, 
    interfaces disappear - their only purpose is to help in the development stage.
*/

//Food interface, properties, and type
interface Food {
    name: string,
    calories: number;
}

// We tell our function to expect an object that fulfills the Food interface. 
// This way we know that the properties we need will always be available. Objects!
function speak0(food: Food): void{
    console.log("Our " + food.name + " has " + food.calories + " calories.");
}

// We define an object that has all of the properties the Food interface expects.
// Notice that types will be inferred automatically.
var ice_cream = {
    name: "ice cream", 
    calories: 200
}

speak0(ice_cream);

/*  Classes & OOP

    TypeScript offers a class system that is very similar to Java and C#.
    Includes inheritance, abstract classes, interface implementations, setters,
    getters, and more.
*/

class Menu {
    //Properties are public by default but can be private or protected.
    items: Array<string>;
    pages: number;

    //A constructor
    constructor(item_list: Array<string>, total_pages: number) {
        this.items = item_list;
        this.pages = total_pages;
    }

    //Methods
    list(): void {
        console.log('Our menu for today: ');
        for(let i=0; i<this.items.length; i++) {
            console.log(this.items[i]);
        }
    }
}

// Create a new instance of the Menu class.
var sundayMenu = new Menu(["pancakes","waffles","orange juice"], 1);

// Call the list method.
sundayMenu.list();

//Inheritance

class HappyMeal extends Menu {
    // Properties are inherited
  
    // A new constructor has to be defined.
    constructor(item_list: Array<string>, total_pages: number) {
      // In this case we want the exact same constructor as the parent class (Menu), 
      // To automatically copy it we can call super() - a reference to the parent's constructor.
      super(item_list, total_pages);
    }
  
    // Just like the properties, methods are inherited from the parent.
    // However, we want to override the list() function so we redefine it.
    list(): void{
      console.log("Our special menu for children:");
      for(var i=0; i<this.items.length; i++) {
        console.log(this.items[i]);
      }
  
    }
  }
  
// Create a new instance of the HappyMeal class.
var menu_for_children = new HappyMeal(["candy","drink","toy"], 1);
  
// This time the log message will begin with the special introduction.
menu_for_children.list();


/*  Generics

    Generics are templates that allow the same function to 
    accept arguments of various different types. Creating 
    reusable components using generics is better than using 
    the 'any' data type, as generics preserve the types of 
    the variables that go in and out of them.
*/

// The <T> after the function name symbolizes that it's a generic function.
// When we call the function, every instance of T will be replaced with the actual provided type.
// Receives one argument of type T,
// Returns an array of type T.
function genericFunc<T>(argument: T): T[] {    
    var arrayOfT: T[] = [];    // Create empty array of type T.
    arrayOfT.push(argument);   // Push, now arrayOfT = [argument].
    return arrayOfT;
  }
  
var arrayFromString = genericFunc<string>("beep");
console.log(arrayFromString[0]);         // "beep"
console.log(typeof arrayFromString[0])   // String

var arrayFromNumber = genericFunc(42);
console.log(arrayFromNumber[0]);         // 42
console.log(typeof arrayFromNumber[0])   // number
//The first time it's called, we set the 'string' data type. As in the second call,
//specifying the data type isn't necessary and TS will infer. Good practice to do so anyway


/** Modules
 *  
 * Another important concept when working on large apps is modularity. 
 * Having your code split into many small reusable components helps your 
 * project stay organized and understandable, compared to having a single 
 * 10000-line file for everything.
 * 
 * TypeScript introduces a syntax for exporting and importing modules, 
 * but cannot handle the actual wiring between files. To enable external 
 * modules TS relies on third-party libraries: require.js for browser apps 
 * and CommonJS for Node.js. Let's take a look at a simple example of TypeScript 
 * modules with require.js:
 */


//This exports a function. Will go in a separate file called 'exporter.ts'
var sayHi = function(): void {
    console.log("Hello!");
}

export = sayHi;


//This imports the file created above.
//import sayHi = require('./exporter');
//sayHi();

//To compile these (since they are requirejs) we need the amd keyword as so
//tsc --module amd *.ts
//Modules are very complex so we'll move on for now


/** Declaration Files (Third Party JS Support)
 *  
 * When using a library that was originally designed 
 * for regular JavaScript, we need to apply a declaration 
 * file to make that library compatible with TypeScript. 
 * A declaration file has the extension .d.ts and contains 
 * various information about the library and its API.
 * 
 * 'DefinitelyTyped' is the biggest public repository, as
 * well as a popular Node.js module for managing TypeScript
 * definitions called 'Typings'
 */

/** What's new in Typescript 2.0?
 * 
 * Non-nullable types flag which prevents some variables from having their 
 * value set to null or undefined. New improved system for getting declaration 
 * files directly with an npm install. Control flow type analysis that catches 
 * errors previously missed by the compiler. Some innovations in the module
 * export/import syntax. Another long-awaited feature is the ability to control 
 * the flow of asynchronous functions in an async/await block.
 * 
 * FOr current features that are powerful, there are also namespaces, enums, 
 * advanced types & type guards, and writing JSX.
 */