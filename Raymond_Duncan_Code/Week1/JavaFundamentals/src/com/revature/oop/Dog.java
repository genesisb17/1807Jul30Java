package com.revature.oop;

public class Dog extends Animal{

	@Override
	public void breathe() {
		System.out.println("Dogs breathe. WOOF!");
	}

	//Consume is excluded here, because it is already implemented in the abstract class animal. It can still be overridden though.

	@Override
	public void excrete() {
		// TODO Auto-generated method stub
		
	}

	
}
