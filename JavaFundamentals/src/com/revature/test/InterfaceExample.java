package com.revature.test;

interface Domesticated {
	public void doWork();
}

class Dog 
extends Animal 
implements Domesticated {
	public void eat() {
		System.out.println("The dog munches on some kibble");
	}
	
	public void doWork() {
		System.out.println("The dog rolls over!");
	}
}

class Animal {
	public void eat() {
		System.out.println("The animal munches on some food");
	}
}

public class InterfaceExample {

	public static void main(String[] args) {
		
		Animal myDog = new Dog();
		myDog.eat();
		
		Domesticated myPet = new Dog();
		myPet.doWork();
	}
}
