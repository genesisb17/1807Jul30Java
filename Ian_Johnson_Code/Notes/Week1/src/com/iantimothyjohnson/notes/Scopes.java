package com.iantimothyjohnson.notes;

public class Scopes {
	// Instance variables:
	int age;
	String name;
	// Static variables:
	static int count = 0;

	public Scopes() {
		count++; // Keep track of instance count.
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// There are 4 scopes:

		// Class/static: accessible from outside of the class without an
		// instance.
		int x = Integer.parseInt("1");
		// or
		Integer y = new Integer(2);
		int z = y.parseInt("3"); // Note the warning; not good practice.
		// or
		test(); // Use from within the same class.

		// Object/instance: the object's fields/state. Can only be accessed by
		// an instance of the object they belong to.
		String s = "hello!";
		s.length();

		// Method: parameters and variables defined at the method level.

		// Loop/block: any variables defined within curly braces.
	}
	
	static void test() {
		System.out.println("In test");
		test2();
	}
	
	static void test2() {
		System.out.println("In test2");
	}
}
