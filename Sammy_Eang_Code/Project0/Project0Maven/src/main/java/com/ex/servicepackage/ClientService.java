package com.ex.servicepackage;

import java.util.List;
import java.util.Scanner;
import com.ex.dao.ClientDAO;
import com.ex.pojo.Client;

public class ClientService {
	
	static ClientDAO cdao = new ClientDAO();
	static Scanner scanner = new Scanner(System.in);
	public static int loggedInId;
	
	public Boolean login() {
		
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();
		
		Boolean successfulLogin = usernameAndPasswordMatch(username, password);
		return successfulLogin;
		
	}
	
	public void signup() {
		
		System.out.println("Choose a username: ");
		String username = scanner.nextLine();
		Boolean isUnique = isUnique(username);
		
		if(isUnique) {
			
			System.out.println("Enter your first name: ");
			String firstName = scanner.nextLine();
			System.out.println("Enter your last name: ");
			String lastName = scanner.nextLine();
			System.out.println("Enter a password: ");
			String password = scanner.nextLine();
			
			Client temp = new Client(firstName, lastName, username, password);
			cdao.save(temp);
			System.out.println("Account created, now returning to sign in screen...");
		} else {
			System.out.println("That username is already taken. Please try a new one.");
		}
	}
	
public boolean isUnique(String username) {
		
		List<Client> usernames = cdao.findAll();
		for(Client c: usernames) {
			if(c.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean usernameAndPasswordMatch(String username, String password) {
		
		List<Client> usernames = cdao.findAll();
		
		for(Client c: usernames) {
			if(c.getUsername().equals(username)) {
				if(c.getPw().equals(password)) {
					loggedInId = c.getClient_id();
					return true;
				}
			}
		}
		
		return false;
	}
	
}
