package com.bank.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.bank.dao.AccountDao;
import com.bank.dao.UserDao;
import com.bank.pojo.Account;
import com.bank.pojo.AccountType;
import com.bank.pojo.User;
import com.bank.service.Service;
import com.bank.util.CustomException;



public class Driver {
	//creating all my objects 
	static Service user = new Service();
	static Scanner scan = new Scanner(System.in);
	static Account a = new Account();
	static AccountDao ad = new AccountDao();
	static UserDao ud = new UserDao();
	static User u = new User();
	static AccountType at = new AccountType();
	//declaring my vars static so that i can use them throughout the class
	static String uname;
	static String pwd;
	
	//Welcome message when app launches
	public static void welcomeMessage() {
		 
		System.out.println(
				"|Welcome to the Bank.                                                                                       |");
		System.out.println(
				"|===========================================================================================================|===================================================================================");
		System.out.println(
				"| Enter one of the following. 1: log in. 2: Create account. 3: Close program. 4: Delete account.            |");
		System.out.println(
				"|___________________________________________________________________________________________________________|");
		loginMenu();
	}
	//login menu gets called after the welcome message
	public static void loginMenu() {
		String input = scan.nextLine();
		int inpt = Integer.parseInt(input);
		
		if (input == null) {
			System.out.println("Please select an option.");
			loginMenu();
		}
			
		switch (inpt) {
		case 1:
			login();
			break;
		case 2:
			createAccount();
			login();
			break;
		case 3:
			exitApplication();
		case 4:
			delete();
			break;
			
		}
		scan.close();
	}
	//option 1 login
	public static void login() {
		System.out.println("Please enter your username.");
		uname = scan.nextLine();
		System.out.println("Now enter your password.");
		pwd = scan.nextLine();
		try {
		u =	Service.onLogin(uname, pwd);
		} catch (SQLException e) {
			System.out.println("Those credentials were invalid, please try again");
			Driver.login();
		}
		userOptions();
	}
	//create an account
	public static void createAccount() {
		System.out.println("Thanks for choosing our bank.");
		System.out.println("Please enter your First name.");
		String name = scan.nextLine();
		System.out.println("Now your last name.");
		String lname = scan.nextLine();
		System.out.println("Username.");
		String uname = scan.nextLine();
		System.out.println("Finally your Password.");
		String pword = scan.nextLine();
		u.setName(name);
		u.setLname(lname);
		u.setUname(uname.toLowerCase());
		u.setPword(pword);
		ud.addOne(u);
		openAccnt(u);
	}
	//Option 3 exit method
	public static void exitApplication() {
		System.out.println("Are you sure you want to exit? Press 1 for yes and 2 for no. ");
		String exitinput = scan.nextLine();
		int extinpt = Integer.parseInt(exitinput);
		if (extinpt == 1) {
			System.exit(extinpt);
		} else {
			welcomeMessage();
		}
		scan.close();
	}
	
	//Gets displayed on login
	public static void userOptions() {
//		Service.getTime();
		System.out.println("Menu: 1: Logout 2: Withdraw 3: Deposit 4: Open new Account");
		String input = scan.nextLine();
		if (input == null) {
			System.out.println("Please enter a number between 1 and 4.");
			userOptions();
		} else if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")) {
			
			int inpt = Integer.parseInt(input);
			if(inpt==1) {
				logout();
			} else if (inpt == 2) {
				wdOption();
			} else if(inpt== 3) {
				deOption();
			} else if (inpt == 4) {
				openAccnt(u);
			} else if(inpt== 5) {
				fulfillRequirement(inpt);
				System.exit(inpt);
			}
			
		} else {
			System.out.println("Please enter a number between 1 and 4.");	
		} 
		Service.onLoginAfter(u.getUname());
	}
	
	//Logout method
	public static void logout()  {
		System.out.println("Are you sure you want to log off? Press 1 for yes and 2 for no.");
		String input = scan.nextLine();
		int inpt = Integer.parseInt(input);
		if(inpt == 1) {
			

			welcomeMessage();
		} else if (inpt == 2) {
			Service.onLoginAfter(uname);
		}
	}
	//The method that gets called when the user enters in a username that is already taken.
	public static void redoUsername() {
		System.out.println("That user name was invalid. Please enter another one, or select 1 to restart application");
		String uname = scan.nextLine();
		if(uname.equals("1")) {
			welcomeMessage();
		} else {
		u.setUname(uname.toLowerCase());
		ud.addOne(u);
		}
	}
	
	public static void delete() {
		System.out.println("Please enter your username.");
		uname = scan.nextLine();
		System.out.println("Now enter your password.");
		pwd = scan.nextLine();
		try {
		Service.onDelete(uname, pwd);
		} catch (SQLException e) {
			System.out.println("Those credentials were invalid, please try again");
			Driver.delete();
		}
		System.out.println("Your account was deleted, please come to the bank to collect your funds.");
		welcomeMessage();
	}
	//Prompts the user to open a new account.
	public static void openAccnt(User user) {
		System.out.println(user.getName());
		System.out.println("Please select which account you want to open");
		Service.onOpenAccount();
		System.out.println("1 for checking, 2 for credit and 3 for savings.");
		String atypes = scan.nextLine();
		int atid = Integer.parseInt(atypes);
		System.out.println("Please deposit an initial ammount or select 0.");
		String depos = scan.nextLine();
		int deposit = Integer.parseInt(depos);
		a = ad.addOne(user.getId(), deposit);
		ad.addJnct(a.getAid(), atid);
		
	}
		
	public static void wdOption() {
		System.out.println("Please select the account # you want to Withdraw from.");
		String aidstr = scan.nextLine();
		int aid = Integer.parseInt(aidstr);
		System.out.println("How much would you like to withdraw?");
		String amtstr = scan.nextLine();
		int amt = Integer.parseInt(amtstr);
		
		try {
			Service.onWithdraw(aid, amt);
			} catch (SQLException e) {
				System.out.println("You must have entered an invalid amount or an incorrect character");
				Driver.wdOption();			
			}
		
	}
	
	public static void deOption() {
		System.out.println("Please select the account # you want to deposit to.");
		String aidstr = scan.nextLine();
		int aid = Integer.parseInt(aidstr);
		System.out.println("How much would you like to deposit?");
		String amtstr = scan.nextLine();
		int amt = Integer.parseInt(amtstr);
		
		try {
			Service.onDeposit(aid, amt);
			} catch (SQLException e) {
				System.out.println("You must have entered an invalid amount or an incorrect character");
				Driver.deOption();			
			}
		
	}
	
	public void wrongName() {
		System.out.println("That username was incorrect. Please enter a valid username.");
		String uname = scan.nextLine();
		Service.onLoginAfter(uname);
	}
	
	public static void fulfillRequirement(int number) {
		try
		{
		     if(number==5)
		     {
		          throw new CustomException();
		     }
		}
		catch(CustomException ce)
		{
		      System.out.println("You must have typed 5. This is one of the requirements of the project. You have been booted off.");
		      
		}
	}

}
