package com.revature.intro;

public interface Livable {
	
	// Abstract keyword is implicit in interfaces
	// only keywords allowed are public, abstract, default, and strictfp
	abstract void breathe();
	void consume();
	void excrete();
	
	default void stayinAlive() {
		System.out.println("ha ha ha ha stayin' aliiiiiiiiiiive!");
	}

}
