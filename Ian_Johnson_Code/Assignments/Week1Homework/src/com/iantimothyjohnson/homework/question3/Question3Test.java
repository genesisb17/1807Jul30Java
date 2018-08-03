package com.iantimothyjohnson.homework.question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question3Test {
	@Test
	public void testReverse() {
		assertEquals("!dlrow ,olleH", Question3.reverse("Hello, world!"));
	}

	@Test
	public void testReverseAlternate() {
		assertEquals("!dlrow ,olleH", Question3.reverseAlternate("Hello, world!"));
	}
}
