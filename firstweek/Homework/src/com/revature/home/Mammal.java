package com.revature.home;

public abstract class Mammal implements Living {
	
	public static void liveBirth() {
		System.out.println("Mammals give a live birth");
		
	}

	public void shitting() {
		System.out.println("I have to shit.");
		
	}
	public void eating() {
		System.out.println("Mammals have to eat");
	}
	
	public static void whatILookLike() {
		System.out.println("i look like this");
	}
}
