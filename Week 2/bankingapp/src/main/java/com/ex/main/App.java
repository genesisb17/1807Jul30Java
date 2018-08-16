/*
 * BANKING SYSTEM APP
 * should NOT interact directly with DAO layer!
 * only the service layer
 */
package com.ex.main;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ex.pojos.BankType;
import com.ex.pojos.Login;
import com.ex.service.CreateService;
import com.ex.service.LoginService;
import com.ex.service.TransactionService;



public class App {

	public static Scanner scanner = new Scanner(System.in);
	static CreateService cService = new CreateService();
	static LoginService lService = new LoginService();
	static TransactionService tService = new TransactionService();
	
	public static void main(String[] args) {
		menu();
	}

	static void menu() {
		
		System.out.println(
				  " ___________________________________\n"
				+ "|----[Welcome to Ken Enterprise]----|\n"
				+ "|----------[Banking App]------------|\n"
				+ "|                                   |\n"
		+         "|    (1)[ Create an Account    ]    |\n"
				+ "|    (2)[ Login                ]    |\n"
				+ "|    (3)[ Forgot Password      ]    |\n"
				+ "|    (4)[ Exit App             ]    |\n"
				+ "|___________________________________|");
		int option = 0;
		try { 
			System.out.println("\nWhich action item would you like to do: ");
			
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("\nPlease enter a value"
					+ " between 1 and 4.\n");
			menu();
		}
		
		switch(option) {
		case 1:
			createAccount();
			break;
		case 2:
			loginMenu();
			break;
		case 3: 
			findPassword();
			break;
		case 4:
			System.out.println("Thank you for using our mobile banking app.\n"
					+ "See you again.");
			System.exit(0);
		default:
			System.out.println("Please enter a value"
					+ " between 1 and 4.\n");
			menu();
		}
		
	}
	
	static void createAccount(){
		System.out.println("First Name: ");
		String firstname = scanner.nextLine();
		System.out.println("Last Name: ");
		String lastname = scanner.nextLine();
		System.out.println("Username: ");
		String username = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();
		
		//Received all the information that the user wants as his account information
		Login createaccount = new Login(username, password, firstname, lastname);
		String insert_username = createaccount.getUsername();
		String insert_password = createaccount.getUserpassword();
		String insert_firstname = createaccount.getFirstname();
		String insert_lastname = createaccount.getLastname();
		//Now I want to create their account and insert the row into the database
		
		cService.create_account(insert_username, insert_password, 
				insert_firstname, insert_lastname);
		App.menu();
	}
	
	public static void loginMenu(){
		System.out.println("------Login------\n");
		
		System.out.println("Username: ");
		String username = scanner.nextLine();
		//User inputs username and the database checks if it's a match
		//If it exists, then fetch the password from database
		System.out.println("Password: ");
		String userpassword = scanner.nextLine();
		//User inputs password that matches the username
		//Check the password to see if it matches the database
		//If the username and password are both valid then move onto the next menu
		Login check = new Login();
		check.setUsername(username);
		check.setUserpassword(userpassword);
		
		//passes in check object as argument
		lService.findOne(check);
	
		if((username.compareTo(check.getUsername()) == 0) && (userpassword.compareTo(check.getUserpassword()) == 0)){
			System.out.println("\nYou have logged in, "
					+ check.getFirstname() + " " + check.getLastname()
					+ ".");
			transactionMenu(check.getFirstname(), check.getLastname(), check.getUsername());
			}
	}
	
