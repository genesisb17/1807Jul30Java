package com.iantimothyjohnson.homework.question9;

import java.util.ArrayList;

/**
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the
 * prime numbers to the console.
 * 
 * @author Ian Johnson
 */
public class Question9 {
	public static void main(String[] args) {
		// First, we need an ArrayList with the numbers 1-100.
		ArrayList<Integer> nums = new ArrayList<>(100);
		for (int i = 1; i <= 100; i++) {
			nums.add(i);
		}

		// Now, let's go through and print only the primes in the above list to
		// the console. We'll use a Stream for this, because I think functional
		// programming is cool and I wanted to learn how to do it in Java.
		nums.stream().filter(n -> isPrime(n)).forEach(n -> System.out.println(n));
	}

	/**
	 * Check whether the given number is prime.
	 * 
	 * @param n The number to check.
	 * @return Whether n is prime.
	 */
	public static boolean isPrime(int n) {
		if (n < 0) {
			// We don't need to work with negative numbers, but this case is
			// here anyways.
			return isPrime(-n);
		} else if (n == 0 || n == 1) {
			// 0 and 1 are not primes, but the code below would detect them as
			// primes, so they're special cases.
			return false;
		}

		// We check primality by testing all divisors up to (and including)
		// sqrt(n); we don't need to check any higher, since n / m < sqrt(n) if
		// m > sqrt(n) (in other words, divisors bigger than sqrt(n) will have a
		// corresponding divisor smaller than sqrt(n), so we would have already
		// found a divisor and returned false). The condition d <= sqrt(n) is
		// equivalent to the more efficient d * d <= n. Don't forget to start d
		// at 2, since being divisible by 1 is trivial!
		for (int d = 2; d * d <= n; d++) {
			// Recall that n % d == 0 precisely when d divides n.
			if (n % d == 0) {
				// d is a divisor, so n is not prime.
				return false;
			}
		}
		// If no divisors were found, we have a prime number.
		return true;
	}
}
