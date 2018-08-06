package com.revature.junit;

public class NotJunit {
	
	/*
	 * Asserts are not naturally enabled, so you have to go into VM arguments
	 * 	and type "-ea" (enable assertions)
	 * 
	 * Don't confuse the assert methods in JUnit with Java assertions. These
	 * 	are lines of code that will be ignored without changing vm arguments
	 * 	to enable them, but will throw an AssertionError and halt the execution
	 * 	of your code if assert condition is not met.
	 */
	
	public static void main(String[] args) {
		assert(args.length>0);
		System.out.println("assert worked");
	}

}
