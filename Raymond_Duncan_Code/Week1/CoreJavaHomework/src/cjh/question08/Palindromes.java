package cjh.question08;

import java.util.ArrayList;

public class Palindromes {
	
	
	public static boolean isPalindrome(String str) {
		/*
		 * Write a program that stores the following strings in an ArrayList and saves all the
		 * palindromes in another ArrayList.
		 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
		 */
		return (new StringBuffer(str)).reverse().toString().equals(str);
	}
	
	public static ArrayList<String> findPalindromes(ArrayList<String> lst){
		ArrayList<String> palindromes = new ArrayList<String>();
		for(String str:lst) {
			if(isPalindrome(str)) palindromes.add(str);
		}
		return palindromes;
	}

}
