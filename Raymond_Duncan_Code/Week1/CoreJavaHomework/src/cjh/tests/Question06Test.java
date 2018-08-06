package cjh.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cjh.question06.Numbers;

public class Question06Test {
	/*
	 * Write a program to determine if an integer is even without using the modulus operator (%) 
	 */

	@Test
	public void test() {
		int[] nums = {-3,-2,-1,0,1,2,3};
		boolean[] answers = {false,true,false,false,false,true,false};
		for(int i = 0; i < nums.length; i++) {
			assertTrue(answers[i]==Numbers.isEven(nums[i]));
		}
	}

}
