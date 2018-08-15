package driver;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import pojo.Account;
import pojo.Client;
import service.AccountService;
import service.ClientService;

public class Driver {
	static Scanner scan = new Scanner(System.in);
	static AccountService aService = new AccountService();
	static ClientService cService = new ClientService();

	static Client ca = new Client();

	public static void main(String[] args) {
		System.out.println("* * * * * Welcome to the Bank! * * * * * \n");
		loginPrompt();
	}

	public static void loginPrompt() {
		//clear the temp variable
		ca = new Client();
		System.out.println("* * * * * Please, login or create an account * * * * *\n"
				+ "1. Login\n" 
				+ "2. Create Account\n" 
				+ "3. Exit\n");
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
			System.exit(1);;
			break;
		}

	}
	//generating the screen users will see
	static void loginScreen() {
		//prompt for their name and password. save them into variables
		System.out.println("Enter Username:\n");
		String username = scan.nextLine();


		if(cService.findOne(username) != null) {
			
			System.out.println("Enter Password:\n");
			String password = scan.nextLine();
			
			ca = cService.findOne(username);
			if(ca.getPassword().equals(password)) {
				//ca = c;
				//send user to make account
				accountScreen();
				 
			} else {
				
				System.out.println("Incorrect Username or Password. Please, try again!\n");
				loginPrompt();
			}			
		} else {
			System.out.println("Incorrect Username or Password. Please, try again!\n");
			loginPrompt();
		}
		
	}

	static void accountScreen() {
		
		if (!aService.getAll().contains(null)) {
			
			LinkedList<Account> temp = new LinkedList<Account>();
			int counter = 5;
			int option = 0;
			System.out.println("* * * * * Your Accounts * * * * * *\n"
					+ "1. Create an Account\n" 
					+ "2. Remove an account\n"
					+ "3. Logout\n"
					+ "4. Exit\n"
					+ "* * * * * Or the number to an account * * * * *\n");
			
			List<Account> listAccounts = aService.getAll();
			
			for(Account a: listAccounts) {
				
				if(ca.getId() == a.getClientId()) {
					
					if(a.getAccountTypeId() == 1) {
						
						System.out.println(counter + ". Savings Account\n");
						a.setCounter(counter);
						temp.add(a);
						counter++;
						
					} else {
						System.out.println(counter + ". Checking Account\n");
						a.setCounter(counter);
						temp.add(a);
						counter++;
					}	

				}		
			}
			try {
				option = Integer.parseInt(scan.nextLine());
				if ((option <= 0) || (option > counter-1)) {
					System.out.println("Invalid input! Please, input number corresponding to the option.\n");
					accountScreen();
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Whoops! Invalid input! Please, input number corresponding to the account.\n");
				accountScreen();
			}
			if(option > counter) {
				System.out.println("Invalid input! Please, input number corresponding to the option");
				accountScreen();
			}
			
			else if(option == 1) {
				
				createAccount();
			}
			else if(option ==2) {
				
				System.out.println("Please, speak with your bank rep to remove an account");
				accountScreen();
			}
			else if(option == 3) {
				loginPrompt();
			}
			else if(option == 4) {
				System.exit(1);
			}
			else {
				
				for(Account a: temp) {
					if(a.getCounter() == option) {
						accountOptions(a);
						break;
					}
				}
			}
		} else {
			createAccount();
		}
			
	}

	static void accountOptions(Account a) {
		System.out.println("* * * * * Account Options * * * * * \n" 
				+ "1. Withdraw Funds\n"
				+ "2. Deposit Funds\n" 
				+ "3. Check Balance\n" 
				+ "4. Back to Accounts\n" 
				+ "5. Back to Login\n"
				+ "6. Exit\n");
		int option =0;

		try
		{
			option = Integer.parseInt(scan.nextLine());
			
		}
		catch(NumberFormatException e) {
			System.out.println("Please, enter the corresponding number to an option");
			accountOptions(a);
		}

		double amount = 0.0;
		switch(option)
		{
		case 1:
			System.out.println("Enter an amount\n");
			try {
				amount = Double.parseDouble(scan.nextLine());
				if(amount < 0) {
					System.out.println("Please, enter positive numbers only.");
					accountOptions(a);
				}
			} catch(NumberFormatException e) {
				System.out.println("Invalid Input.");
				accountOptions(a);
			}
			
			if (amount < a.getBalance()) {
				
				a.setBalance(a.getBalance()-amount);
				aService.update(a);
				System.out.println("Your Balance is: " + a.getBalance());
				
				accountOptions(a);
				
			} else if(amount > a.getBalance()) {
				
				System.out.println("You do not have enough funds");
				accountOptions(a);
				
			} 

			accountOptions(a);
			break;
			
		case 2: 
			System.out.println("Please, Enter an Amount\n");
			try {
				amount = Double.parseDouble(scan.nextLine());
				if(amount < 0) {
					System.out.println("Please, enter positive numbers only.");
					accountOptions(a);
				}
			} 
			catch(NumberFormatException e) {
				
				System.out.println("Invalid Input");
				accountOptions(a);
			}
			
			a.setBalance(a.getBalance() + amount);
			aService.update(a);
			System.out.println("Your Balance is: " + a.getBalance());
			
			accountOptions(a);
			break;
			
		case 3:
			
			System.out.println("Your Balance is: " + a.getBalance()+"\n");

			accountOptions(a);
			break;
		case 4:
			accountScreen();
			break;
		case 5:
			ca = null;
			loginPrompt();
			break;
		case 6:
			System.exit(1);
			break;
			
		default: 
			System.out.println("Invalid input! Please, input number corresponding to the option");
			accountOptions(a);
		}
		
	}

	static void createClient() {

		System.out.println("Please, enter your first name: \n");
		String firstName = scan.nextLine();
		ca.setFirstName(firstName);

		try {
			if(firstName.contains("*")) {
				throw new MyException();
			}
		} catch(MyException e) {
			System.out.println("You definitely are a star, but"
							+" do not use an * in your name, please!\n");
			createClient();
		}
		
		System.out.println("Please, enter your last name: \n");
		String lastName = scan.nextLine();
		ca.setLastName(lastName);

		System.out.println("Please, enter a username: \n");
		String username = scan.nextLine();
		
		//check if username exists and is unique
		while(username == null || !cService.isUsernameUnique(username) || username.isEmpty()) 
		{
			System.out.println("Please, enter a different username");
			username= scan.nextLine();
		}
		
		ca.setUsername(username);

		System.out.println("Please, enter a password: \n");
		String password = scan.nextLine();
		
		while(password == null || password.isEmpty()) 
		{
			System.out.println("Please, enter a password. Do not leave blank!\n");
			password= scan.nextLine();
		}		
		
		ca.setPassword(password);

		cService.save(ca);
		createAccount();
		
	}

	static void createAccount() {
		
		int option = 0;
		Account a = new Account();
		
		
		if (!aService.getAll().contains(null)) {
			
			System.out.println("Please, choose an account type:\n" 
					+ "1. Savings\n" 
					+ "2. Checking\n"
					+ "3. Logout\n");
			
			try {
				option = Integer.parseInt(scan.nextLine());
			} 
			catch(NumberFormatException e) {
				
				System.out.println("Whoops! Invalid input! Please, enter number of your "
						+ "desired account type. \n");
				createAccount();
			
			}
		} else {
			System.out.println("Please, choose an account type:\n" 
					+ "1. Savings\n" 
					+ "2. Checking\n"
					+ "3. Logout\n"
					+ "4. View Account Options\n");
			try {
				option = Integer.parseInt(scan.nextLine());
			} 
			catch(NumberFormatException e) {
				
				System.out.println("Whoops! Invalid input! Please, enter number of your "
						+ "desired account type. \n");
				createAccount();
			}
		}

		switch(option)
		{
		case 1:
	
			a.setAccountTypeId(option);
			a.setBalance(0.0);
			a.setClientId(ca.getId());
			System.out.println(ca.getId() + " account ");
			aService.save(a);
			System.out.println(a.getClientId() + "the client ID of the account we just created");
			System.out.println("Congratulations! You have a new savings account!\n");

			accountOptions(a);
			break;
		case 2:
			a.setAccountTypeId(option);
			a.setBalance(0.0);
			a.setClientId(ca.getId());
			aService.save(a);
			System.out.println("Congratulations! You have a new checking account!\n");

			accountOptions(a);
			break;
		case 3:
			loginPrompt();			
			break;
		case 4:
			accountOptions(a);
			break;			
		default:
			System.out.println("Please, enter one of the options provided\n");
			createAccount();
			break;			
		}
		a.setClientId(ca.getId());
		
		accountOptions(a);
		
	}

}
