package com.iantimothyjohnson.homework.question9;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question9Test {
	@Test
	public void testIsPrime() {
		assertTrue(Question9.isPrime(5));
		assertFalse(Question9.isPrime(0));
		assertFalse(Question9.isPrime(1));
		assertTrue(Question9.isPrime(17));
		assertTrue(Question9.isPrime(101));
		assertFalse(Question9.isPrime(404));
	}
}
