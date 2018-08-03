package com.revature.oop;

public interface Livable {
	
	// abstract keyword is implicit in interfaces
	
	// all constant values defined in an interface are implicitly public static final
	
	// only keywords allowed are public, abstract, default, static, strictfp
	
	// all abstract, default, and static methods in an interface are implicitly public
	
	abstract void breathe();
	void consume();
	void excrete();
	
	// stayingAlive is not an abstract method because we already implemented it
	default void stayingAlive() {
		System.out.println("ha ha ha ha stayin aliiiiiiiiiiiiiiiiiiive");
	}

}
