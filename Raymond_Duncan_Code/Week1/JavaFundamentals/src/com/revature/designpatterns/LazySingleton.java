package com.revature.designpatterns;

public class LazySingleton {

	//This is only a declaration, not an instantiation
	private static LazySingleton lazySingleton;
	
	private LazySingleton() {
		System.out.println("Instantiation lazy singleton");
	}
	
	public static LazySingleton getInstance() {
		if(lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
	
	public void test() {
		System.out.println(this.getClass());
	}
}
