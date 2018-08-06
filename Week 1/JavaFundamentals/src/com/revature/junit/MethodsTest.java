package com.revature.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsTest {
	
	Methods m;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		m = new Methods();
		System.out.println("before");
	}

	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("after");
	}

	@Test
	public void testBubbleSort() {
		
		int[] nums = {100, 2, 89, 51, 3, 3, 1};
		int[] expected = {0, 2, 2, 5, 6, 51, 89, 100};
		assertArrayEquals(expected, m.bubbleSort(nums));
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
