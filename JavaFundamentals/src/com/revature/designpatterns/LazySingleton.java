package com.revature.designpatterns;

public class LazySingleton {
	
	//ONLY declaration NOT instantiation 
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
	public static void test() {
		System.out.println("in lazy class");
	}
	

}
