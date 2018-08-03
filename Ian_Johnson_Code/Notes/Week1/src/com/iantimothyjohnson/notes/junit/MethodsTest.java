package com.iantimothyjohnson.notes.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsTest {
	Methods m;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
		// Good practice to use a new instance for each test.
		m = new Methods();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("After");
		m = null;
	}

	/**
	 * Test method for
	 * {@link com.iantimothyjohnson.notes.junit.Methods#bubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort() {
		int[] nums = { 100, 2, 89, 51, 2, 5, 6, 0 };
		int[] expected = Arrays.copyOf(nums, nums.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, m.bubbleSort(nums));
	}

	/**
	 * Test method for
	 * {@link com.iantimothyjohnson.notes.junit.Methods#reverseString(java.lang.String)}.
	 */
	@Test
	public void testReverseString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.iantimothyjohnson.notes.junit.Methods#factorial(int)}.
	 */
	@Test
	public void testFactorial() {
		fail("Not yet implemented");
	}
}
