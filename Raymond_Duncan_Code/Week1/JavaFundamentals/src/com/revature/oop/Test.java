package com.revature.oop;

public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.getClass());
		System.out.println(((Animal)d));
		((Animal)d).consume();
//		Animal a = new Dog();
		d.stayinAlive();
		
	}
}
