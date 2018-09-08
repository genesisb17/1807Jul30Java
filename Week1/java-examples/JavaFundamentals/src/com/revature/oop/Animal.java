package com.revature.oop;
//access mod / non-access mods / class / className
public abstract class Animal implements Livable{
	/*
	 * Abstract classes have the ability to have
	 * abstract methods(unimplemented methods)
	 * They do NOT need to have an abstract method
	 * to be abstract. they just have the ability to
	 */
	String className = "Animal";
	public void consume() {
		System.out.println("Animals eat things to consume: " + helperMethod() );
	}
	
	private static int helperMethod() {
		return 0;
	}
}
