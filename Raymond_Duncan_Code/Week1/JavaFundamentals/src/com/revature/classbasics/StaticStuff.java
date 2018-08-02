package com.revature.classbasics;

public class StaticStuff {

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
