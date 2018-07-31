package com.revature.classbasics;

public class Scopes {
	
	/* Scopes
	 * The lifetime of a variable
	 * There are four different scopes in Java
	 * 
	 * Class/Static = This is what we usually mean by global
	 * 		Static entities (vars, methods, nested classes) are accessible
	 * 		from outside the class WITHOUT an instance
	 * 		i.e. Class.x or Class.main()
	 * 		Re: static variables - these variables are SHARED throughotu all
	 * 		instances of the class
	 * 		Class c = new Class();
	 * 		Class c2 = new Class();
	 * 		c.x == c2.x //true
	 * 
	 * Object/Instance = the object's fields/state
	 * 		Entities in this scope can only be accessed by an instance of
	 * 		the object they belong to
	 * 		i.e. Class c = new Class();
	 * 			 c.x or x.metod();
	 * 			 NOT Class.method(); . this would be a static method
	 * 
	 * Method = mostly parameters and any variables defined at the method level
	 * 		Variables in this scope exist for the lifetime of a method
	 * 
	 * Loop/Block = any variables defined within curly braces
	 * 
	 * 
	 * 
	 * 
	 * We CAN access static variables and methods from an instance of an object
	 * We CANNOT access instance variables and methods from a class alone
	 * 
	 * class A {
	 * 		static int count;
	 * 		int age;
	 * }
	 * 
	 * class B {
	 * 		main{
	 * 			A.count; //valid because count is static
	 * 			A a = new A; //create INSTANCE of a, aka INSTANTIATE A
	 * 			a.age; //valid because age is an instance variable
	 * 			a.count; //valid because a is an instance of class A to which count belongs
	 * 			A.age; //NOT VALID NO DONT DO THIS WILL NOT COMPILE
	 * 		}
	 * }
	 */
	
	int age;
	String name;
	static int count = 0;
	
	public Scopes() {
		// constructor.. will discuss later
		count++;
	}

	public static void main(String[] args) {
		Integer num = new Integer(5);
		Integer x = new Integer(159109);
		System.out.println(num.MAX_VALUE == x.MAX_VALUE);
		
		Scopes s = new Scopes();
		s.age = 16;
		doThings();
	}
	
	static void doThings() {
		// from static methods, you need an instance to access an instance method
		// static describes entities as a group
		// instance methods depend on the instance
	}
	
	void test() {
		doThings();	// from instance methods, you can access static
	}
	
}
