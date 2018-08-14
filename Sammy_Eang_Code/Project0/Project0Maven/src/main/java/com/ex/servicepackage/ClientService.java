package com.ex.servicepackage;

import java.util.List;
import java.util.Scanner;
import com.ex.dao.ClientDAO;
import com.ex.exceptions.CustomException;
import com.ex.pojo.Client;

public class ClientService {
	
	static ClientDAO cdao = new ClientDAO();
	static Scanner scanner = new Scanner(System.in);
	
	//login function
	public int login() {
		
		//prompts user for username and pw and stores them
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();
		
		//sees if username and pw match and returns whatever id
		int loginid = usernameAndPasswordMatch(username, password);
		return loginid;
		
	}
	
	//sign up function
	public void signup() {
		
		//prompts for username, stores it, and checks if it is unique
		System.out.println("Choose a username: ");
		String username = scanner.nextLine();
		Boolean isUnique = false;
		try {
			isUnique = isUnique(username);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
		//if it is unique, user enters first name, last name, and pw, and all is stored
		if(isUnique) {
			System.out.println("Enter your first name: ");
			String firstName = scanner.nextLine();
			System.out.println("Enter your last name: ");
			String lastName = scanner.nextLine();
			System.out.println("Enter a password: ");
			String password = scanner.nextLine();
			
			//takes all the fields the user entered and makes a new client object
			Client temp = new Client(firstName, lastName, username, password);
			//that client object is saved into the database
			cdao.save(temp);
			System.out.println("Account created, now returning to sign in screen...");
		} else {
			//if not unique, nothing is saved or prompted for
			System.out.println("That username is already taken. Please try a new one.");
		}
	}
	
	//func to check if string is unique
	public boolean isUnique(String username) throws CustomException {
		
		//get all clients
		List<Client> usernames = cdao.findAll();
		//go through each
		for(Client c: usernames) {
			//does entered username match any of the current usernames in the list?
			if(c.getUsername().equals(username)) {
				//if so, return false, not unique
				throw new CustomException("Username already taken.");
				//return false;
			}
		}
		//if not returned false, returned true
		return true;
	}
	
	//func to check if username and password match
	public int usernameAndPasswordMatch(String username, String password) {
		
		//stores all clients into list
		List<Client> usernames = cdao.findAll();
		
		//for each client
		for(Client c: usernames) {
			//if username matches
			if(c.getUsername().equals(username)) {
				//see if password matches
				if(c.getPw().equals(password)) {
					//if both, return client id
					return c.getClient_id();
				}
			}
		}
		//return false dummy client id if no username and password matches
		return -1;
	}
	
}
