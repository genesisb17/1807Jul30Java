package com.revature.oop;

//[access mod] [non-access mod] class [classname]
public abstract class Animal implements Livable {
	 /*
	 * Abstract classes have the ability to have abstract methods
	 * (unimplemented). They do NOT need to have an abstract method
	 * to be abstract. They just have the ability to have one.
	 */
	
	String className = "Animal";
	
	public void consume() {
		System.out.println("EAT! MUNCHY MUNCHY MUNCH!" + helperMethod());
	}
	
	private static int helperMethod() {
		return 0;
	}
}
