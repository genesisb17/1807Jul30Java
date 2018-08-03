package com.iantimothyjohnson.notes.designpatterns;

public class LazySingleton {
	// This is only the declaration, not the instantiation!
	private static LazySingleton instance;

	private LazySingleton() {
		System.out.println("Ugh, do I *have* to be instantiated?");
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public void test() {
		System.out.println("Lazy singleton reporting for duty... sigh.");
	}
}
