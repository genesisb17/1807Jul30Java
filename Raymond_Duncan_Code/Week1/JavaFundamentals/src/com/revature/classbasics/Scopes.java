package com.revature.classbasics;

public class Scopes {
	/*
	 * Scopes are the lifetime of a variable
	 * There are four different scopes in Java
	 * Class/Static = This is what we usually mean by global
	 * 		Static entities(vars, methods, nested classes)
	 * 		are accessible from outside of the class Without an instance
	 * 		ie. Clsas.x or Class.main()
	 * 
	 * 		Regarding static variables, these variables are shared throughout all instances of the class
	 * Object/Instance = the object's fields/state
	 * 		Entities in this scope can only be accessed by an instance of the object they belong to.
	 *		ie. Class c = new Class();
	 *			c.x or c.method()
	 *			***NOT Class.method();
	 *
	 *		Must have an object instance to be used
	 *Method = mostly parameters and any variables defined at the method level
	 *		Variables in this scope exist for the lifetime of a method
	 *Loop/Block = any variables defined with curly braces
	 *
	 *
	 *WE CAN access static variables and methods from an instance
	 *of an object
	 *we CANNOT access instance var and methods from a class alone
	 *
	 *class A{
	 *	static int count;
	 *	int age;
	 *}
	 *
	 *class B{
	 *
	 *	main{
	 *	A.count; //valid because count is static
	 *	A a = new A; //create INSTANCE OF AKA instantiate A
	 *	A.age; //valid because age is instance var
	 *	a.count; //valid because a is an instance of class A to which 
	 *	A.age; //NOT VALID! dONT DO THIS, IT WILL NOT COMPILE
	 *
	 *Static and instance variables have default values. Method and block variables do not!
	 */
	
	int age;
	String name;
	static int count = 0;
	
	public Scopes() {
		//constructor... to be explained later
		count++; //Can be used to count the number of instances of Scopes that are in memory
	}
	
	public static void main(String[] args) {
		Integer num = new Integer(5);
		Integer x = new Integer(23669);
		System.out.println(num.MAX_VALUE == x.MAX_VALUE);
		
		Scopes s = new Scopes();
		s.age = 16;
		s.doThings1(); //Must be called from an instance of Scope because doThings1 is non-static
		
		Scopes.doThings2(); //Works because doThings2 is static

	}
	
	void doThings1() {
		
	}
	
	static void doThings2() {
		
	}

}
