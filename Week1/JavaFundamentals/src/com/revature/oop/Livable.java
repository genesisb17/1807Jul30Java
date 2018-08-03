package com.revature.oop;

public interface Livable {

	//implicit abstract keyword in interfaces
	abstract void breathe();
	void consume();
	void execrete();
		
	default void stayingAlive() {
		System.out.println("okayyyyyyyy");
	}
}
