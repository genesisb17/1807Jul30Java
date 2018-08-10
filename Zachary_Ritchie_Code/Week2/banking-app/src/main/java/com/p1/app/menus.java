package com.p1.app;

import java.util.Scanner;

import com.p1.pojo.customer;
import com.p1.service.accountService;
import com.p1.service.customerService;

public class menus
{
	private static Scanner scanner = new Scanner(System.in);
	private static customerService cService = new customerService();
	private static accountService aService = new accountService();
	
	public static void loginPrompt()
	{
		System.out.println("----Login----\n"
				+ "1. Login\n"
				+ "2. Create account\n"
				+ "3. Test");
		int option = 0;
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type either options corresponding number");
			loginScreen();
		}
		
		switch(option)
		{
		case 1:
			loginScreen();
			break;
		case 2: 
			createUser();
			break;
		case 3:
			cService.getAll();
			break;
			
		}
	}
	
	static void loginScreen()
	{
		System.out.println("Username:");
		String userName = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		
		//Add check against database
		customer  c = cService.findOne(userName);
		System.out.println(c.getUser_Password());
		if(c.getUser_Password().equals(password))
		{
			accountsScreen();
		}
		else
		{
			System.out.println("Inncorrect username or password");
			loginScreen();
		}
	}
	
	static void accountsScreen()
	{
		System.out.println("----Accounts----\n");
		
		//Add numbers based on accounts that exist
	}
	
	static void accountOptions() 
	{
		System.out.println("----Options----\n"
				+ "1. Withdraw\n"
				+ "2. Deposit\n"
				+ "3. Balance");
		int option = 0;
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type options corresponding number");
			accountOptions();
		}
		
		double amount = 0;
		switch(option)
		{
		case 1: 
			System.out.println("Please enter amount");
			try
			{
				amount = Double.parseDouble(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input");
				accountOptions();
			}
			//Remove from account
			break;
			
			
		case 2: 
			System.out.println("Please enter amount");
			try
			{
				amount = Double.parseDouble(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input");
				accountOptions();
			}
			//Add to account
			break;
			
			
		case 3:
			/// Return Balance
			break;
		}
	}
	
	static void createUser()	
	{
		customer cus = new customer();
		
		System.out.println("Create First Name:");
		String firstname = scanner.nextLine();
		cus.setFirstName(firstname);
		
		System.out.println("Create Last Name:");
		String lastname = scanner.nextLine();
		cus.setLastName(lastname);
		
		System.out.println("Create Username");
		String username = scanner.nextLine();
		cus.setUser_Username(username);
		
		System.out.println("Create Password");
		String password = scanner.nextLine();
		cus.setUser_Password(password);
		
		cService.save(cus);
		accountsScreen();
	}
	
	static void createAccount()
	{
		System.out.println("Enter account name");
		String accountName = scanner.nextLine();
		System.out.println("----Choose Account Tpye----\n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Other");
		
		int option = 0;
		String accountType;
		try
		{
			option = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type options corresponding number");
			createAccount();
		}
		
		switch(option)
		{
		case 1:
			accountType = "Checking";
			break;
		case 2:
			accountType = "Savings";
			break;
		case 3:
			accountType = "Other";
			break;		
		}
	}
}
