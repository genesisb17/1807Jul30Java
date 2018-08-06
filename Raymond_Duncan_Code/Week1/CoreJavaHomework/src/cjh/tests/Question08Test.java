package cjh.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import cjh.question08.Palindromes;

public class Question08Test {
	/*
	 * Write a program that stores the following strings in an ArrayList and saves all the
	 * palindromes in another ArrayList.
	 * "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"
	 */

	@Test
	public void test() {
		//{"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"}
		ArrayList<String> strings = new ArrayList<String>(Arrays.asList(
				"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		ArrayList<String> palindromes = new ArrayList<String>(Arrays.asList("madam","civic","radar","sexes","kayak","refer","did"));
		
		assertEquals(palindromes, Palindromes.findPalindromes(strings));
	}

}
