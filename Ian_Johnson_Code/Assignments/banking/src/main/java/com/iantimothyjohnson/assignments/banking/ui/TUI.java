package com.iantimothyjohnson.assignments.banking.ui;

import java.io.EOFException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Arrays;

import com.iantimothyjohnson.assignments.banking.util.StringUtils;

/**
 * An abstract class that represents the basic functionality of a TUI (textual
 * user interface) for the banking app. It can be extended to provide different
 * styles, or to use more advanced features on terminals that support them.
 * 
 * The concrete implementations for the various methods in this class build on
 * each other in a natural way, allowing subclasses to specify new behavior by
 * overriding only a few methods. For example, coloring prompt strings could be
 * accomplished by overriding the printPrompt method, which is called by all the
 * prompt methods.
 * 
 * @author Ian Johnson
 */
public abstract class TUI {
	/**
	 * Reads a line of input from the user.
	 * 
	 * @return The user's input, without the trailing newline.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      line.
	 */
	public abstract String readLine() throws EOFException;

	/**
	 * Reads a password from the user. On more advanced terminals, this may be done
	 * in a more secure manner than simply reading a string using readLine.
	 * 
	 * @return The user's input, without the trailing newline.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      line.
	 */
	public char[] readPassword() throws EOFException {
		return readLine().toCharArray();
	}

	/**
	 * Displays some text to the user, without ending the current line. The output
	 * must always be sent directly to the user's terminal; there should be no
	 * buffering.
	 * 
	 * @param text The text to display.
	 */
	public abstract void print(String text);

	/**
	 * Displays an error message to the user.
	 * 
	 * @param text The text of the error. The text will be given a trailing newline.
	 */
	public void printError(String text) {
		printLine(text);
	}

	/**
	 * Displays some text to the user, formatted as a header.
	 * 
	 * @param text The text to display. The text will be given a trailing newline.
	 */
	public void printHeader(String text) {
		printLine(text);
	}

	/**
	 * Displays some text to the user and ends the line.
	 * 
	 * @param text The text to display. The text will be word-wrapped to 80
	 *             characters before printing to ensure that long lines are not
	 *             ugly.
	 */
	public void printLine(String text) {
		print(StringUtils.wordWrap(text, 80) + System.lineSeparator());
	}

	/**
	 * Prints out a numbered list consisting of the given items.
	 * 
	 * @param items The items that make up the list.
	 */
	public void printNumberedList(String... items) {
		for (int i = 0; i < items.length; i++) {
			printLine((i + 1) + ". " + items[i]);
		}
	}

	/**
	 * Displays a prompt to the user, without ending the current line. This method
	 * is present to allow implementations to style their prompts differently than
	 * other output.
	 * 
	 * @param text The prompt text to display.
	 */
	public void printPrompt(String text) {
		print(text);
	}

	/**
	 * Displays a line of text indicating a success condition.
	 * 
	 * @param text The text to be displayed. The text will be given a trailing
	 *             newline.
	 */
	public void printSuccess(String text) {
		printLine(text);
	}

	/**
	 * Prompts the user to enter a dollar amount. The user will be continually
	 * prompted until a valid number is input.
	 * 
	 * The input format is flexible, and will accept numbers with or without a
	 * leading dollar sign as well as commas within the number as thousands
	 * separators.
	 * 
	 * @param prompt The prompt to display to the user (e.g. "Withdrawal amount").
	 *               It should not be terminated with any punctuation or spaces.
	 * @return The number input by the user.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      number.
	 */
	public BigDecimal promptDollarAmount(String prompt) throws EOFException {
		while (true) {
			String numberString = promptNonEmptyLine(prompt);
			// Get rid of unnecessary but allowable characters in the input.
			try {
				BigDecimal result = parseDollarString(numberString);
				if (result.compareTo(BigDecimal.ZERO) < 0) {
					printError("Please enter a non-negative amount.");
				} else {
					return result;
				}
			} catch (NumberFormatException nfe) {
				printError("Please enter a valid monetary amount (no fractional cents).");
			}
		}
	}

	/**
	 * Prompts the user to enter a line of text.
	 * 
	 * @param prompt The prompt to display to the user (e.g. "Username"). It should
	 *               not be terminated with any punctuation or spaces.
	 * @return The line that was input by the user, trimmed of any leading and
	 *         trailing whitespace.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      line.
	 */
	public String promptLine(String prompt) throws EOFException {
		printPrompt(prompt + ": ");
		return readLine().trim();
	}

	/**
	 * Prompts the user to enter a non-empty line of text (not including leading and
	 * trailing whitespace). The user will be prompted continually until a non-empty
	 * line is input.
	 * 
	 * @param prompt The prompt to display to the user (e.g. "Username"). It should
	 *               not be terminated with any punctuation or spaces.
	 * @return The line that was input by the user, trimmed of any leading and
	 *         trailing whitespace.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      line.
	 */
	public String promptNonEmptyLine(String prompt) throws EOFException {
		while (true) {
			String line = promptLine(prompt);
			if (!line.isEmpty()) {
				return line;
			}
		}
	}

	/**
	 * Prompts the user to enter a password. The password must be non-empty, so the
	 * user will be prompted continually until something is entered.
	 * 
	 * @param prompt The prompt to display to the user (e.g. "Password"). It should
	 *               not be terminated with any punctuation or spaces.
	 * @return The password that was input by the user.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      line.
	 */
	public char[] promptPassword(String prompt) throws EOFException {
		while (true) {
			printPrompt(prompt + ": ");
			char[] password = readPassword();
			if (password.length > 0) {
				return password;
			}
		}
	}

