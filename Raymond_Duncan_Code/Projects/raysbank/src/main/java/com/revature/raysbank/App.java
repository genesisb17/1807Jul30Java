package com.revature.raysbank;

import java.util.Scanner;

import com.revature.dao.AccessDAO;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.TransactionDAO;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.NYIException;
import com.revature.pojos.AccountType;
import com.revature.service.AccountManager;

/**
 * Main application used to access the user accounts
 *
 */
public class App 
{
	static App app;
	private boolean running = true;
	
	static final Scanner scanner = new Scanner(System.in);
	static final AccessDAO accessDAO = new AccessDAO();
	static final BankAccountDAO bankAccountDAO = new BankAccountDAO();
	static final TransactionDAO transactionDAO = new TransactionDAO();
	
	//Current user objects
	private static AccountManager accountManager = null;
	private static boolean loggedIn = false;
	
    public static void main(String[] args )
    {
        app = new App();

        int option = 0;
        while(app.isRunning()) {
        	app.clearConsole();
        	option = app.loginMenu();
        	
        	switch(option) {
        	case 1:
        		System.out.print("Please enter your username:\n\t");
        		String username = scanner.nextLine();
        		System.out.print("Please enter your password:\n\t");
        		String password = scanner.nextLine();
        		loggedIn = accessDAO.login(username, password);
        		break;
        	case 2:
        	case 3:
        		System.out.println("Thanks for using RaysBank!\nUntil next time!");
        		app.end();
        	}
        	
        	if(loggedIn) {
        		//Logic for when the user has successfully logged in
        		app.mainMenu();
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
	
	public void mainMenu() {
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
	
	public void accessBankAccounts() throws NYIException {
		app.nyi();
	}
	
	public boolean createNewBankAccount() throws NYIException {
		app.nyi();
		return false;
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
				e.printStackTrace();
				System.out.println("That is an invalid selection. Please try again");
				option = 0;
			} catch (InvalidInputException e) {
				e.printStackTrace();
				System.out.println("That is an invalid selection. Please try again");
				option = 0;
			}
		}
		return option;
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
