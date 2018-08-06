package cjh.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import cjh.question05.SubString;

public class Question05Test {
	/*
	 * Write a substring method that accepts a string str and an integer idx and returns the
	 * substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing
	 * substring methods in the String, StringBuilder, or StringBuffer APIs
	 */
	static String string = "abcdefghijklmnopqrstuvwxyz";
	
	@Test
	public void test() {
		for(int i = 0; i < 26; i++) {
			assertTrue(string.substring(0, i).equals(SubString.subString(string, i)));
		}
	}

}
