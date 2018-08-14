package com.ex.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome!\nReady to Read?");
		menu();
	}
	
	static void menu() {
		System.out.println("----------Main Menu----------\n"
				+ "1. View/Update Books\n"
				+ "2. View/Update Genres\n"
				+ "3. View/Update Authors\n"
				+ "4. Add Books\n"
				+ "5. Add Genre\n"
				+ "6. Add Author");
		int option = 0;
		try {
			option = Integer.parseInt(sc.nextLine());
		} catch (InputMismatchException e) {
			System.out.println("Please provide a correct option!");
			menu();
		}
		
		switch (option) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			
		}
		
	}
	
	static void viewGenres() {
		
	}

}
