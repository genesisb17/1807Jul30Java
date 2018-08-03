package com.iantimothyjohnson.homework.question4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question4Test {
	@Test
	public void testFactorial() {
		assertEquals(1, Question4.factorial(0));
		assertEquals(6, Question4.factorial(3));
		assertEquals(3628800, Question4.factorial(10));
	}
}
