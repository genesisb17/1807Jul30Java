package com.revature.intro;

public abstract class Animal implements Livable {
	/*
	 *  Abstract classes have the ability to have
	 *  abstract methods (unimplemented methods)
	 *  They do not need to have an abstract method
	 *  to be abstract, they just have the ability to.
	 */
	
	public void consume() {
		System.out.println("Animals eat things to consume.");
	}

}
