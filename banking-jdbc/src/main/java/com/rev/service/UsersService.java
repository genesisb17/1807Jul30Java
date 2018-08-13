package com.rev.service;

import com.rev.dao.UsersDAO;
import com.rev.pojos.Users;

public class UsersService {
	private static int counter = 0;
	
	private static UsersDAO UsersDAO = new UsersDAO();
	
	public static boolean isUsernameUnique(String username) {
		boolean isUnique = UsersDAO.isUsernameUnique(username);
		
		// Just checks if a match wsa found or not
		if (isUnique == true) {
			return true;
		}
		else {
			System.out.println("This username is not unique. Please try again.\n");
			return false;
		}
	}
	
	public static void createBankingAccount(String username, String password) {
		boolean isCreated = UsersDAO.createBankingAccount(username, password);
		
		// Regardless of the results the app will bring the user back to the Intro()
		if (isCreated == true) {
			System.out.println("Your account has been created! You can log in now!\n");
			return;
		}
		else {
			System.out.println("Your account was not created. Please try again.\n");
			return;
		}
	}

	public static Users logIn(int userid, String username, String password) {
		Users u = UsersDAO.logIn(userid, username, password);
		
		// Here to kick a user out if they try to brute force login...
		if (u == null) {
			counter += 1;
			System.out.println(counter + " Failed login attempt(s).");
			if (counter >= 3) {
				System.out.println("Too many failed log in attempts. Please try again later.\n");
				System.exit(0);
			}
			// Until counter reaches 3, will allow them to keep trying
			System.out.println("Please try again.\n");
		}
		// u not being null means it found a match
		else {
			System.out.println("Hello " + u.getUsername() + "! You are now logged in!\n");
		}
		// will return u regardless.
		return u;
	}

	public static void nuke(Users user, String name) {
		if (user.getUsername().equals(name.toLowerCase())) {
			int userid = user.getUserid();
			UsersDAO.nukeAccounts(name, userid);
			System.out.println("We think we nuked 'em! Try to log in and see!");
			return;
			
		}
		else {
			System.out.println("The username entered did not match our records.\n"
				+ "Going to toss you back to the landing page anyway. : ^)");
			return;
		}
	}
}