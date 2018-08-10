package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome");
		menu();
	}
	
	static void menu() {
		System.out.println("Main menu\n"
					+ "1 - View/update Books\n"
					+ "2 - View Genre\n"
					+ "3 - View Author\n");
		String option = 0;
		try {
		option = scanner.nextLine();	//use nextline its safer
	} catch(InputMismatchException e) {
		System.out.println("sorry etc");
		menu();
	}
		
	switch(option) {
	
	case 1:
	case 2:
		break;
	

	}
		
	
		
		
	}
}
