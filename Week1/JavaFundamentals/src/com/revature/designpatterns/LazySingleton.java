package com.revature.designpatterns;

public class LazySingleton {
	
	//Only declaration, NOT instantiation
	private static LazySingleton instance;
	
	private LazySingleton() {
		System.out.println("instantiating lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		
		return instance;
	}
	
	public void test() {
		System.out.println("test in lazy class");
	}
	
}
