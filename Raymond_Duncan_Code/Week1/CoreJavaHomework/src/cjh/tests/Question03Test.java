package cjh.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cjh.question03.StringReverse;

public class Question03Test {
	
	/*
	 * Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	 */

	@Test
	public void test() {
		String[] strings = {"longing","protest","size","coherent","trouble","sink","pale","miss","dirty","force","empty","violent"};
		for(String string:strings) {
			assertTrue((new StringBuffer(string)).reverse().toString().equals(StringReverse.reverseString(string)));
		}
	}

}
