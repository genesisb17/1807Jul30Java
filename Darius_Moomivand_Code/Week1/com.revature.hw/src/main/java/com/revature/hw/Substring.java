// Created by Darius Moomivand @ 04Aug 18
package com.revature.hw;

public class Substring {
	// Method used to find a substring of a string
	//given an start and end index.
	public static void sub(String s, int first, int last) {
		System.out.print("The substring is: ");
		for(int i = first; i < last+1; i++) {
			System.out.print(s.charAt(i));
		}
	}

	public static void main(String[] args) {
		String string = "FuffyPillow";
		int one = 0;
		int two = 4;
		System.out.println("The original string is: " + string);
		Substring.sub(string, one, two);
	}

}
