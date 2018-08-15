package com.bank.main;

import java.util.List;
import java.util.Scanner;

import com.bank.pojos.BankAccount;
import com.bank.pojos.BankUser;
import com.bank.service.BankAccountService;
import com.bank.service.BankUserService;
import com.bank.util.InvalidUserInfoException;

public class Driver {

	static Scanner scanner = new Scanner(System.in);
	static BankUserService userServ = new BankUserService();
	static BankAccountService accountServ = new BankAccountService();

	public static void main(String[] args) {
		System.out.println("Welcome to the WAT Bank, where We Always Try!\nWhat do you want to today?");
		menu();
	}

	static void menu() {
		System.out.print("-------------------- Main Menu --------------------\n" + "1. Log In\n" + "2. Create Account\n"
				+ "Please select an option: ");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid option choice. Please enter a number.\n");
			menu();
		}
		try {
			switch (option) {
			case 1:
				BankUser sessionUser = login();
				bankAccountAccess(sessionUser);
				break;
			case 2:
				newUser();
				break;
			default:
				System.out.println("Choose a correct choice.\n");
				menu();
			}
		} catch (InvalidUserInfoException e) {
			System.out.println("User Registration/Login canceled. Inputs invalid.\n");
			menu();
		}

	}

	static void bankAccountAccess(BankUser sessionUser) {
		System.out.println("-------------------- Secure* Menu --------------------\n" + "1. Display all accounts\n"
				+ "2. Create a new account\n" + "3. Log Out\n" + "Pick an option:");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid option. Please enter a number.");
			bankAccountAccess(sessionUser);
		}

		switch (option) {
		case 1:
			if (showAllAccounts(sessionUser.getId())) {
				transaction(sessionUser.getId());
			} else {
				bankAccountAccess(sessionUser);
			}
			break;
		case 2:
			createBankAccount(sessionUser.getId());
			break;
		case 3:
			System.out.println("Logged out!\n");
			menu();
		}
	}

	static void transaction(int id) {
		System.out.println("-------------------- Transaction --------------------\n" + "1. Withdraw\n" + "2. Deposit\n"
				+ "3. Logout\n" + "Pick an option:");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid choice. Please enter a number.\n");
			transaction(id);
		}

		switch (option) {
		case 1:
			withdraw(id);
			break;
		case 2:
			deposit(id);
			break;
		case 3:
			System.out.println("Logged out!\n");
			menu();
		}
	}

	static void withdraw(int id) {
		System.out.println("-------------------- Withdraw --------------------");
		showAllAccounts(id);
		System.out.print("Select the account to withdraw from: ");

		List<BankAccount> accounts = accountServ.listAccounts(id);

		int accountIndex = 0;
		try {
			accountIndex = Integer.parseInt(scanner.nextLine()) - 1;
		} catch (NumberFormatException e) {
			System.out.println("Invalid option choice. Please enter a number.\n");
			withdraw(id);
		}

		int accID = 0;
		try {
			accID = accounts.get(accountIndex).getAccountNumber();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid choice. Please choose again.\n");
			withdraw(id);
		}

		double amount = 0.0;
		System.out.println("Enter withdraw amount: ");
		try {
			amount = Double.parseDouble(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Bad amount input.\n");
			withdraw(id);
		}
		BankAccount temp = accountServ.getAccount(accID);

		if (amount > temp.getBalance()) {
			System.out.println("Withdraw amount exceeds balance.\n");
			withdraw(id);
		}

		BankAccount updated = new BankAccount(temp.getAccountNumber(), temp.getAccountType(),
				temp.getBalance() - amount, temp.getUserid());

		accountServ.updateAccount(updated);

		System.out.println("Success! Balance is now $" + updated.getBalance() + ". \n");
		transaction(id);
	}

	static void deposit(int id) {
		System.out.println("-------------------- Deposit --------------------");
		showAllAccounts(id);
		System.out.print("Select the account to deposit into: ");

		List<BankAccount> accounts = accountServ.listAccounts(id);
		int accountIndex = 0;
		try {
			accountIndex = Integer.parseInt(scanner.nextLine()) - 1;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a number.\n");
			deposit(id);
		}

		int accID = 0;
		try {
			accID = accounts.get(accountIndex).getAccountNumber();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid choice. Please choose again.\n");
			deposit(id);
		}

		double amount = 0.0;
		;
		System.out.println("Enter deposit amount: ");
		try {
			amount = Double.parseDouble(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Bad amount input. Please re-enter a number. Restting prompt.\n");
			deposit(id);
		}
		BankAccount temp = accountServ.getAccount(accID);

		BankAccount updated = new BankAccount(temp.getAccountNumber(), temp.getAccountType(),
				(temp.getBalance() + amount), temp.getUserid());

		accountServ.updateAccount(updated);

		System.out.println("Success! Balance is now $" + updated.getBalance() + ".\n");
		transaction(id);
	}

	static BankUser login() throws InvalidUserInfoException {
		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		if (username.matches("\\W")) {
			throw new InvalidUserInfoException();
		}

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		List<BankUser> users = userServ.getUsers();
		boolean exists = false;
		for (BankUser u : users) {
			if (u.getUsername().equalsIgnoreCase(username)) {
				exists = true;
				if (u.getPassword().equals(password)) {
					System.out.println("Current User: " + u.getFirstName() + " " + u.getLastName() + ".");
					return u;
				} else {
					System.out.println("Bad Login attempt. Please try again.");
					menu();
					break;
				}
			}
		}
		if (!exists) {
			System.out.println("Bad Login attempt. Try Again.");
			menu();
		}
		return null;
	}

	static void newUser() throws InvalidUserInfoException {
		System.out.print("Enter your first name: ");
		String firstname = scanner.nextLine();
		System.out.print("Enter your last name: ");
		String lastname = scanner.nextLine();
		System.out.print("Enter your username: ");
		String username = scanner.nextLine();

		if (firstname.matches("\\W") && lastname.matches("\\W") && username.matches("\\W")) {

			throw new InvalidUserInfoException();
		}

		System.out.print("Enter your password: ");
		String password = scanner.nextLine();

		BankUser newUser = new BankUser(firstname, lastname, username, password);

		List<BankUser> users = userServ.getUsers();
		boolean exists = false;
		for (BankUser u : users) {
			if (u.getUsername().equalsIgnoreCase(username)) {
				exists = true;
				break;
			}
		}

		if (!exists) {
			userServ.addUser(newUser);
			System.out.println("SUCCESS. Please log in to setup new bank accounts.\n");
		} else {
			System.out.println("Username is taken. Please try again.\n");
		}
		menu();
	}

	static boolean showAllAccounts(int id) {
		List<BankAccount> accounts = accountServ.listAccounts(id);
		if (accounts.size() != 0) {
			System.out.println("Current Accounts");
			for (int i = 0; i < accounts.size(); i++) {
				System.out.println((i + 1) + ". " + accounts.get(i).getAccountType() + " account contains $"
						+ accounts.get(i).getBalance());
			}
		} else {
			System.out.println("No accounts on record.\n");
			return false;
		}
		return true;
	}

	static void createBankAccount(int userID) {
		System.out.println("Please enter the type of account to create.\n");
		String type = scanner.nextLine();

		BankAccount newAccount = new BankAccount(type, 0, userID);
		boolean exists = false;

		List<BankAccount> accounts = accountServ.listAccounts(userID);
		for (BankAccount a : accounts) {
			if (a.getAccountType().equalsIgnoreCase(type)) {
				exists = true;
				break;
			}
		}

		if (!exists) {
			accountServ.addAccount(newAccount);
			System.out.println("SUCCESS! Account created.\n");
		} else {
			System.out.println("Sorry! Account already exists.\n");
		}
		bankAccountAccess(userServ.getUser(userID));
	}
}