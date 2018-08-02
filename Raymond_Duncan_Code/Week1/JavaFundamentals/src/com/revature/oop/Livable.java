package com.revature.oop;

public interface Livable {

	//abstract keyword is implicit in interfaces
	//only keywords allowed are public, abstract, default, static, and strictfp
	void breathe();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		System.out.println("Ha ha ha ha stayin aliiiiiiiiiiiiiiiiiiiive!");
	}
	
}
