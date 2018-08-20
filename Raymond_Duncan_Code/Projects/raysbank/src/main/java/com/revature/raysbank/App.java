package com.revature.raysbank;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccessDAO;
import com.revature.dao.AccountManagerDAO;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.TransactionDAO;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.NYIException;
import com.revature.pojos.AccountType;
import com.revature.pojos.BankAccount;
import com.revature.service.AccountManager;
import com.revature.service.NameTitle;

/**
 * Main application used to access the user accounts
 *
 */
public class App 
{
	static App app;
	private boolean running = true;
	static boolean prototype = false;
	
	static final Scanner scanner = new Scanner(System.in);
	static final AccessDAO accessDAO = new AccessDAO();
	static final BankAccountDAO bankAccountDAO = new BankAccountDAO();
	static final TransactionDAO transactionDAO = new TransactionDAO();
	static final AccountManagerDAO accountManagerDAO = new AccountManagerDAO();
	
	//Current user objects
	private static AccountManager accountManager = null;
	private static boolean loggedIn = false;
	
    public static void main(String[] args )
    {
        app = new App();

        int option = 0;
        while(app.isRunning()) {
//        	app.clearConsole();
        	if(prototype) option = app.loginMenuPrototype();
        	else option = app.loginMenu();
        	
        	switch(option) {
        	case 1:
        		accountManager = app.login();
        		if(accountManager != null) loggedIn = true;
        		else System.out.println("Invalid credentials. Returning to welcome screen.");
        		break;
        	case 2:
        		accountManager = app.createAccount();
        		if(accountManager != null) loggedIn = true;
        		else System.out.println("Invalid credentials. Returning to welcome screen");
        		break;
        	case 3:
        		System.out.println("Thanks for using RaysBank!\nUntil next time!");
        		app.end();
        	}
        	
        	if(loggedIn) {
        		//Logic for when the user has successfully logged in
        		if(prototype) app.mainMenuPrototype();
        		else app.mainMenu();
        	}
        }
    }

	public int loginMenu() {
    	System.out.println("============================   Hello! Welcome to RaysBank!   ============================\n"
    					 + "||  Please select an option                                                            ||\n"
    					 + "||   1) Login                                                                          ||\n"
    					 + "||   2) Create Account                                                                 ||\n"
    					 + "||   3) Exit                                                                           ||\n"
    					 + "=========================================================================================");
    	int option = app.selectOption(3);
    	return option;
    }
	
	public int loginMenuPrototype() {
    	System.out.println("======================   Hello! Welcome to RaysBank (Prototype)!   ======================\n"
    					 + "||  Please select an option                                                            ||\n"
    					 + "||   1) Login                                                                          ||\n"
    					 + "||   2) Create Account                                                                 ||\n"
    					 + "||   3) Exit                                                                           ||\n"
    					 + "=========================================================================================");
    	int option = app.selectOption(3);
    	return option;
    }
	
	public void mainMenuPrototype() {
		//Logic for when the user is logged in		
		while(loggedIn) {
			System.out.println("=====================================   Main Menu   =====================================\n"
					 		 + "||  Please select an option                                                            ||\n"
					 		 + "||   1) Access Bank Accounts                                                           ||\n"
					 		 + "||   2) Create New Account                                                             ||\n"
					 		 + "||   3) Link New Account                                                               ||\n"
					 		 + "||   4) Create New Certificate of Deposit                                              ||\n"
					 		 + "||   5) View Credit Information                                                        ||\n"
					 		 + "||   6) Apply for a Loan                                                               ||\n"
					 		 + "||   7) Logout                                                                         ||\n"
					 		 + "=========================================================================================");
			try {
				int option = app.selectOption(7);
				switch(option) {
				case 1:
					app.accessBankAccounts();
					break;
				case 2:
					app.createNewBankAccount();
					break;
				case 3:
					app.linkNewAccount();
					break;
				case 4:
					app.createNewCD();
					break;
				case 5:
					app.viewCreditInformation();
					break;
				case 6:
					app.loanApplication();
					break;
				case 7:
					app.logout();
				}
			} catch (NYIException e) {
				e.printStackTrace();
				System.out.println("Sorry, this feature has not yet been implemented. Please try again at a later date");
			}
		}
	}
	
	public void mainMenu() {
		//Logic for when the user is logged in		
		while(loggedIn) {
			System.out.println("=====================================   Main Menu   =====================================\n"
					 		 + "||  Please select an option                                                            ||\n"
					 		 + "||   1) Access Bank Accounts                                                           ||\n"
					 		 + "||   2) Create New Account                                                             ||\n"
					 		 + "||   3) Logout                                                                         ||\n"
					 		 + "=========================================================================================");
			int option = app.selectOption(3);
			switch(option) {
			case 1:
				app.accessBankAccounts();
				break;
			case 2:
				app.createNewBankAccount();
				break;
			case 3:
				app.logout();
			}
		}
	}
	
	public AccountManager login() {
		System.out.print("Please enter your username:\n\t");
		String username = scanner.nextLine();
		System.out.print("Please enter your password:\n\t");
		String password = scanner.nextLine();
		long uid = accessDAO.login(username.toLowerCase().trim(), password.trim());
		AccountManager am = accountManagerDAO.getOne(uid);
		return am;
	}
	
