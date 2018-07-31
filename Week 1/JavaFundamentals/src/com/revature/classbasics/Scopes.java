package com.revature.classbasics;

public class Scopes {

	/*Scopes
	 * The life time of a variable
	 * There are four different scopes in Java
	 * Class/Static = This is what we usually mean by global
	 * 	Static entities(vars, methods, nested classes) are
	 * 	accessible from outside the class WITHOUT an instance
	 * 	ie. Class.x or Class.main()
	 * 	Regarding static variables, these variables are SHARED throughout 
	 * 	all instances of the class.
	 * 	Class c = new Class();
	 * 	Class c2 = new Class();
	 * 	c.x == 2.x // trueeeee
	 * 
	 * Objet/Instance = the object's fields state
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
	 */
	public static void main(String[] args) {
		Integer num = new Integer(5);
		Integer x = new Integer(159109);
		System.out.println(num.MAX_VALUE == x.MAX_VALUE);
	}

}
