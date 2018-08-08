package com.iantimothyjohnson.assignments.banking.ui;

/**
 * An abstract class that represents the basic functionality of a TUI (textual
 * user interface) for the banking app. It can be extended to provide different
 * styles, or to use more advanced features on terminals that support them.
 * 
 * @author Ian Johnson
 */
public abstract class AbstractTUI {
	/**
	 * Reads a line of input from the user.
	 * 
	 * @return The user's input, without the trailing newline. If the end of file
	 *         was reached before a line was input, this is null.
	 */
	public abstract String readLine();

	/**
	 * Reads a password from the user. On more advanced terminals, this may be done
	 * in a more secure manner than simply reading a string using readLine.
	 * 
	 * @return The user's input, without the trailing newline. If the end of file
	 *         was reached before a line was input, this is null.
	 */
	public char[] readPassword() {
		String password = readLine();
		return password == null ? null : password.toCharArray();
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
	 * Displays some text to the user and ends the line.
	 * 
	 * @param text The text to display.
	 */
	public void printLine(String text) {
		print(text + System.lineSeparator());
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
	 * Prompts the user to choose an item from a menu.
	 * 
	 * @param prompt    The prompt to display (e.g. "Choose an account"). It should
	 *                  not be terminated with a colon or any other punctuation.
	 * @param menuItems The items to display in the menu.
	 * @return The (0-based) index of the menu item that was selected. If nothing
	 *         was selected (e.g. if the user sends EOF to their terminal), this is
	 *         -1.
	 */
	public int select(String prompt, String... menuItems) {
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
			print(prompt + " (" + range + "): ");
			String input = readLine();
			// Check if we got EOF; if so, we return -1 as per the method
			// specification.
			if (input == null) {
				return -1;
			}
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
				printLine("Please enter a number.");
				continue;
			}
			int choice = 0;
			try {
				choice = Integer.parseInt(input);
			} catch (NumberFormatException nfe) {
				printLine("Invalid number.");
				continue;
			}
			if (choice < 1 || choice > menuItems.length) {
				printLine("You must enter an option number between 1 and " + menuItems.length + ".");
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
	 *                  not be terminated with a colon or any other puncutation.
	 * @param menuItems The items to display in the menu.
	 * @return The menu item that was selected. If nothing was selected (e.g. if the
	 *         user sends EOF to their terminal), this is null.
	 */
	public String selectValue(String prompt, String... menuItems) {
		int index = select(prompt, menuItems);
		return index < 0 ? null : menuItems[index];
	}
}
