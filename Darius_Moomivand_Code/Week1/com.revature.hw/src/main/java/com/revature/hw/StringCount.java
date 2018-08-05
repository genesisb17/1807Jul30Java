//Created by Darius Moomivand @ 05Aug18
package com.revature.hw;

public class StringCount {
	public static int counter;
	
	// Method that takes a string and finds out how many characters it has
	public static void count(String input) {
		for(int i = 0; i < input.length(); i++) {
			counter++;
		}
		System.out.println(counter);
	}
	
	public static void main(String[] args) {
		StringCount.count(args[0]);
		
	}

}
