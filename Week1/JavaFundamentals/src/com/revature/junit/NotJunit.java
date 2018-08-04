package com.revature.junit;

public class NotJunit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Don't confuse assert methods in JUnit with java assertions.
		 * These are lines of code that will be ignored without changing vm arguments
		 * to enable them, but will throw an AssertionError and halt the execution 
		 * of your code if the assert condition is not met.
		 */
		assert(args.length>0): "no args";
		System.out.println("assert worked");
	}

}
