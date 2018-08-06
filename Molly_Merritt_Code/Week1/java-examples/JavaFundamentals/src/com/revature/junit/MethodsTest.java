package com.revature.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsTest {

	@BeforeClass	// executes before any tests are run
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass		// executes after all tests are run
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before		// executes before each test
	public void setUp() throws Exception {
		System.out.println("before");
	}
	
	@After		// executes after each test
	public void tearDown() throws Exception {
		m = null;
		System.out.println("after");
	}

	@Test
	public void testBubbleSort() {
		int[] nums = {100, 2, 89, 51, 2, 5, 6, 0};
		int[] expectedn = {0,2,2,5,6,51,89,100};
		assertArrayEquals(expectedn, m.bubbleSort(nums));
		assertNotNull(nums);
		fail("Not yet implemented");
	}

	@Test
	public void testReverseString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFactorial() {
		fail("Not yet implemented");
	}

}
