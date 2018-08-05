// Created by Darius Moomivand @ 04Aug18
package com.revature.hw;

public class revString {
	
	// Method to reverse string
	public static void rev(String s) {
		System.out.print("The reverse is: ");
		
		//For loop that prints out characters starting 
		//from the back of the string
		
		for(int i = s.length()-1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
	}

	public static void main(String[] args) {
		String string = "elephant";
		System.out.println("The string to reverse is: " + string + "\n");
		revString.rev(string);
		
	}

}
