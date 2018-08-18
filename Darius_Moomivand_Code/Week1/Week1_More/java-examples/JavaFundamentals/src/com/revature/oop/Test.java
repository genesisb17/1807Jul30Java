package com.revature.oop;

import com.revature.classbasics.StaticStuff;

public class Test {

	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.className);
		System.out.println(((Animal)d).className);
		((Animal)d).consume();
		Animal a = new Dog();
		d.stayinAlive();
		
		Cat c = new Cat();
		c.consume();
		
		
		StaticStuff stuff = new StaticStuff();
		stuff.instanceStuff();
		
		StaticStuff stuff2 = new StaticStuff();
		stuff2.instanceStuff();
		
	}

}
