/**
 * 
 */
package com.revature.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ray
 *
 */
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
		m = new Methods();
		System.out.println("Before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("After");
	}

	/**
	 * Test method for {@link com.revature.junit.Methods#bubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort() {
		int[] nums = {100, 2, 89, 53, 2, 6, 83};
		int[] expected = nums;
		Arrays.sort(expected);
		assertArrayEquals(expected, m.bubbleSort(nums));
		assertNotNull(nums);
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.revature.junit.Methods#reversedString(java.lang.String)}.
	 */
	@Test
	public void testReversedString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.revature.junit.Methods#factorial(int)}.
	 */
	@Test
	public void testFactorial() {
		fail("Not yet implemented");
	}

}
