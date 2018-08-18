package com.revature.oop;

public class Dog extends Animal{
	String className = "Dog";
	//@Override //forces the method to override method from parent class of same name
	public void breathe() {
		System.out.println("dogs breathe. woof");
	}

	@Override
	public void excrete() {
		System.out.println("dogs poop everywhere and mark their territory via urine. gross");
	}
	
	public void consume() {
		System.out.println("dogs eat everything");
	}



}
