package com.revature.hw1.q15;

interface Calculating {
	
	// Each method must be in the class that implements it	
	public void addition(int x, int y);
	
	public void subtract(int x, int y);
	
	public void multiplication(int x, int y);
	
	public void division(int x, int y);
	
}

class MathTime implements Calculating {
	
	// Stores the results of whichever method is called
	private int answer;
	
	// Does adding
	public void addition(int x, int y) {
		int first = x;
		int second = y;
		answer = x + y;
		System.out.println(first + " + " + second + " = " + answer);
	}
	// Does subtracting
	public void subtract(int x, int y) {
		int first = x;
		int second = y;
		answer = x - y;
		System.out.println(first + " - " + second + " = " + answer);
	}
	// Does multiplying
	public void multiplication(int x, int y) {
		int first = x;
		int second = y;
		answer = x * y;
		System.out.println(first + " * " + second + " = " + answer);	
	}
	// Does dividing
	public void division(int x, int y) {
		int first = x;
		int second = y;
		answer = x / y;
		System.out.println(first + " / " + second + " = " + answer);		
	}
}

public class Interfaces {
	
	public static void main(String[] args) {
		
		// Creating two objects with a reference type of the interface that is an instance of the MathTime class
		// and passing arguments to the interface which calls the methods in the class that implements it.
		Calculating example1 = new MathTime();
		example1.addition(5, 7);
		
		Calculating example2 = new MathTime();
		example2.multiplication(8, 16);
	}
}