	public AccountManager createAccount() {
		long uid = -1L;
		do {
			System.out.print("Please enter your username:\n\t");
			String username = scanner.nextLine().trim();
			System.out.print("Please enter your password:\n\t");
			String password = scanner.nextLine().trim();
			uid = accessDAO.createAccount(username.toLowerCase().trim(), password.trim());
			if(uid < 0) System.out.println("That username is not unique. Please try again");
		} while(uid < 0);
		
		AccountManager am = null;
		System.out.println("Please enter your first name");
		String firstname = scanner.nextLine().trim();
		System.out.println("Please enter your lastname");
		String lastname = scanner.nextLine().trim();
		
		am = new AccountManager(uid,NameTitle.None,firstname,lastname);
		accountManagerDAO.save(am);
		return am;
	}
	
	public void accessBankAccounts() {
		//Use this to display bank accounts as well as to make withdrawals and deposits
		List<BankAccount> accounts = accountManager.getBankAccounts();
		if(accounts.size() < 1) {
			System.out.println("You need to create an account before you can enter this menu.");
			return;
		}
		boolean ret = false;
		do {
		System.out.println("===================================   Account  Menu   ===================================\n"
		 		 		 + "||  What would you like to do?                                                         ||\n"
		 		 		 + "||   1) Deposit funds                                                                  ||\n"
		 		 		 + "||   2) Withdraw funds                                                                 ||\n"
		 		 		 + "||   3) Return                                                                         ||\n"
		 		 		 + "=========================================================================================");
		int i = 0;
		for(BankAccount ba:accounts) {
			i++;
			System.out.println(i + ". " + ba.toString());
		}
		int accountIndex;
		int option = app.selectOption(3);
		switch(option) {
		case 1:
			double depositAmount = app.doubleInput("How much money would you like to deposit?");
			accountIndex = app.selectOption(accounts.size(), "Which account would you like to deposit the money into?") - 1;
			accountManager.depositMoney(accounts.get(accountIndex), depositAmount);
			break;
		case 2:
			double withdrawAmount = app.doubleInput("How much money would you like to withdraw?");
			accountIndex = app.selectOption(accounts.size(), "Which account would you like to withdraw the money from?");
			if(accountManager.withdrawMoney(accounts.get(accountIndex), withdrawAmount)) {
				System.out.println("Withdrawal successful! Here's your $" + withdrawAmount);
			} else System.out.println("You have insufficient funds in that account");
		case 3:
			ret = true;
		}
		} while(!ret);
		
	}
	
	public void createNewBankAccount() {
		//Things to create a new bank account: accountType, accountNumber, primaryUID, balance
		System.out.println("====================================   New Account   ====================================\n"
						 + "||  What type of account would you like to open                                        ||\n"
						 + "||   1) Checking                                                                       ||\n"
						 + "||   2) Saving                                                                         ||\n"
						 + "||   3) Return                                                                         ||\n"
						 + "=========================================================================================");
		int option = app.selectOption(3);
		AccountType accountType = null;
		boolean skip = false;
		switch(option) {
		case 1:
			accountType = AccountType.CHECKING;
			break;
		case 2:
			accountType = AccountType.SAVINGS;
			break;
		case 3:
			skip = true;
		}
		if(skip) return;
		
		double startingBalance = app.doubleInput("How much money would you like to open the account with?");
		
		accountManager.createNewAccount(accountType,startingBalance);
	}
	
	public boolean linkNewAccount() throws NYIException {
		app.nyi();
		return false;
	}
	
	public boolean createNewCD() throws NYIException {
		app.nyi();
		return false;
	}
	
	public boolean viewCreditInformation() throws NYIException {
		app.nyi();
		return false;
	}
	
	public boolean loanApplication() throws NYIException {
		app.nyi();
		return false;
	}
	
	public void logout() {
		loggedIn = false;
	}
	
	public int selectOption(int max) {
		int option = 0;
		while(option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
				if(option < 1 || option > max) throw new InvalidInputException();
			} catch (NumberFormatException e) {
//				e.printStackTrace();
				System.out.println("That is an invalid selection. Please try again");
				option = 0;
			} catch (InvalidInputException e) {
//				e.printStackTrace();
				System.out.println("That is an invalid selection. Please try again");
				option = 0;
			}
		}
		return option;
	}
	
	public int selectOption(int max, String phrase) {
		System.out.println(phrase);
		int option = 0;
		while(option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
				if(option < 1 || option > max) throw new InvalidInputException();
			} catch (NumberFormatException e) {
//				e.printStackTrace();
				System.out.println("That is an invalid selection. Please try again");
				option = 0;
			} catch (InvalidInputException e) {
//				e.printStackTrace();
				System.out.println("That is an invalid selection. Please try again");
				option = 0;
			}
		}
		return option;
	}
	
	public int intInput(String phrase) {
		System.out.println(phrase);
		int i = 0;
		boolean valid;
		do {
			valid = true;
			try {
				i = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("That input is invalid. Please try again");
				valid = false;
			}
		} while(!valid);
		return i;
	}
	
	public double doubleInput(String phrase) {
		System.out.println(phrase);
		double i = 0;
		boolean valid;
		do {
			valid = true;
			try {
				i = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("That input is invalid. Please try again");
				valid = false;
			}
		} while(!valid);
		return i;
	}
	
	public void nyi() throws NYIException {
		throw new NYIException();
	}
	
	public void clearConsole() {
		for(int i = 0; i < 20; i++) {
			System.out.println("\n");
		}
	}
	
	public boolean isRunning() {
		return running;
	}
    
    public void end() {
		running = false;		
	}
}
