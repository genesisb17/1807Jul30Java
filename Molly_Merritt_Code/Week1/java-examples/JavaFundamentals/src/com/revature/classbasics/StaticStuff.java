package com.revature.classbasics;

public class StaticStuff {
	
	// static blocks execute before main method (upon loading of the class)
	
	static {
		System.out.println("IN BLOCK BEFORE MAIN");
	}
	
	public static void main(String[] args) {
		System.out.println("IN MAIN METHOD");
	}
	
	static {
		System.out.println("IN BLOCK AFTER MAIN");
	}

}
