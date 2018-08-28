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
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// we still have all of the abilities to use JS in TS but we have some new functionality
// STRICT TYPING
// let greeting = 'hello'; // always use single quotes for strings
var greeting;
greeting = 'hello';
var a;
var b;
var c;
var d;
var e; // strictly typed arrays
var tup; // a TUPLE is a heterogeneous array
var f;
// f = 5; // reassignment does not compile due to strict typing
var g;
var h; // return type of functions that never return. for variables - type guards that are never true
// RETURN TYPES
function add(a, b) {
    return a + b;
}
var test = add(5, 6);
var test2 = add('this is', ' a string'); // it would concatenate these strings
// to make this only work for numbers:
function addNum(a, b) {
    return a + b;
}
function neverReturns(a) {
    while (true) { }
}
function anyReturn(a) {
    return undefined; // you can return anything for return type any
}
// TS supports Enum data type
var DaysOfWeek;
(function (DaysOfWeek) {
    DaysOfWeek[DaysOfWeek["MONDAY"] = 0] = "MONDAY";
    DaysOfWeek[DaysOfWeek["TUESDAY"] = 1] = "TUESDAY";
    DaysOfWeek[DaysOfWeek["WEDNESDAY"] = 2] = "WEDNESDAY";
    DaysOfWeek[DaysOfWeek["THURSDAY"] = 3] = "THURSDAY";
    DaysOfWeek[DaysOfWeek["FRIDAY"] = 4] = "FRIDAY";
    DaysOfWeek[DaysOfWeek["SATURDAY"] = 5] = "SATURDAY";
    DaysOfWeek[DaysOfWeek["SUNDAY"] = 6] = "SUNDAY";
})(DaysOfWeek || (DaysOfWeek = {}));
var today = DaysOfWeek.THURSDAY;
var tomorrow = DaysOfWeek[4];
// ARROW NOTATION
var sayHi = function (welcome) {
    console.log(welcome + "!!! " + (9 + 10)); // can have mathematical expressions in `concatenation`
};
var sayHelloo = function (welcome) { return console.log("" + welcome); };
sayHelloo('hi');
var gen = {
    name: 'my name',
    age: 100,
    speak: function () {
        console.log('arrow notation functionality uses ' +
            'brackets and semicolons when there is more than one line of code');
        console.log('TS is fun');
    },
    hairColor: 'brownish w overly bleached ends'
};
/*
CLASSES
*/
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    // in classes, functions are called methods
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y); // have to say "this" here
    };
    return Point;
}());
var pointA = new Point(10, 10);
console.log(pointA.getDistance());
// INHERITANCE
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    // overriding getDistance() method
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
var pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance());
