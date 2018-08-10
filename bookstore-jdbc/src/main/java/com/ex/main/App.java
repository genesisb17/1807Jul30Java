package com.ex.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * Book Store App Driver
		 */
		System.out.println("Welcome!\n" + "This is a bookstore");
		menu();
	}
	
	static void menu() {
		System.out.println("-------Main Menu-------\n" 
				+ "1. View/Update Books\n"
				+ "2. View/Update Genre\n"
				+ "3. View/Update Authors\n"
				+ "4. Add Book\n"
				+ "5. Add Genre\n"
				+ "6. Add Author");
		try {
			int option = Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, put a number, fool!");
			menu();
		}
	}
}
