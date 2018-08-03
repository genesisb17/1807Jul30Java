package com.iantimothyjohnson.homework.question10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question10Test {
	@Test
	public void testMin() {
		assertEquals(4, Question10.min(4, 5));
		assertEquals(-3, Question10.min(-1, -3));
		assertEquals(1, Question10.min(1, 1));
	}
}
