package com.revature.classbasics;

public class Scopes {

	/* Scopes are the lifetime of a variable. There are four different scopes.
	 * 
	 * Class/Static = This is what we usually mean by global
	 * 	Static entities (vars, methods, nested classes) are accessible WITHOUT going 
	 * 	outside of a class WITHOUT an instance. i.e. Class.x or Class.main()
	 * 	Static variables are SHARED throughout all instances of the class
	 * 	Class c = new Class();
	 * 	Class c2 = new Class();
	 * 	c.x == c2.x // true
	 * 
	 * Object/Instance = the object's fields/state
	 * 	Entities in this scope can only be accessed by an instance of the object they
	 * 	belong to. i.e. Class c - new Class(); c.x or c.method() NOT Class.method, that would
	 * 	be static
	 * 
	 * Method = mostly parameters and any variables defined at the method
	 * 	Variables in this scope exist for the lifetime of a method
	 * 
	 * Loop/Block = any variables defined within curly braces
	 * 
	 * 
	 * Basically access modifiers say if you can access these outside of the class whereas
	 * non access modifiers tell you how you can access it (i.e. instance required or not)
	 * 
	 * We CAN access static vars and methods from an instance of an object
	 * We CaNNOT access instance vars and methods from a class alone
	 * 
	 * class A {
	 * 	static int count;
	 * 	int age;
	 * }
	 * 
	 * class B {
	 * 	main {
	 * 		A.count; //valid because count is static
	 * 		A a = new A; //create Instance of a aka INSTANTIATE A
	 * 		a.age; //valid because age is instance var
	 * 		a.count; //valid because a is an instance of class A
	 * 		A.age; //not valid, don't do this, will not complete
	 * 	}
	 * }
	 */
	
	int age;
	String name;
	static int count;
	
	static Integer integer; //object default is null, as goes for all objects
	static double d;
	static boolean b; //default is false
	static short s;
	static char ch;
	static long l;
	static float f;
	static byte by;
	public static void main(String[] args) {
		/*Integer num = new Integer(5);
		Integer x = new Integer(159109);
		System.out.println(num.MAX_VALUE == x.MAX_VALUE);
		
		Scopes s = new Scopes();
		s.age = 16;
		doThings();*/
		
		//static and instance variables have default values (0). Not strings.
		//System.out.println(count); //will return 0
		//
	}
	
	public Scopes() {
		//constructor... will discuss later
		count++;
	}

	static void doThings() {
		test(); //couldn't call if test wasn't static. Would have to instantiate
	}
	
	static void test() {
		doThings(); //can call doThings since it's static
	}
}
