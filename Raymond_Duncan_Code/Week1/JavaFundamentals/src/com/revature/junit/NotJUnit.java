package com.revature.junit;

public class NotJUnit {
	/*
	 * This is to test assertions. Assertions are not to be confused with JUnit assert methods
	 * Java assertions will be ignored unless JVM argument is changed to all0w them
	 */

	public static void main(String[] args) {
		assert(args.length>0) : "No args";
		System.out.println("Assert didn't work");
	}
}