	static void transactionMenu(String firstname, String lastname, String username) {
		
			System.out.println(
					"\n ________________________________\n"
					+ "|---  [Transaction - Options] ---|\n"
					+ "|                                |\n"
					+ "|   (1) [     Withdraw     ]     |\n"
					+ "|   (2) [     Deposit      ]     |\n"
					+ "|   (3) [     Summary      ]     |\n"
					+ "|   (4) [     Logout       ]     |\n"
					+ "|________________________________|");
			int option = 0;
			try {
				option = Integer.parseInt(scanner.next());
			} catch (NumberFormatException e) {
				System.out.println("Invalid values inserted. Please use numerics.");
				transactionMenu(firstname, lastname, username);
			}
			BankType passInfo = new BankType();
			passInfo.setFirstname(firstname);
			passInfo.setLastname(lastname);
			passInfo.setUsername(username);
			passInfo.setAction(option);
			
			switch(option) {
			
			case 1:
				System.out.println("From which account would "
						+ "you\nlike to withdraw from?\n");
				System.out.println(
						  " _________________________________\n"
						+ "|    -----    Accounts   -----    |\n"
						+ "|                                 |\n"
						+ "|     (1) [   Checkings   ]       |\n"
						+ "|     (2) [   Savings     ]       |\n"
						+ "|     (3) [   Return      ]       |\n"
						+ "|_________________________________|");
				try {
					option = Integer.parseInt(scanner.next());
				} catch(NumberFormatException e) {
					System.out.println("You did not enter a valid number."
							+ "\nReturning to options.");
					transactionMenu(firstname, lastname, username);
				}
				if(option == 1) {
					try {
						System.out.println("Amount to withdraw: ");
						BigDecimal amount_withdraw;
						amount_withdraw = scanner.nextBigDecimal();
						passInfo.setBank_type(option);
						passInfo.setAmount(amount_withdraw);
						tService.update(passInfo);
					} catch (InputMismatchException e) {
						System.out.println("Invalid values inserted."
								+ "\nPlease use numerics.\n");
						transactionMenu(firstname, lastname, username);
					}
					transactionMenu(firstname, lastname, username);
				} else if(option == 2) {
					try {
						System.out.println("Amount to withdraw: ");
						BigDecimal amount_withdraw;
						amount_withdraw = scanner.nextBigDecimal();
						passInfo.setBank_type(option);
						passInfo.setAmount(amount_withdraw);
						tService.update(passInfo);
					} catch (InputMismatchException e) {
						System.out.println("Invalid values inserted. Please use numerics.");
						transactionMenu(firstname, lastname, username);
					}
					transactionMenu(firstname, lastname, username);
				} else if(option == 3) {
					transactionMenu(firstname, lastname, username);
				} else {
					System.out.println("Not a valid option choice.");
					transactionMenu(firstname, lastname, username);
				}
				break;
			case 2:
				System.out.println("From which account would "
						+ "you\nlike to deposit from?\n");
				System.out.println(
								  " _________________________________\n"
								+ "|    -----    Accounts   -----    |\n"
								+ "|                                 |\n"
								+ "|     (1) [   Checkings   ]       |\n"
								+ "|     (2) [   Savings     ]       |\n"
								+ "|     (3) [   Return      ]       |\n"
								+ "|_________________________________|");
				try {
					option = Integer.parseInt(scanner.next());
				} catch(NumberFormatException e) {
					System.out.println("You did not enter a valid number."
							+ "\nReturning to options.");
					transactionMenu(firstname, lastname, username);
				}
				if(option == 1) {
					try {
						System.out.println("Amount to deposit: ");
						BigDecimal amount_deposit = scanner.nextBigDecimal();
						passInfo.setBank_type(option);
						passInfo.setAmount(amount_deposit);
						tService.update(passInfo);
					} catch (InputMismatchException e) {
						System.out.println("Invalid values inserted. Please use numerics.");
						transactionMenu(firstname, lastname, username);
					}
					transactionMenu(firstname, lastname, username);
				} else if(option == 2) {
				try {
					System.out.println("Amount to deposit: ");
					BigDecimal amount_deposit = scanner.nextBigDecimal();
					passInfo.setBank_type(option);
					passInfo.setAmount(amount_deposit);
					tService.update(passInfo);
				} catch (InputMismatchException e) {
					System.out.println("Invalid values inserted. Please use numerics.");
					transactionMenu(firstname, lastname, username);
				}
					transactionMenu(firstname, lastname, username);
				} else if(option == 3) {
					transactionMenu(firstname, lastname, username);
				} else {
					System.out.println("Not a valid option choice.");
					transactionMenu(firstname, lastname, username);
				}
				break;	
			case 3:
				System.out.println("From which account would "
						+ "you\nlike to get a summary from?\n");
				System.out.println(
						  " _________________________________\n"
						+ "|     ---     Accounts    ---     |"
						+ "|                                 |\n"
						+ "|     (1) [   Checkings   ]       |\n"
						+ "|     (2) [   Savings     ]       |\n"
						+ "|     (3) [   Both        ]       |\n"
						+ "|     (4) [   Return      ]       |\n"
						+ "|_________________________________|");
				try {
					option = Integer.parseInt(scanner.next());
				} catch (NumberFormatException e) {
					System.out.println("Invalid values inserted. Please use numerics.");
					transactionMenu(firstname, lastname, username);
				}
				if(option == 1) {
					System.out.println("Retrieving summary... ");
					passInfo.setBank_type(option);
					tService.findOne(passInfo);
					transactionMenu(firstname, lastname, username);
				} else if(option == 2) {
					System.out.println("Retrieving summary... ");
					passInfo.setBank_type(option);
					tService.findOne(passInfo);
					transactionMenu(firstname, lastname, username);
				} else if(option == 3){
					System.out.println("Retrieving summary... ");
					passInfo.setBank_type(option);
					tService.findOne(passInfo);
					transactionMenu(firstname, lastname, username);
				} else if(option == 4) {
					transactionMenu(firstname, lastname, username);
				} else {
					System.out.println("Not a valid option choice.");
					transactionMenu(firstname, lastname, username);
				}
				break;
				
			case 4:
				System.out.println("Thank you for using our mobile banking app.\n"
						+ "See you again.");
				System.exit(0);
				
			default:
				transactionMenu(firstname, lastname, username);
			}
			
		}
		
	
	static void findPassword() {
		Login findP = new Login();
		
		System.out.println("Type in your username: ");
		String username = scanner.nextLine();
		findP.setUsername(username);
		lService.findPw(findP);
		System.out.println("Your password was: " + findP.getUserpassword());
		App.menu();
	}
	
}
