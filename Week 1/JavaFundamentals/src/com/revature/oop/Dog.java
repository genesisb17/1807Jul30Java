package com.revature.oop;

public class Dog extends Animal{

	@Override
	public void breath() {
		System.out.println("dogs breathe WOOF");
		
	}

	@Override
	public void excrete() {
		System.out.println("Please use the litter box..");
		
	}
	
	@Override
	public void consume() {
		System.out.println("dogs consume wish bones");	
	}
	
}
