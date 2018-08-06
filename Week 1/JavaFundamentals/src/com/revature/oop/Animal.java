package com.revature.oop;

//access modifier / non-access mods / class / class name
//final DOES NOT make sense with abstract
public abstract class Animal implements Livable{
	
	/*
	 * Abstract classes have the ability to have
	 * abstract methods (unimplemented methods)
	 * They do NOT need to have an abstract method
	 * to be abstract. They just have the ability to
	 */
	
	public void consume() {
		System.out.println("Animals scurry around for food to consume.");
	}
	
}
