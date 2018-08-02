package com.revature.q9;

import java.util.ArrayList;

public class QuestionNine {

	/**
	 * Lists out all prime numbers from 1 to n.
	 * 
	 * Algorithm used in this implementation is the Sieve of Eratosthenes.
	 * 
	 * @param n The maximum number to evaluate
	 * @return An ArrayList of Integers that are prime numbers
	 */
	public static ArrayList<Integer> listPrimes(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		// Populate list from 0 to n (the initial 0 will get removed toward the end, for simplicity)
		for (int i = 0; i <= n; i++) {
			list.add(i);
		}
		
		// Also, 1 is not a prime number by definition
		list.set(1, 0);
		
		// Sieve of Eratosthenes
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (list.get(i) != 0) {
				for (int j = (i * i); j <= n; j += i) {
					list.set(j, 0);
				}
			}
		}

		// Remove all zeroes set from before
		while (list.remove(new Integer(0))) {
		}

		return list;
	}

	public static void main(String[] args) {
		System.out.println(listPrimes(100));
	}

}
