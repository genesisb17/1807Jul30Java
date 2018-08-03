package com.iantimothyjohnson.homework.question5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question5Test {
	@Test
	public void testSubstring() {
		assertEquals("He", Question5.substring("Hello", 2));
		assertEquals("subst", Question5.substring("substring", 5));
		assertEquals("Hi", Question5.substring("Hi", 2));
		assertEquals("", Question5.substring("very long", 0));
	}
}
