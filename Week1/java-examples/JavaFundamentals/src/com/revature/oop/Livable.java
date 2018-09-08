package com.revature.oop;

public interface Livable {
	
	//abstract and public keywords is implicit in interfaces
	// only keywords allowed are public abstract default static strictfp
	abstract void breathe();
	void consume();
	void excrete();
	default String test() {
		return "does basic things, but now i dont have to change "
				+ "every implementing class.";
	}
	
	default void stayinAlive() {
		System.out.println("ha ha ha ha stayin aliiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiive");
	}

}
