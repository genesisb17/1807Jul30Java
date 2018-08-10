package driver;
import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;

import pojo.Account;
import pojo.Client;
import service.AccountService;
import service.AccountTypeService;
import service.ClientAccountService;
import service.ClientService;


public class Driver {
	static Scanner scan = new Scanner(System.in);
	static AccountService aService = new AccountService();
	static AccountTypeService atService = new AccountTypeService();
	static ClientAccountService caService = new ClientAccountService();
	static ClientService cService = new ClientService();
	

	public static void main(String[] args) {
		System.out.println("Welcome to the Bank!\n");
		loginPrompt();
	}
	
	public static void loginPrompt() {
		System.out.println("Please, login or create an account\n"+
							"1. Login\n" + "2. Create Account\n" + "3. Test\n");
		int option = 0;
		
		try
		{
			option = Integer.parseInt(scan.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type an option's corresponding number");
			loginScreen();
		}
		
		switch(option)
		{
		case 1:
			loginScreen();
			break;
		case 2: 
			createClient();
			break;
		case 3:
			cService.getAll();
			break;
			
		}
	
	}
	
	static void loginScreen() {
		System.out.println("Enter Username:\n");
		String username = scan.nextLine();
		
		System.out.println("Enter Password:\n");
		String password = scan.nextLine();
		
		Client c = cService.findOne(username);
		System.out.println(c.getUsername());
		if(c.getPassword().equals(password)) {
			accountScreen();
		} else {
			System.out.println("Whoops! Incorrect Username or Password");
		}
	}
	
	static void accountScreen() {
		System.out.println("Your Accounts\n");
		
		//TODO 
	}
	
	static void accountOptions() {
		System.out.println("Account Options\n" + "1. Withdraw Funds\n"
							+ "2. Deposit Funds\n" + "Check Balance");
		int option =0;
		
		try
		{
			option = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Please, enter the corresponding number to an option");
			accountOptions();
		}
		
		double amount = 0;
		switch(option)
		{
		case 1:
			System.out.println("Enter an amount\n");
			try {
				amount = Double.parseDouble(scan.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Invalid Input");
				accountOptions();
			}
			//add to remove from account
			break;
		case 2: 
			System.out.println("Enter an amount\n");
			try {
				amount = Double.parseDouble(scan.nextLine());
			} 
			catch(NumberFormatException e) {
				System.out.println("Invalid Input");
				accountOptions();
			}
			//add to add to account
			break;
		case 3:
			System.out.println("This should print your balance");
			accountOptions();
			break;
			
		}
	}
	
	static void createClient() {
		Client c = new Client();
		
		System.out.println("Please, enter your first name: \n");
		String firstName = scan.nextLine();
		c.setFirstName(firstName);
		
		System.out.println("Please, enter your last name: \n");
		String lastName = scan.nextLine();
		c.setLastName(lastName);
		
		System.out.println("Please, enter a username: \n");
		String username = scan.nextLine();
		c.setUsername(username);
		
		System.out.println("Please, enter a password to access your accounts: \n");
		String password = scan.nextLine();
		c.setPassword(password);
		
		//Client cc = new Client(firstName,lastName,username,password);
		cService.save(c);
	}
	
	static void createAccount() {
		System.out.println("Please, choose an account type:\n" 
							+ "1. Savings\n" + "2. Checking\n");
		int option = 0;
		
		try {
			option = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Whoops! Invalid input! Please, enter number of your "
					+ "desired account type. \n");
			createAccount();
		}
		
		String accountType;
		switch(option)
		{
		case 1:
			accountType = "Savings";
			System.out.println("Congratulations! You have a new savings account!");
			break;
		case 2:
			accountType = "Checking";
			System.out.println("Congratulations! You have a new checking account!");
			break;
		}
	}
	
}
