package q08;

import java.util.ArrayList;

/*
 * Write a program that stores the following strings in an ArrayList and saves
 * all the palindromes in another ArrayList:
 * 
 * "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",
 * "refer", "billy", "did"
 */

public class Q8 {

	public static void main(String[] args) {
		ArrayList<String> regList = new ArrayList<String>();	// create ArrayLists
		ArrayList<String> palindromeList = new ArrayList<String>();
		ArrayList<String> fullList = new ArrayList<String>();
		
		fullList.add("karan");	// add elements
		fullList.add("madam");
		fullList.add("tom");
		fullList.add("civic");
		fullList.add("radar");
		fullList.add("sexes");
		fullList.add("jimmy");
		fullList.add("kayak");
		fullList.add("john");
		fullList.add("refer");
		fullList.add("billy");
		fullList.add("did");
		
		for (String element : fullList) {
			if (isPalindrome(element)) {	// if palindrome, add to palindrome list
				palindromeList.add(element);
			} else {						// else, add to regular list
				regList.add(element);
			}
		}
		
		System.out.println("Non-palindromes:");	// print non-palindromes
		for (String element : regList) {
			System.out.println(element);
		}
		
		System.out.println("");
		
		System.out.println("Palindromes:");		// print palindromes
		for (String element : palindromeList) {
			System.out.println(element);
		}
	}
	
	static boolean isPalindrome(String str) {
		StringBuilder str1 = new StringBuilder(str);
		StringBuilder str2 = new StringBuilder(str);
		str2.reverse();		// reverse of str
		return str1.toString().equals(str2.toString());	//convert back to string & compare
	}

}
