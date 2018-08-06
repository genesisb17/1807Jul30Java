package com.revature.q16;

public class QuestionSixteen {
	
	/**
	 * Takes in a string and prints out the character count of that string.
	 * @param str The string to be evaluated.
	 */
	public static void printCharCount(String str) {
		System.out.println("The character count for the String \"" + str + "\" is " + str.length() + ".");
	}
	
	/**
	 * Main method. Attempts to run the specified method with the first argument passed.
	 * If no argument was passed, catch exception and prints a message.
	 *  
	 * @param args An array of arguments passed in via the console. Only uses the first element.
	 */
	public static void main(String[] args) {
		try {
			printCharCount(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Just nothing...");
		}
	}

}
 