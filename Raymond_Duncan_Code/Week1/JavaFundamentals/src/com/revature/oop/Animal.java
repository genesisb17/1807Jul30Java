package com.revature.oop;

public abstract class Animal implements Livable{

	/*
	 * Abstract classes have the ability to have abstract methods(unimplemented methods)
	 * They do NOT need to have an abstract method to be abstract. They just have the ability to
	 */
	
	@Override
	public void consume() {
		System.out.println("animals eat things to consume" + helperMethod());
	}
	
	public void excrete() {
		System.out.println("Expelling the waste");
	}
	
	//This simply shows that private functions are accessible by the class itself
	private static int helperMethod() {
		return 0;
	}
}
