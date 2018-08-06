package cjh.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cjh.question10.Minimum;

public class Question10Test {
	/*
	 * Find the minimum of two numbers using ternary operators.
	 */

	@Test
	public void test() {
		assertEquals(5, Minimum.whichMin(5,7));
		assertEquals(7, Minimum.whichMin(16,7));
		assertEquals(-1, Minimum.whichMin(-1,0));
		assertEquals(-7, Minimum.whichMin(-2,-7));
		assertEquals(0, Minimum.whichMin(0,8));
		assertEquals(5, Minimum.whichMin(5,5));
	}

}
