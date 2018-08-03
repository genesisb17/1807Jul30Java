package com.iantimothyjohnson.homework.question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question2Test {
	@Test
	public void testFibonacci() {
		assertEquals(5, Question2.fibonacci(5));
		assertEquals(0, Question2.fibonacci(0));
		assertEquals(13, Question2.fibonacci(7));
	}
}
