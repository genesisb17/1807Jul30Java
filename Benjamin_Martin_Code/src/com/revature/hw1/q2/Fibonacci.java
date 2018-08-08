package com.revature.hw1.q2;

public class Fibonacci {
	
	public static void main(String[] args) {
		int a = 25;
		
		// Sets up variables for calculations in for loop
		int fib = 0;
		int prevFib = 1;
		
		// Will loop and add to fib until i passes a
		for (int i = 1 ; i <= a ; i++ ) {
			int temp = fib;
			fib += prevFib;
			prevFib = temp;
			System.out.println(fib);
		}
	}

}
