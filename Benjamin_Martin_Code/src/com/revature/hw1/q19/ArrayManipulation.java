package com.revature.hw1.q19;

import java.util.ArrayList;

public class ArrayManipulation {
	
	public static void main(String[] args) {
		
		// Creating array list to store values and total variable for calculations
		ArrayList<Integer> ArrayList = new ArrayList<>();
		int total = 0;
		
		// Adds values 1-10 into ArrayList
		for (int i = 1 ; i <= 10 ; i++)
			ArrayList.add(i);
		
		// Prints out contents of ArrayList after adding all the values
		System.out.println("Initial Array List: " + ArrayList);
		
		// Loops through the ArrayList and uses the total variable to store the value of adding all the 
		// even numbers together
		for (int i = 0 ; i < 10 ; i++) {
			if (ArrayList.get(i) % 2 == 0) {
				total += ArrayList.get(i);
			}
		}
		
		// Prints the total of the even numbers
		System.out.println("Even Numbers Added Up: " + total);
		// Resets total for the upcoming loop
		total = 0;
		
		// Same as before but does the odd numbers
		for (int i = 0 ; i < 10 ; i++ ) {
			if (ArrayList.get(i) % 2 != 0) {
				total += ArrayList.get(i);
			}
		}
		// Prints the total of the odd numbers
		System.out.println("Odd Numbers Added Up: " + total);
		// Same as before
		total = 0;
		
		// Will loop backwards and remove any numbers that are prime by calling to a method to calculate if it is a prime number
		// the if statement will be true if a false value is in it...hence the ! at the beginning
		for (int i = ArrayList.size() - 1 ; i >= 0 ; i-- ) {
			if (((isPrime(ArrayList.get(i))))) {
				continue;
			}
			else {
				ArrayList.remove(i);
			}
			
		}
		
		// Prints the manipulated ArrayList
		System.out.println("Array List without Prime Numbers: " + ArrayList);
	}
	
	// Method that, when called, will calculate if the value is a prime number or not.
	public static boolean isPrime(int x) {
		boolean itIs = true;
		
		// Because we are going backwards, it will always miss numbers 0 and 1
		// since the for loop will stop executing at 2
		if (x == 1) {
			itIs = false;
		}
		
		// Will loop until it reaches 2. If it hits 2 and does not trigger the boolean, then it is a prime number
		for (int i = 2 ; i < x ; i++ ) {
			if (x % i == 0 ) {
				itIs = false;
			}
		}
		return itIs;
	}
}
