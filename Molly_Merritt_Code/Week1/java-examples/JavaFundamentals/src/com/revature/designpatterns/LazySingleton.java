package com.revature.designpatterns;

public class LazySingleton {
	
	// ONLY declaration NOT instantiation
	private static LazySingleton instance;
	
	private LazySingleton() {	// first line is assumed to be "super()"
		System.out.println("instantiating singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		
		return instance;
	}
	
	public void test() {
		System.out.println(this.getClass());
	}

}
