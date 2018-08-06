package cjh.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import cjh.question13.Triangles;
import junit.framework.TestCase;

public class Question13Test extends TestCase {
	/*
	 * Display the triangle on the console as follows using any type of loop. Do NOT use a simple group of print statements to accomplish this. 
	 * 0
	 * 1 0
	 * 1 0 1
	 * 0 1 0 1
	 * 
	 */
	
	@Test
	public void test() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String expected = 
				"0\n" +
				"1 0\n" +
				"1 0 1\n" +
				"0 1 0 1\n";
		Triangles.printTriangle(4);
		assertEquals(expected,outContent.toString());
	}

}
