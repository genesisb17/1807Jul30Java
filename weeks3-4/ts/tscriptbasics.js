/*

In order to understand Angular we must first understand TypeScript

strict typing,arrow notation, interfaces,classes,constructors,acess modifiers,properties,modules

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
var greeting = 'hello';
greeting = 'hello';
var a;
var b;
var c;
var d;
var e; //Strictly typed arrays
var tup; // a tuple is a heterogenous array
var f;
//f=5;//cant do this because f is not strictly null object type
var g;
var h; //return type of function s that never return type guards that are never true;
//Return Types- the number outsider after the colon is the type that must be returned
function add(a, b) {
    return a + b;
}
var test = add(5, 6);
function neverReturns(a) {
    while (true) {
    }
}
var DaysOfWeek;
(function (DaysOfWeek) {
    DaysOfWeek[DaysOfWeek["MONDAY"] = 0] = "MONDAY";
    DaysOfWeek[DaysOfWeek["TUESDAY"] = 1] = "TUESDAY";
    DaysOfWeek[DaysOfWeek["WEDNESDAY"] = 2] = "WEDNESDAY";
    DaysOfWeek[DaysOfWeek["THURSDAY"] = 3] = "THURSDAY";
    DaysOfWeek[DaysOfWeek["FRIDAY"] = 4] = "FRIDAY";
    DaysOfWeek[DaysOfWeek["SATRUDAY"] = 5] = "SATRUDAY";
    DaysOfWeek[DaysOfWeek["SUNDAY"] = 6] = "SUNDAY";
})(DaysOfWeek || (DaysOfWeek = {}));
;
var today = DaysOfWeek.THURSDAY;
var tommorow = DaysOfWeek[4];
//Arrow Notation
var sayHi = function (welcome) {
    console.log(welcome + "!!!!");
};
var sayHello = function (welcome) { return (console.log(welcome + "!!!")); };
sayHello('Hi');
var gen = {
    name: "Mike",
    age: 100,
    speak: function () { console.log('my name is mike'); },
    hairColor: "Black"
};
/*
Classes
*/
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
var Poinz = new Point3D(1, 4, 5);
console.log(Poinz.getDistance);
