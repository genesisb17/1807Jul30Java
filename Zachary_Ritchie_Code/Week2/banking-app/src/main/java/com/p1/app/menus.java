package com.p1.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.p1.pojo.account;
import com.p1.pojo.customer;
import com.p1.service.accountService;
import com.p1.service.customerService;

public class menus
{
	private static Scanner scanner = new Scanner(System.in);
	private static customerService cService = new customerService();
	private static accountService aService = new accountService();
	private static customer customerTemp = new customer();
	private static account accountTemp = new account();
	
	public static void loginPrompt()
	{
		System.out.println("----Login----\n"
				+ "1. Login\n"
				+ "2. Create account\n"
				+ "3. Exit");
		int option = 0;
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type either options corresponding number");
			loginPrompt();
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
			System.exit(1);
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
		//System.out.println(c.getUser_Password());
		if(c.getUser_Password().equals(password))
		{
			customerTemp = c;
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
		if(!aService.getAll().contains(null))
		{
			LinkedList<account> temp = new LinkedList<account>();
			int counter = 4;
			int option = 0;
			System.out.println("----Accounts----\n"
					+ "-Select 1 or 2 or account type-\n"
					+ "1. Add account\n"
					+ "2. Remove account\n"
					+ "3. Exit\n");
			
			List<account> accountsList = aService.getAll();
			
			for(account acc : accountsList)
			{
				if(customerTemp.getUserId() == acc.getCustomer_id())
				{
					System.out.println(counter + " " + acc.getAccount_type() + " account " + acc.getAccount_Name() +"\n");
					acc.setCounter(counter);
					temp.add(acc);
					counter++;
				}
			}
				
			try
			{
				option = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input please type options corresponding number");
				accountsScreen();
			}
			
			if(option == 1)
			{
				createAccount();
			}
			else if(option == 2)
			{
				System.out.println("Not Yet Implemented");
				accountsScreen();
			}
			else if(option == 3)
			{
				System.exit(1);
			}
			else
			{
				for(account act : temp)
				{
					if(act.getCounter() == option)
					{
						accountOptions(act);
					}
				}
			}
		}
		else
		{
			createAccount();
		}
	}
	
	static void accountOptions(account obj) 
	{
		System.out.println("----Options----\n"
				+ "1. Withdraw\n"
				+ "2. Deposit\n"
				+ "3. Balance\n"
				+ "4. Add new account\n"
				+ "5. Back to choose account\n"
				+ "6. Back to login\n"
				+ "7. Exit");
		int option = 0;
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type options corresponding number\n");
			accountOptions(obj);
		}
		
		double amount = 0;
		switch(option)
		{
		case 1: 
			System.out.println("Please enter amount (format 0.00)");
			try
			{
				amount = Double.parseDouble(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input\n");
				accountOptions(obj);
			}
			
			if(amount < obj.getBalance())
			{
				obj.setBalance(obj.getBalance() - amount);
				System.out.println("Balance " + obj.getBalance());
			}
			else if (amount > obj.getBalance())
			{
				System.out.println("amount is greater than account total");
				accountOptions(obj);
			}
			else
			{
				obj.setBalance(obj.getBalance() - amount);
				System.out.println("Balance " + obj.getBalance());
			}
			
			aService.save(obj);
			
			accountOptions(obj);
			
			break;
			
			
		case 2: 
			System.out.println("Please enter amount");
			try
			{
				amount = Double.parseDouble(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input\n");
				accountOptions(obj);
			}
			obj.setBalance(obj.getBalance() + amount);
			
			aService.save(obj);
			
			accountOptions(obj);
			break;
			
		case 3:
			System.out.println(obj.getBalance() + "\n");
			accountOptions(obj);
			break;
		case 4:
			createAccount();
			break;
		case 5:
			accountsScreen();
			break;
		case 6:
			customerTemp = null;
			loginPrompt();
			break;
		case 7:
			System.exit(1);
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
		account acc = new account();
		
		System.out.println("Enter account name");
		String accountName = scanner.nextLine();
		acc.setAccount_Name(accountName);
		
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
			acc.setAccount_type(accountType);
			break;
		case 2:
			accountType = "Savings";
			acc.setAccount_type(accountType);
			break;
		case 3:
			accountType = "Other";
			acc.setAccount_type(accountType);
			break;		
		}
		
		acc.setCustomer_id(customerTemp.getUserId());
		
		aService.save(acc);
		accountOptions(acc);
	}
}
