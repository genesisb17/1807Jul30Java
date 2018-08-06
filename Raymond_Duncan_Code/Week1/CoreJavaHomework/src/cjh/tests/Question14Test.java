package cjh.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cjh.question14.DemonstratesSwitch;

public class Question14Test {
	/*
	 * Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
	 * Case 1: Find the square root of a number using the Math class method.
	 * Case 2: Display today’s date.
	 * Case 3: Split the following string and store it in a sting array.
	 * 		“I am learning Core Java”
	 * 
	 */

	@Test
	public void test() {
		assertTrue(DemonstratesSwitch.switcheroo(1));
		assertTrue(DemonstratesSwitch.switcheroo(2));
		assertTrue(DemonstratesSwitch.switcheroo(3));
	}

}
