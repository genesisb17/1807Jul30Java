package com.revature.intro;

public class Dog extends Animal {
	
	
	
	public void breathe() {
		System.out.println("dog panting sound.");
	}
	public void whoAmI(String args) {
		System.out.println("I am a dog");
		
	}
	
public static void main(String[] args) {
	Dog D = new Dog();
	D.breathe();
	D.whoAmI("hello");
	
}
}
