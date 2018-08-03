package com.revature.oop;

import com.revature.classbasics.StaticStuff;

public class DogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog();
		System.out.println(d.className);
		System.out.println(((Animal)d));
		((Animal)d).consume();
		d.breathe();
		d.stayingAlive();
		
		StaticStuff stuff = new StaticStuff();
		stuff.instanceStuff();
		
		StaticStuff stuff2 = new StaticStuff();
		stuff2.instanceStuff();
	}

}
