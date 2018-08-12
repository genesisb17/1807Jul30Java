package com.rev.service;

import com.rev.dao.CheckingsDAO;
import com.rev.pojos.Checkings;
import com.rev.pojos.Users;

public class CheckingsService {
	
	private static CheckingsDAO CheckingsDAO = new CheckingsDAO();

	public static boolean doesAccountExist(Users user) {
		boolean exists = CheckingsDAO.doesAccountExist(user);
		
		// Will never trigger again once a user creates an account
		if (exists == false) {
			System.out.println("You do not have a checkings account.\n"
				+ "Would you like to create one?\n"
				+ "1. Yes\n"
				+ "2. No");
			return exists;
		}
		else {
			return exists;	
		}
	}

	public static boolean create(Users user, double amount) {
		boolean status = CheckingsDAO.createCheckingsAccount(user, amount);
		
		// Mainly a way to verify that the SQL command to the DB was successful
		if (status == true) {
			System.out.println("You have successfully created a checkings account and deposited $" + amount);
			System.out.println("You may now withdraw and deposit from this account.\n");
			return true;
		}
		else {
			System.out.println("You were unable to create an account. Please try again.\n");
			return false;
		}
	}
	
	public static void total(Users user) {
		// c has the total from the SQL query for that account
		Checkings c = CheckingsDAO.total(user);
		double total = c.getTotal();
		System.out.println("The amount in your checkings account is $" + total + "\n");
		return;
	}

	public static boolean withdraw(Users user, double amount) {
		Checkings c = CheckingsDAO.total(user);
		// uses the total method in the DAO so there isn't redundancy
		double total = c.getTotal();
		
		// Gotta stop folks who try to take out more than they got
		if (total >= amount) {
			total -= amount;
			boolean status = CheckingsDAO.withdraw(user, total);
			
			// Just to tell the user if the SQL command was successful or not
			if (status == true) {
				System.out.println("Success! You now have $" + amount + " and your new total is $" + total);
				return true;
			}
			else if (status == false) {
				System.out.println("You were unable to withdraw " + amount + ". Please try again.");
				return false;
			}
		}
		else {
			System.out.println("The amount entered " + amount + " is higher than your total balance " + total + ".\n"
				+ "Please enter a new amount.\n");
		}
		
		return false;
	}

	public static boolean deposit(Users user, double amount) {
		Checkings c = CheckingsDAO.total(user);
		double current = c.getTotal();
		double newTotal = current + amount;
		
		boolean status = CheckingsDAO.deposit(user, newTotal);
		// Also to tell the user if the SQL command was successful
		if (status == true) {
			System.out.println("Success! Your deposit of $" + amount + " brings your new balance to $" + newTotal);
			return true;
		}
		else {
			System.out.println("You were unable to deposit $" + amount + ". Please try again.");
			return false;
		}
	}
}
