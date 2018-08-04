package com.iantimothyjohnson.homework.question19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.iantimothyjohnson.homework.question9.Question9;

/**
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 * Add all the even numbers up and display the result. Add all the odd numbers
 * up and display the result. Remove the prime numbers from the ArrayList and
 * print out the remaining ArrayList.
 * 
 * @author Ian Johnson
 */
public class Question19 {
	public static void main(String[] args) {
		// First, we get our ArrayList with the numbers 1 through 10. We can
		// initialize it with a capacity since we know in advance how many
		// elements we need (10).
		List<Integer> nums = new ArrayList<>(10);
		for (int i = 1; i <= 10; i++) {
			nums.add(i);
		}
		System.out.println("Numbers 1 through 10: " + nums);

		// Let's get the sum of all even numbers using a more functional method.
		// Note that we have to convert the Stream<Integer> into an IntStream
		// before using the sum method.
		int sumEvens = nums.stream().mapToInt((n) -> n).filter((n) -> n % 2 == 0).sum();
		System.out.println("Sum of even numbers: " + sumEvens);
		
		// Finding the sum of all odd numbers is analogous:
		int sumOdds = nums.stream().mapToInt((n) -> n).filter((n) -> n % 2 != 0).sum();
		System.out.println("Sum of odd numbers: " + sumOdds);
		
		// To filter out all the prime numbers, we can reuse the isPrime method
		// from question 9. The collect method on a stream allows us to collect
		// the elements of a stream into some other format (in this case, a
		// list). Using this more functional approach saves the trouble of
		// having to manually create a new ArrayList, loop through the old one,
		// and add the non-primes ourselves (at the expense of being a little
		// more unfamiliar to most people).
		nums = nums.stream().filter((n) -> !Question9.isPrime(n)).collect(Collectors.toList());
		System.out.println("All primes removed: " + nums);
	}
}
