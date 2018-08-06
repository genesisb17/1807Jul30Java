package cjh.question19;

import java.util.ArrayList;
import java.util.Arrays;

import cjh.question06.Numbers;
import cjh.question09.Primes;

public class EvenOdd {
	/*
	 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all 
	 * the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	 */
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println("Should print 25: " + addOdd(nums));
		System.out.println("Should print 30: " + addEven(nums));
		System.out.println("Should print [1, 4, 6, 8, 9, 10]: " + removePrimes(nums).toString());
	}
	
	public static int addOdd(ArrayList<Integer> lst) {
		int sum = 0;
		for(Integer n:lst) {
			if(!Numbers.isEven(n)) sum += n;
		}
		return sum;
	}
	
	public static int addEven(ArrayList<Integer> lst) {
		int sum = 0;
		for(Integer n:lst) {
			if(Numbers.isEven(n)) sum += n;
		}
		return sum;
	}
	
	public static ArrayList<Integer> removePrimes(ArrayList<Integer> lst) {
		ArrayList<Integer> nonPrimes= new ArrayList<Integer>();
		for(Integer n:lst) {
			if(!Primes.isPrime(n)) nonPrimes.add(n);
		}
		return nonPrimes;
	}

}
