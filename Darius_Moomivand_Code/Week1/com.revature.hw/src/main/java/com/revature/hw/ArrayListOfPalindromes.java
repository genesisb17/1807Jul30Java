// Created by Darius Moomivand @ 05Aug18
package com.revature.hw;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListOfPalindromes {
	
	// Iterates through an ArrayList and checks to see if the object is a palindrome
	// it adds it to a seperate list
	public static ArrayList sorter(ArrayList<String> x) {
		ArrayList<String> tempList = new ArrayList<String>();
		String one;			 
		String two;
		
		for(String word : x) {
			StringBuffer buffer = new StringBuffer(word);
			buffer.reverse();
			two = buffer.toString();
			one = (String) word;
			if(one.matches(two)) {
				tempList.add(one);
			}
		}		
		
		return tempList;
			
	}

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();

		list1.add("karan");
		list1.add("madam");
		list1.add("tom");
		list1.add("civic");
		list1.add("radar");
		list1.add("sexes");
		list1.add("jimmy");
		list1.add("kayak");
		list1.add("john");
		list1.add("refer");
		list1.add("billy");
		list1.add("did");
		
		System.out.println("This is an unfiltered list: \n" + list1);
		
		list2 = ArrayListOfPalindromes.sorter(list1);
		System.out.println("This list contains palindromes: \n" + list2);

	}

}
