package com.iantimothyjohnson.homework.question18;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question18Test {
	private Question18 q18;

	@Before
	public void setUp() {
		q18 = new Question18();
	}

	@After
	public void tearDown() {
		q18 = null;
	}

	@Test
	public void testContainsUpperCase() {
		assertTrue(q18.containsUpperCase("hello, Ian"));
		assertFalse(q18.containsUpperCase("hi"));
		assertFalse(q18.containsUpperCase(""));
		assertFalse(q18.containsUpperCase("!@$#$"));
	}

	@Test
	public void testToUpperCase() {
		assertEquals("HELLO WORLD", q18.toUpperCase("hEllO wORld"));
		assertEquals("P0NCTU@TION", q18.toUpperCase("p0ncTU@TioN"));
	}

	@Test
	public void testAddTenAndOutput() {
		// Here, we need to redirect System.out to a local byte array that we
		// can read from, so that we can test the expected output.
		ByteArrayOutputStream consoleBytes = new ByteArrayOutputStream();
		PrintStream consoleOut = new PrintStream(consoleBytes);
		// We do want to save the old value of System.out so we can restore it
		// later, though.
		PrintStream oldOutput = System.out;
		System.setOut(consoleOut);

		q18.addTenAndOutput("10");
		assertEquals("20\n", consoleBytes.toString());
		// We need to reset our byte stream to get rid of the old output and try
		// another case.
		consoleBytes.reset();

		q18.addTenAndOutput("-5");
		assertEquals("5\n", consoleBytes.toString());

		// Make sure to restore the old System.out so any future usages work as
		// expected.
		System.setOut(oldOutput);
	}
}
