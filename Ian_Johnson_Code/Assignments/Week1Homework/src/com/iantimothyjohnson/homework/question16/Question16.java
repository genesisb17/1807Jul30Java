package com.iantimothyjohnson.homework.question16;

/**
 * Write a program to display the number of characters for a string input. The
 * string should be entered as a command line argument using (String [ ] args).
 * 
 * @author Ian Johnson
 */
public class Question16 {
	public static void main(String[] args) {
		// We should print out an error if the program is not invoked correctly
		// (we require precisely one argument).
		if (args.length != 1) {
			System.err.println("Usage: Question16 input");
			// It's conventional to exit with an error code when the program
			// terminates due to an error; in this case, the error is the user's
			// fault.
			System.exit(1);
		}

		// Now, we can just display the number of characters in the string. The
		// String.length() method is precisely what we want here.
		System.out.println("The string \"" + args[0] + "\" has " + args[0].length() + " characters.");
	}
}
