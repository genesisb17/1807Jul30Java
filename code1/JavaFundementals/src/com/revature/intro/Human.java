package com.revature.intro;

public class Human extends Animal {

	public void whoAmI(String name) {

		System.out.println("i am a human");
		
		if (x == 5) {
			System.out.println("x is equal to five");
		}

	}
	
	public void breathe() {
		System.out.println("human breathing sound.");
	}

	public static void main(String[] args) {
		Human H = new Human();

		H.breathe();
		((Human) H).whoAmI("hello");

	}

	

}
