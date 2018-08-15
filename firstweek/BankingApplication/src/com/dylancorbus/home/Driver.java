package com.dylancorbus.home;

import java.util.Scanner;

public class Driver {

	static Scanner scan = new Scanner(System.in);

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
	
	public static void welcomeMessage() {
		System.out.println(
				"|Welcome to the Bank.                                                                                       |");
		System.out.println(
				"|===========================================================================================================|===================================================================================");
		System.out.println(
				"| Enter one of the following. 1: log in. 2: Create account. 3: Close program. 4: Delete account.            |");
		System.out.println(
				"|___________________________________________________________________________________________________________|");
		String input = scan.nextLine();
		int inpt = Integer.parseInt(input);
		POJO user = new POJO();
		if (input == null)
			System.out.println("Please enter numbers only.");
		switch (inpt) {
		case 1:
			user.userLogin();
			break;
		case 2:
			user.createUser();
			break;
		case 3:
			exitApplication();
		case 4:
			
		}
		scan.close();
	}

	public static void main(String[] args) {
		welcomeMessage();

	}

}
