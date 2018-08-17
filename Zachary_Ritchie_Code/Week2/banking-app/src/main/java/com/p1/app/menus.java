package com.p1.app;

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
	//private static account accountTemp = new account();
	
	public static void loginPrompt()
	{
		customerTemp = new customer();
		System.out.println("----Login----\n"
				+ "1. Login\n"
				+ "2. Create account\n"
				+ "3. Exit");
		int option = 0;
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
			if ((option <= 0) || (option > 3))
			{
				System.out.println("Invalid input please type either options corresponding number");
				loginPrompt();
			}
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
		customer  c = new customer();
		
		if(cService.findOne(userName) != null)
		{
			c = cService.findOne(userName);
			if(c.getUser_Password().equals(password))
			{
				customerTemp = c;
				accountsScreen();
			}
			else
			{
				System.out.println("Inncorrect username or password");
				loginPrompt();
			}
		}	
		else
		{
			System.out.println("Inncorrect username or password");
			loginPrompt();
		}
	}
	
	static void accountsScreen()
	{
		if(!aService.getAll().contains(null))
		{
			LinkedList<account> temp = new LinkedList<account>();
			int counter = 5;
			int option = 0;
			System.out.print("----Accounts Menu----\n"
					+ "1. Add account\n"
					+ "2. Remove account\n"
					+ "3. Logout\n"
					+ "4. Exit\n");
			
			List<account> accountsList = aService.getAll();
			
			for(account acc : accountsList)
			{			
				if(customerTemp.getUserId() == acc.getCustomer_id())
				{
					System.out.print(counter + ". " + acc.getAccount_type() + " account " + acc.getAccount_Name() +"\n");
					acc.setCounter(counter);
					temp.add(acc);
					counter++;
				}
			}
				
			try
			{
				option = Integer.parseInt(scanner.nextLine());
				if ((option <= 0) || (option > counter))
				{
					System.out.println("Invalid input please type options corresponding number");
					accountsScreen();
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input please type options corresponding number");
				accountsScreen();
			}
			
			if (option > counter)
			{
				System.out.println("Invalid input please type options corresponding number");
				accountsScreen();
			}
			else if(option == 1)
			{
				createAccount();
			}
			else if(option == 2)
			{
				temp = deleteAccount(temp);
				accountsScreen();
			}
			else if(option == 3)
			{
				loginPrompt();
			}
			else if(option == 4)
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
						break;
					}
				}
			}
		}
		else
		{
			createAccount();
		}
	}
	
	static LinkedList<account> deleteAccount(LinkedList<account> obj)
	{
		int counter = 2;
		int option = 0;
		System.out.println("----Remove----\n"
							+ "1. Back");
		for(account acc : obj)
		{
			System.out.print(counter + ". " + acc.getAccount_type() + " account " + acc.getAccount_Name() +"\n");
			acc.setCounter(counter);
			counter++;
		}
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
			if ((option <= 0) || (option > counter))
			{
				System.out.println("Invalid input please type options corresponding number");
				deleteAccount(obj);
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type options corresponding number");
			deleteAccount(obj);
		}
		
		
		if(option == 1)
		{
			accountsScreen();
		}
		else
		{
			for(account act : obj)
			{
				if(act.getCounter() == option)
				{
					aService.delete(act);
					break;
				}
			}
		}
		
		
		
		return obj;
	}
	
	static void accountOptions(account obj) 
	{
		System.out.println("----Menu----\n"
				+ "1. Withdraw\n"
				+ "2. Deposit\n"
				+ "3. Balance\n"
				+ "4. Back accounts menu\n"
				+ "5. Logout\n"
				+ "6. Exit");
		int option = 0;
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
			if ((option <= 0) || (option > 6))
			{
				System.out.println("Invalid input please type options corresponding number\n");
				accountOptions(obj);
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid input please type options corresponding number\n");
			accountOptions(obj);
		}
		
		if(option <= 6)
		{
			double amount = 0;
			switch(option)
			{
			case 1: 
				System.out.println("Please enter amount");
				try
				{
					String input = scanner.nextLine();
					try
					{
						if(input.contains("+"))
						{
							throw new myException();
						}
					}
					catch (myException e)
					{
						System.out.println("Invalid input\n");
						accountOptions(obj);
					}
					
					
					amount = Double.parseDouble(input);
					if(amount <= 0)
					{
						System.out.println("Invalid input\n");
						accountOptions(obj);
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid input\n");
					accountOptions(obj);
				}
				
				if(amount < obj.getBalance())
				{
					obj.setBalance(obj.getBalance() - amount);
					//System.out.println("Balance " + obj.getBalance());
				}
				else if (amount > obj.getBalance())
				{
					System.out.println("amount is greater than account total");
					accountOptions(obj);
				}
				
				aService.update(obj);
				
				accountOptions(obj);
				
				break;
				
				
			case 2: 
				System.out.println("Please enter amount");
				try
				{
					amount = Double.parseDouble(scanner.nextLine());
					if (amount < 0)
					{
						System.out.println("Invalid input\n");
						accountOptions(obj);
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid input\n");
					accountOptions(obj);
				}
				obj.setBalance(obj.getBalance() + amount);
				
				aService.update(obj);
				
				accountOptions(obj);
				break;
				
			case 3:
				System.out.println(obj.getBalance() + "\n");
				accountOptions(obj);
				break;
			case 4:
				accountsScreen();
				break;
			case 5:
				customerTemp = null;
				loginPrompt();
				break;
			case 6:
				System.exit(1);
				break;
			}
		}
		else
		{
			System.out.println("Invalid input please type options corresponding number");
		}
		
	}
	
	static void createUser()	
	{
		customer cus = new customer();
		Boolean check = true;
		System.out.println("Create First Name:");		
		String firstname = scanner.nextLine();		
		if (badLength(firstname)) 
		{
			System.out.println("To long please shorten");
			createUser();
		}
		cus.setFirstName(firstname);		
		
		System.out.println("Create Last Name:");
		String lastname = scanner.nextLine();
		if (badLength(lastname)) 
		{
			System.out.println("To long please shorten");
			createUser();
		}
		cus.setLastName(lastname);
				
		do
		{
			System.out.println("Create Username");
			String username = scanner.nextLine();
			if (badLength(username)) 
			{
				System.out.println("To long please shorten");
				createUser();
			}
			else if(cService.findOne(username) == null)
			{
				cus.setUser_Username(username);
				check = false;
			}
			else
			{
				System.out.println("Username not unique, please try again");
			}
		}while(check == true);
				
		
		System.out.println("Create Password");
		String password = scanner.nextLine();
		if (badLength(password)) 
		{
			System.out.println("To long please shorten");
			createUser();
		}
		cus.setUser_Password(password);
		
		cService.save(cus);
		customerTemp = cus;
		accountsScreen();
	}
	
	private static Boolean badLength(String obj)
	{
		if (obj.length() > 50)
		{
			return true;
		}
		
		return false;
	}
	
	static void createAccount()
	{
		account acc = new account();
		
		System.out.println("Enter account name");
		String accountName = scanner.nextLine();
		if (badLength(accountName)) 
		{
			System.out.println("To long please shorten");
			createAccount();
		}
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
			if ((option <= 0) || (option > 3))
			{
				System.out.println("Invalid input please type options corresponding number");
				createAccount();
			}
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
