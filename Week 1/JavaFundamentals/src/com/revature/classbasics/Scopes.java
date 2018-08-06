package com.revature.classbasics;

public class Scopes {

	/*Scopes
	 * The life time of a variable
	 * There are four different scopes in Java
	 * 
	 * Class/Static = This is what we usually mean by global
	 * 	Static entities(vars, methods, nested classes) are
	 * 	accessible from outside the class WITHOUT an instance
	 * 	ie. Class.x or Class.main()
	 * 	Regarding static variables, these variables are SHARED throughout 
	 * 	all instances of the class.
	 * 	Class c = new Class();
	 * 	Class c2 = new Class();
	 * 	c.x == c2.x // trueeeee
	 * 
	 * Object/Instance = the object's fields state
	 * 	Entities in this scope can only be accessed by an instance
	 * 	of the object they belong to.
	 * 	ie. Class c = new Class ();
	 * 	c.x or c.method()
	 * 	NOT Class.method() THIS IS SAD
	 * 
	 * Method = mostly parameters and any variables defined at the method
	 * 	Variables in this scope exist for the lifetime of a method call
	 * 
	 * Loop/Block = any variables defined within curly braces
	 * 
	 * WE CAN access static variables and methods from an instance of an object
	 * we CANNOT access instance var and methods from a class alone
	 * 
	 * class A{
	 * 	static int count;
	 * 	int age;
	 * }
	 * 
	 * class B{
	 * 
	 * 	main{
	 * 	A.count; //valid because count is static
	 * 	A a = new A(); //create INSTANCE of a aka INSTANTIATE A
	 * 	a.age; //valid because age is instance var
	 * 	a.count; //valid because a is an instance of class A to which 
	 * 	A.age //not valid no dont do this will not compile
	 * }
	 * }
	 * 
	 */
	
	//state is defined by 
	//behavior is defined by
	
	int age;
	String name;
	
	static boolean b;
	static Integer integer;
	static int count;
	static double d;
	static short s;
	static char ch;
	static long l;
	static float f;
	static byte by;
	
	public Scopes() {
		//constructor.. will discuss later
		count++;
	}
	
	public static void main(String[] args) {
		System.out.println("Integer default: " + count);
		System.out.println("boolean: "+ b);
		test();
	}
	
	static void doThings() {
		//test();
		System.out.println("testintgingaingia");
	}
	
	static void test() {
		doThings(); //Don't need an instance to access a static method
	}
	//static entities can access other static properties and methods

}
