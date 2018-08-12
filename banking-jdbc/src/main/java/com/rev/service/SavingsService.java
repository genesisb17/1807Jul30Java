package com.rev.service;

import com.rev.dao.SavingsDAO;
import com.rev.pojos.Savings;
import com.rev.pojos.Users;

public class SavingsService {

	public static boolean doesAccountExist(Users user) {
		boolean exists = SavingsDAO.doesAccountExist(user);
		
		if (exists == false) {
			System.out.println("You do not have a Savings account.\n"
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
		boolean status = SavingsDAO.createSavingsAccount(user, amount);
		
		if (status == true) {
			System.out.println("You have successfully created a savings account and deposited $" + amount);
			System.out.println("You may now withdraw and deposit from this account.\n");
			return true;
		}
		else {
			System.out.println("You were unable to create an account. Please try again.\n");
			return false;
		}
	}

	public static void total(Users user) {
		Savings s = SavingsDAO.total(user);
		double total = s.getTotal();
		System.out.println("The amount in your savings account is $" + total + "\n");
		return;
	}

	public static boolean withdraw(Users user, double amount) {
		Savings s = SavingsDAO.total(user);
		double total = s.getTotal();
		if (total >= amount) {
			total -= amount;
			boolean status = SavingsDAO.withdraw(user, total);
			
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
		Savings s = SavingsDAO.total(user);
		double current = s.getTotal();
		double newTotal = current + amount;
		
		boolean status = SavingsDAO.deposit(user, newTotal);
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
