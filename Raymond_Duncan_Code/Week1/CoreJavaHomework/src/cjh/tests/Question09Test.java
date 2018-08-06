package cjh.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import cjh.question09.Primes;

public class Question09Test {
	/*
	 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	 */
	
	@Test
	public void test1() {
		int[] nums = {-1,0,1,2,3,4,5,6,7,8,9,10,11};
		boolean[] answers = {false,false,false,true,true,false,true,false,true,false,false,false,true};
		for(int i = 0; i < nums.length; i++) {
			assertTrue(answers[i] == Primes.isPrime(nums[i]));
		}
	}

	@Test
	public void test2() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < 100; ++i) {
			nums.add(i);
		}
		ArrayList<Integer> primes = new ArrayList<Integer>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97));
		
		assertEquals(primes,Primes.findPrimes(nums));
	}

}
