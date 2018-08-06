package com.revature.oop;

public interface Livable {
	//abstract keyword is implicit in interfaces
	//public is also implicit
	//all constant values in interface is public
	//only keywords allowed are public, abstract, default, static, strictfp
	void breath();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		System.out.println("ha ha ha stayin aliiiiiiiive");
	}
	
}