	/**
	 * Prompts the user to enter a password and then once more to confirm it. The
	 * prompts will repeat until the user successfully enters the same password
	 * twice.
	 * 
	 * @param prompt The prompt to display to the user (e.g. "Password"). It should
	 *               not be terminated with any punctuation or spaces.
	 * @return The password that was input by the user.
	 * @throws EOFException If the user sent EOF to the terminal without
	 *                      successfully entering a password.
	 */
	public char[] promptPasswordWithConfirmation(String prompt) throws EOFException {
		while (true) {
			char[] password = promptPassword(prompt);
			char[] confirm = promptPassword(prompt + " (confirm)");
			if (Arrays.equals(password, confirm)) {
				return password;
			} else {
				printError("Given passwords do not match. Please try again.");
			}
		}
	}

	/**
	 * Prompts the user to enter either "yes" or "no" (case-insensitive). The user
	 * will be prompted until one of these two options is input.
	 * 
	 * @param prompt The prompt to display to the user (e.g. "Would you like to
	 *               exit"). It should not be terminated with any punctuation or
	 *               spaces; input hints and a question mark will be provided.
	 * @return If the user input "yes", then true; if "no", then false.
	 * @throws EOFException If the user sent EOF to the terminal without providing
	 *                      an answer.
	 */
	public boolean promptYesOrNo(String prompt) throws EOFException {
		// The loop will continue prompting the user until a valid input is
		// given.
		while (true) {
			printPrompt(prompt + " (yes/no)? ");
			switch (readLine().toLowerCase()) {
			case "yes":
				return true;
			case "no":
				return false;
			}
			printError("Please enter yes or no.");
		}
	}

	/**
	 * Prompts the user to choose an item from a menu.
	 * 
	 * @param prompt    The prompt to display (e.g. "Choose an account"). It should
	 *                  not be terminated with a colon or any other punctuation.
	 * @param menuItems The items to display in the menu.
	 * @return The (0-based) index of the menu item that was selected.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      line.
	 */
	public int select(String prompt, String... menuItems) throws EOFException {
		if (menuItems.length == 0) {
			throw new IllegalArgumentException("Must provide at least one menu item to display a menu.");
		}
		// By default, we have to assume that the only thing we can do is read
		// and write text, so there is no advanced interaction.
		printNumberedList(menuItems);

		// We will keep asking for a choice until one is provided.
		while (true) {
			// We format the range string and add a special case when there is
			// only one element (which looks nicer than '(1-1)').
			String range = menuItems.length == 1 ? "1" : "1-" + menuItems.length;
			printPrompt(prompt + " (" + range + "): ");
			String input = readLine();
			// Trim whitespace, so that the user can input " 1 " and it will be
			// understood.
			input = input.trim();

			// We accept "?" as a request for help.
			if (input.equals("?")) {
				printLine("Please select a menu item by entering the corresponding number. "
						+ "The menu items are as follows:");
				printNumberedList(menuItems);
				continue;
			}

			// Try to parse the input.
			if (input.isEmpty()) {
				printError("Please enter a number.");
				continue;
			}
			int choice = 0;
			try {
				choice = Integer.parseInt(input);
			} catch (NumberFormatException nfe) {
				printError("Invalid number.");
				continue;
			}
			if (choice < 1 || choice > menuItems.length) {
				printError("You must enter an option number between 1 and " + menuItems.length + ".");
				continue;
			}

			// If we got this far, we got a valid choice and we can return.
			return choice - 1;
		}
	}

	/**
	 * Prompts the user to choose an item from a menu.
	 * 
	 * @param prompt    The prompt to display (e.g. "Choose an account"). It should
	 *                  not be terminated with a colon or any other punctuation.
	 * @param menuItems The items to display in the menu.
	 * @return The menu item that was selected.
	 * @throws EOFException If the user sent EOF to the terminal without entering a
	 *                      line.
	 */
	public String selectValue(String prompt, String... menuItems) throws EOFException {
		int index = select(prompt, menuItems);
		return menuItems[index];
	}

	/**
	 * Parses a dollar input string by stripping unnecessary but allowable
	 * characters and then converting it to a BigInteger. Currently, these
	 * characters are a leading dollar sign and commas as separators before the
	 * decimal point.
	 * 
	 * @param input The input to normalize.
	 * @return The normalized input.
	 * @throws NumberFormatException If the given input, after stripping unnecessary
	 *                               characters, is not a valid decimal number.
	 */
	protected BigDecimal parseDollarString(String input) {
		if (input.charAt(0) == '$') {
			input = input.substring(1).trim();
		}
		DecimalFormat format = new DecimalFormat("#,##0.00");
		format.setParseBigDecimal(true);
		// The parse method of a DecimalFormat takes a String input as well as a
		// ParsePosition; the ParsePosition is updated to point to the character
		// after the last character parsed during the method. Since we want the
		// entire string to match the format, we check to make sure it is past
		// the end of the string before returning the result.
		ParsePosition pos = new ParsePosition(0);
		BigDecimal parsed = (BigDecimal) format.parse(input, pos);
		if (parsed == null || pos.getIndex() != input.length() || parsed.scale() > 2) {
			// The reason why we throw a NumberFormatException when the scale is
			// greater than 2 is because we don't want the user to be able to
			// make transactions involving fractions of a cent.
			throw new NumberFormatException();
		}
		return parsed;
	}
}
