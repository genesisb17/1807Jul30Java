package com.iantimothyjohnson.homework.question8;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a program that stores the following strings in an ArrayList and saves
 * all the palindromes in another ArrayList.
 * 
 * "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",
 * "refer", "billy", "did"
 * 
 * @author Ian Johnson
 *
 */
public class Question8 {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes",
				"jimmy", "kayak", "john", "refer", "billy", "did"));
		System.out.println("All words: " + words);

		// Create a new ArrayList with only the palindromes.
		ArrayList<String> palindromes = new ArrayList<>();
		for (String word : words) {
			if (isPalindrome(word)) {
				palindromes.add(word);
			}
		}
		System.out.println("Only palindromes: " + palindromes);
	}

	/**
	 * Determine whether the given string is a palindrome.
	 * 
	 * @param str The string to check.
	 * @return Whether the given string is a palindrome.
	 */
	public static boolean isPalindrome(String str) {
		// What we do here is check whether corresponding pairs of characters on
		// opposite ends of the string are equal (that is, treating the middle
		// of the string as a "mirror" and seeing if the "reflection" matches
		// what is on the other side). In a palindrome, all such pairs will be
		// equal, by definition. Note that we only need to run our index up to
		// str.length() - 1, since each iteration checks characters on both ends
		// (making the index run further would not be incorrect, but would be
		// redundant).
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				// We can exit early if we find a pair that doesn't match, since
				// we know it's not a palindrome.
				return false;
			}
		}
		// If we didn't find any non-matching pairs, then our string is a
		// palindrome.
		return true;
	}
}
