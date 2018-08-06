package cjh.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import cjh.question04.Factorial;

public class Question04Test {
	/*
	 * Write a program to compute N factorial
	 */

	@Test
	public void test1() {
		int factorial = 120; //Factorial of 5
		assertEquals(factorial, Factorial.computeFactorial1(5));
	}
	
	@Test
	public void test2() {
		int factorial = 5040; //Factorial of 7
		assertEquals(factorial, Factorial.computeFactorial1(7));
	}
	
	@Test
	public void test3() {
		int factorial = 6; //Factorial of 3
		assertEquals(factorial, Factorial.computeFactorial1(3));
	}
	
	@Test
	public void test4() {
		int factorial = 1; //Factorial of -1
		assertEquals(factorial, Factorial.computeFactorial1(0));
	}
	
	@Test
	public void test5() {
		//Factorial of a negative number should throw an error 
		negativeInput:{
			try {
				Factorial.computeFactorial1(-1);
			} catch (IllegalArgumentException e) {
				//Test successful. Do nothing
				break negativeInput;
			}
			fail("Negative input value not checked");
		}
	}

	
}
