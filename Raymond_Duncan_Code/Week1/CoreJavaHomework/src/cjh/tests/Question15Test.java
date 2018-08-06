package cjh.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cjh.question15.Operation;

public class Question15Test {
	/*
	 * Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division. Create a class that 
	 * implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class 
	 * having a main method that calls the implementing class.
	 * 
	 */
	
	static Operation op = new Operation();

	@Test
	public void test1() {
		assertTrue(7 == op.addition(4, 3));
		assertTrue(-1 == op.addition(-4, 3));
		assertTrue(1 == op.addition(4, -3));
		assertTrue(-7 == op.addition(-4, -3));
	}
	
	@Test
	public void test2() {
		assertTrue(1 == op.subtraction(4, 3));
		assertTrue(-7 == op.subtraction(-4, 3));
		assertTrue(7 == op.subtraction(4, -3));
		assertTrue(-1 == op.subtraction(-4, -3));
	}
	
	@Test
	public void test3() {
		assertTrue(12 == op.multiplication(4, 3));
		assertTrue(-12 == op.multiplication(-4, 3));
		assertTrue(-12 == op.multiplication(4, -3));
		assertTrue(12 == op.multiplication(-4, -3));
		
	}
	
	@Test
	public void test4() {
		assertTrue(4.0/3 == op.division(4, 3));
		assertTrue(-4.0/3 == op.division(-4, 3));
		assertTrue(-4.0/3 == op.division(4, -3));
		assertTrue(4.0/3 == op.division(-4, -3));
	}

}
