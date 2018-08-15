package com.revature.intro;

public class Human extends Animal {

	int x = 10;

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
		Animal H = new Human();

		H.breathe();
		((Human) H).whoAmI("hello");

	}

	@Override
	public void consume() {
		System.out.println("I am a human and i like to eat cooked food");
		
	}

	@Override
	public void excrete() {
		// TODO Auto-generated method stub
		
	}

}
