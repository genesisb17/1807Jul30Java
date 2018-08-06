package cjh.question09;

import java.util.ArrayList;

public class Primes {
	/*
	 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	 */

	public static void main(String[] args) {
		for(int i = -1; i < 12; i++) {
			System.out.println(i + " is prime: " + isPrime(i));
		}
	}
	
	public static boolean isPrime(int n) {
		if(n < 2) return false;
		for(int i = 2; i <= n/2; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean isPrimeAKS(int n) {
		//TODO: Implement the AKS prime test formula!
		
		/*AKS prime test formula
		 * 	(x-1)^p - (x^p - 1)
		 * if all coefficients are divisible by p, then p is prime
		 */
		return false;
	}
	
	public static boolean inPrimeFermat(int n) {
		//TODO: Implement Fermat's Little Theorem for testing primes
		
		/*Fermat's Little Theorem
		 * 	For all integers a s.t. 1 <= a <= p, the formula a^p - a will identify a prime number
		 * p if the result is divisible by p
		 * 
		 * This should work without issue up to 541. 
		 * 
		 */
		return false;		
	}
	
	public static ArrayList<Integer> findPrimes(ArrayList<Integer> lst){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int n: lst) {
			if(isPrime(n)) primes.add(n);
		}
		return primes;
	}

}
