package com.iantimothyjohnson.assignments.banking.app;

import java.io.EOFException;

import com.iantimothyjohnson.assignments.banking.dao.AccountDAO;
import com.iantimothyjohnson.assignments.banking.dao.UserDAO;
import com.iantimothyjohnson.assignments.banking.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.pojos.User;
import com.iantimothyjohnson.assignments.banking.service.SessionManager;
import com.iantimothyjohnson.assignments.banking.ui.AbstractTUI;
import com.iantimothyjohnson.assignments.banking.ui.StandardTUI;

public class Driver {
	/**
	 * The TUI to use to interact with the user.
	 */
	private static AbstractTUI tui;
	/**
	 * The session manager to use, which interacts with and abstracts the DAO.
	 */
	private static SessionManager sessionManager;
	/**
	 * The welcome message to show to the user when the program starts.
	 */
	private static final String WELCOME = "Welcome to ITJBank!\n" + "The bank's interface is textual and menu-driven. "
			+ "If you need any help understanding a prompt, just enter '?' (without the quotes) and further instructions will be provided.";

	// We wouldn't want anyone to actually construct one of these!
	private Driver() {
	}

	public static void main(String[] args) {
		// Set up the DAO and the session manager.
		sessionManager = new SessionManager(new UserDAO(new AccountDAO()));
		// Set up the TUI. In the future, we might try to detect terminal
		// features and provide a nicer interface where the user's terminal can
		// support it.
		tui = new StandardTUI();
		tui.printLine(WELCOME);
		// The program should just keep trying to log users in until one of them
		// enters EOF.
		try {
			while (true) {
				String option = tui.selectValue("Please select an option", "Log in", "Create account");
				switch (option) {
				case "Log in":
					login();
					break;
				case "Create account":
					System.err.println("Unimplemented!");
					break;
				}
			}
		} catch (EOFException ee) {
			tui.printLine("Goodbye!");
		}
	}

	/**
	 * Present the login menu.
	 */
	private static void login() throws EOFException {
		// Keep trying to log the user in until successful.
		while (true) {
			tui.print("Username: ");
			String username = tui.readLine();
			tui.print("Password: ");
			char[] password = tui.readPassword();

			// Now, let's try to actually log the user in.
			try {
				User user = sessionManager.login(username, password);
				userSession(user);
				sessionManager.logout(user);
			} catch (UserNotFoundException | AuthenticationFailureException e) {
				tui.printLine(e.getMessage());
			}
		}
	}

	/**
	 * Run a session for the given (logged-in) user.
	 * 
	 * @param user The user whose session to run.
	 */
	private static void userSession(User user) throws EOFException {
		// Get an array of account names so the user can pick one.
		String[] accountNames = user.getAccounts().stream().map(account -> account.getName()).toArray(String[]::new);
		int index = tui.select("Choose an account", accountNames);
		Account account = user.getAccounts().get(index);

		tui.printLine("Account " + account.getName() + " has $" + account.getBalance());
	}
}