package com.revature.factorial;

public class Factorial {

	public static void main(String[] args) {
		
		// Takes the argument and converts it to string
		int a = Integer.parseInt(args[0]);
		
		int number = 1;
		
		// Stops any negative numbers
		if (a < 0 ) {
			throw new IllegalArgumentException();
		}
		
		// Will always be 1 if 0 is entered
		if (a == 0) {
			System.out.println(1);	
		}
		
		// Will multiply with i until it reaches 1
		for(int i = a ; i>0 ; i--){
			number *= i;
		}
		
		System.out.println(number);
		}
}
