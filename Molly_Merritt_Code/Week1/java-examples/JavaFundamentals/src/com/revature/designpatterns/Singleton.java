package com.revature.designpatterns;

/*
 * Singleton design pattern - use in scenarios which require only one instance
 * 	of an object to be created
 * 
 * Singleton has a private constructor (which is really uncommon). This prevents
 * 	any other class from instantiating this object
 * 
 * The idea of the singleton class is that there can only be one instance of it
 * 
 * Lazy vs. eager
 * 	Eager instantiation - up front we're creating that instance and then every
 * 		time we call getInstance, we're calling that particular instance
 * 	Lazy - have I created an instance yet? If not, create an instance, and if
 * 		so, return the single instance
 */

// eager - creates an instance, even if there's never a reference to it


// EAGER INSTANTIATION
public class Singleton {
	public String name;	// to demonstrate the single instance
	
	private static Singleton singleton = new Singleton();	// might also be final
	
	public static Singleton getInstance() {
		return singleton;
	}

}
