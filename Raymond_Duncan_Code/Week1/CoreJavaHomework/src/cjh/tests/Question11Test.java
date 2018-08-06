package cjh.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cjh.question11.AccessPackage;

public class Question11Test {
	/*
	 * Write a program that would access two float-variables from a class that exists in another package. Note, you will need 
	 * to create two packages to demonstrate the solution.
	 */

	@Test
	public void test() {
		assertTrue(Float.MIN_VALUE == AccessPackage.getMin());
		assertTrue(Float.MAX_VALUE == AccessPackage.getMax());
	}
	

}
