package com.iantimothyjohnson.homework.question17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write a program that calculates the simple interest on the principal, rate of
 * interest and number of years provided by the user. Enter principal, rate and
 * time through the console using the Scanner class.
 * 
 * <pre>
 * Interest = Principal * Rate * Time
 * </pre>
 * 
 * @author Ian Johnson
 */
public class Question17 {
	public static void main(String[] args) {
		// Let's have a nice welcome message.
		System.out.println("Welcome to the simple interest calculator!");
		// As with question 14, we can use a BufferedReader to read in lines
		// from System.in.
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Double principal = promptNonNegativeDouble(br, "Please enter the principal, in dollars:");
			Double rate = promptNonNegativeDouble(br, "Please enter the rate, per year:");
			Double time = promptNonNegativeDouble(br, "Please enter the amount of time, in years:");
		} catch (IOException e) {
			System.err.println("A problem occurred when reading from the console:");
			e.printStackTrace();
		}
	}

	/**
	 * Prompt the user to input a non-negative decimal number. The user will be
	 * prompted continuously using the same prompt until a valid number has been
	 * provided.
	 * 
	 * @param br     The BufferedReader from which to read the number.
	 * @param prompt The prompt to display to the user. A trailing space will be
	 *               provided for appearance's sake.
	 * @return The number that the user input, or null if end-of-file was
	 *         encountered.
	 * @throws IOException If there is an error in reading.
	 */
	private static Double promptNonNegativeDouble(BufferedReader br, String prompt) throws IOException {
		// We need to initialize num because Java doesn't know that it will
		// always be initialized before the loop below exits.
		double num = 0.0;
		boolean gotNum = false;

		// We can use a loop to continuously ask for input until a valid
		// value is given. The gotNum variable will be used to mark
		// when valid input has been provided, so that we can exit the loop.
		while (!gotNum) {
			System.out.print(prompt + " ");
			// We trim leading and trailing whitespace from the input so
			// that the double parser doesn't get confused (it is very
			// strict in what it accepts).
			String input = br.readLine().trim();
			if (input == null) {
				// We return null if we reach end-of-file, as per the
				// documentation on the method.
				return null;
			}
			try {
				num = Double.parseDouble(input);
			} catch (NumberFormatException e) {
				System.out.println("Not a valid number.");
				continue;
			}
			if (num < 0.0) {
				System.out.println("Please enter a non-negative number.");
			} else {
				gotNum = true;
			}
		}

		return num;
	}
}
