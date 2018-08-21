package com.revature.hw1.q9;

import java.util.ArrayList;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		// ArrayList to store all of our numbers
		ArrayList<Integer> prime = new ArrayList<>();
		
		// Inserts all numbers into ArrayList
		for (int i = 1 ; i <= 100 ; i++) {
			prime.add(i);
		}
		
		// Will loop through each index of the ArrayList
		for (int i = 1 ; i < 100 ; i++) {
			if (((isPrime(prime.get(i))))) {
				System.out.println(prime.get(i));
			}
		}
	}
	
	// Method that, when called, will calculate if the value is a prime number or not.
		public static boolean isPrime(int x) {
			boolean itIs = true;
			for (int i = 2 ; i < x ; i++ ) {
				if (x % i == 0 ) {
					itIs = false;
				}
			}
			return itIs;
		}
}
