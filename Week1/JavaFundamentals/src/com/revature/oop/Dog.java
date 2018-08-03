package com.revature.oop;

public class Dog extends Animal{

	
	
	String className = "Dog";

	public void consume() {
		System.out.println("yummy yum");
	}
	
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("breathy breathe");
	}

	@Override //unnecessary as it's already implicitly called
	public void execrete() {
		// TODO Auto-generated method stub
		System.out.println("poopy poop");
	}
	
	

}
