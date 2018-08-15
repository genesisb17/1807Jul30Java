package com.revature.intro;

public interface Livable {
	
	
	void breathe();
	void consume();
	void excrete();
	
	
	default void stayinAlive() {
		System.out.println("staying alive");
	}

}
