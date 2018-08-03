package com.iantimothyjohnson.homework.question6;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question6Test {
	@Test
	public void testIsEven() {
		assertTrue(Question6.isEven(2));
		assertFalse(Question6.isEven(3));
		assertFalse(Question6.isEven(-1));
		assertTrue(Question6.isEven(-16));
		assertTrue(Question6.isEven(0));
	}
}
