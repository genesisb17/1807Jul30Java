package com.revature.classbasics;

public class StaticStuff {
	
	static {
		System.out.println("IN BLOCK BEEFORE MAIN");
	}
	
	public static void main(String[] args) {
		System.out.println("IN MAIN METHOD");
	}
	
	static {
		System.out.println("IN BLOCK AFTER MAIN");
	}
	
	public static void instanceStuff() {
		System.out.println("instance stuff");
	}
	//at run time - static blocks are called first, then methods
}
