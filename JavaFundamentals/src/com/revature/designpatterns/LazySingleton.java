package com.revature.designpatterns;

public class LazySingleton {
	
	// Only declaration not instantiation
	private static LazySingleton instance;

	private LazySingleton() {
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
