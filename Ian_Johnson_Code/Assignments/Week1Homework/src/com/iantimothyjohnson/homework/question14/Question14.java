package com.iantimothyjohnson.homework.question14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

/**
 * Write a program that demonstrates the switch case. Implement the following
 * functionalities in the cases:
 * 
 * <ol>
 * <li>Find the square root of a number using the Math class method.</li>
 * <li>Display today’s date.</li>
 * <li>Split the following string and store it in a string array: "I am learning
 * Core Java".</li>
 * </ol>
 * 
 * @author Ian Johnson
 */
public class Question14 {
	/**
	 * The usage directions for the "interpreter".
	 */
	public static final String USAGE = "Available commands:\n" + "sqrt <n>          Compute the square root of n.\n"
			+ "date              Display today's date.\n"
			+ "str_array         Output a string split into its individual words.\n"
			+ "quit              Exit the command shell.\n";
	/**
	 * The prompt to display to the user for input.
	 */
	public static final String PS1 = "> ";

	public static void main(String[] args) {
		// Output the directions.
		System.out.println(
				"Welcome to the example shell! This is just like your normal shell, but it only does three things.");
		System.out.println(USAGE);

		// We'll use a BufferedReader to get input from the user. An alternative
		// would be to use a Scanner.
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line;
			System.out.print(PS1);
			while ((line = br.readLine()) != null) {
				// Get rid of surrounding whitespace.
				line = line.trim();
				// Split the line into the command and arguments (split around
				// whitespace; the regex \s+ matches one or more whitespace
				// characters).
				String[] splitLine = line.split("\\s+");
				// Ignore empty lines.
				if (splitLine.length == 0) {
					continue;
				}
				// For cleanliness, we delegate the actual execution to another
				// function.
				if (execCommand(splitLine[0], Arrays.copyOfRange(splitLine, 1, splitLine.length))) {
					break;
				}

				// Output the prompt for the next iteration.
				System.out.print(PS1);
			}
		} catch (IOException e) {
			System.err.println("A problem occurred when reading from the console:");
			e.printStackTrace();
		}
	}

	/**
	 * Executes the given command with the given arguments.
	 * 
	 * @param command The command to execute.
	 * @param args    The arguments to the command.
	 * @return Whether the interpreter should exit (that is, whether the quit
	 *         command was executed).
	 */
	private static boolean execCommand(String command, String[] args) {
		// Yay, you can switch on Strings!
		switch (command) {
		case "sqrt":
			if (args.length != 1) {
				System.out.println("Expected 1 argument to sqrt, got " + args.length + ".");
				break;
			}

			double n; // The number to take the sqrt of.
			try {
				n = Double.parseDouble(args[0]);
			} catch (NumberFormatException e) {
				System.out.println(args[0] + " is not a valid number." + ".");
				break;
			}
			// I'm not going to check to see if n >= 0; NaN will be output if it
			// is not.
			System.out.println(Math.sqrt(n));
			break;
		case "date":
			if (args.length != 0) {
				System.out.println("Expected 0 arguments to date, got " + args.length + ".");
				break;
			}

			// Get the current date.
			Date date = new Date();
			System.out.println(date);
			break;
		case "str_array":
			if (args.length != 0) {
				System.out.println("Expected 0 arguments to str_array, got " + args.length + ".");
				break;
			}

			String str = "I am learning Core Java";
			// Recall the \s+ regex from above that matches all groups of
			// whitespace, so that the string above is split into its words.
			System.out.println(Arrays.toString(str.split("\\s+")));
			break;
		case "quit":
			if (args.length != 0) {
				System.out.println("Expected 0 arguments to quit, got " + args.length + ".");
				break;
			}
			System.out.println("Goodbye!");
			return true;
		}
		return false;
	}
}
