package com.revature.designpatterns;


//EAGER INSTANTIATION
public class Singleton {
	public String name;	//To demonstrate the single instance
	
	private static Singleton singleton = new Singleton();
	
	/**
	 * Singleton design pattern - used in scenarios
	 * which require only one instance of an object
	 * to be created
	 * 
	 * The private constructor prevents any other
	 * class from instantiating this object
	 */

	private Singleton() {
		System.out.println("Constructing eager singleton");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
}
