/*
    INTRO TO TS:
    

    In order to understand Angular, we myst first understand TypeSript

    - Strict typing, arrow notation, interfaces, classes, constructors, access modifiers, properties, modules *

    TS is a superset of JS, meaning that any valid JS code is also valid TS code. TS code, however, myst be TRANSPILED into js code.

    TS Data Types - one of the main features of TS that sets it apart fro mJS is its (optional) use of strong typing. The types are as follows:
     - number, bookean, string, void, null undefined never, any
     - A variable initialized with undefined means that the car has no value or object assigned to it wheras null means that it has been set to an object whose value is undefined
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
//STRICT TYPING
var greeting; //This is the concept of strict typing. This enforces that greeting will always be of type string.
greeting = 'hello';
var a;
var b;
var c;
var d;
var e; //Strictly typed array
var tup;
var f;
//f = 5; //reassigbment does not compile due to strict typing!
var g;
var h; //Return type of functions that never return. Type guards that are never true
// h = 6;
// h = 0;
// h = false;
//RETURN TYPES
function add(a, b) {
    return a + b;
}
var test = add(5, 6);
// let test2 = add('this','is a test');
function neverReturns(a) {
    while (true) { }
}
function anyReturn(a) {
    return undefined;
}
function anyReturnsNever(a) {
    var ret;
    return ret;
}
//NEVER is generally used for functions. They either have an endless loop, or they throw some error exception
//TS supports Enum data type
var DaysOfWeek;
(function (DaysOfWeek) {
    DaysOfWeek[DaysOfWeek["Mon"] = 0] = "Mon";
    DaysOfWeek[DaysOfWeek["Tue"] = 1] = "Tue";
    DaysOfWeek[DaysOfWeek["Wed"] = 2] = "Wed";
    DaysOfWeek[DaysOfWeek["Thurs"] = 3] = "Thurs";
    DaysOfWeek[DaysOfWeek["Fri"] = 4] = "Fri";
    DaysOfWeek[DaysOfWeek["Sat"] = 5] = "Sat";
    DaysOfWeek[DaysOfWeek["Sun"] = 6] = "Sun";
})(DaysOfWeek || (DaysOfWeek = {}));
;
var today = DaysOfWeek.Thurs;
var tomorrow = DaysOfWeek[4];
//ARROW NOTATION
var sayHi = function (welcome) {
    console.log(welcome + "!!!");
};
var sayHelloo = function (welcome) { return console.log(welcome + "!!!"); };
sayHelloo("hi");
var ray = {
    name: "ray",
    age: 22,
    speak: function () { return console.log("What's good homie??"); }
};
/*
CLASSES

*/
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    //In classes, functions are called methods
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
//inheritance
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    //Override getDistance
    Point3D.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    };
    return Point3D;
}(Point));
var pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance);
