package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.revature.pojos.Book;
import com.revature.pojos.Genre;
import com.revature.servicepackage.GenreService;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static GenreService gService = new GenreService();
	
	public static void main(String[] args) {
		
		/*
		 * BOOK STORE APP DRIVER
		 * should NOT interact directly with DAO layer!
		 * only the service layer.
		 */
		System.out.println("Welcome.......\n");
		menu();
	}
	
	static void menu() {
		System.out.println("---------Main Menu-----------"
				+ "Enter a number to choose:\n"
				+ "1. View Books\n" 
				+ "2. View Genres\n"
				+ "3. View Authors\n"
				+ "4. Add Book\n"
				+ "5. Add Genre\n"
				+ "6. Add Author\n");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Choose the options please");
			menu();
		}
		
		switch(option) {
			case 1:
			case 2:
				viewGenres();
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			default:
		}
	}
	
	static void viewGenres() {
		System.out.println("Current genres: ");
		List<Genre> genres = gService.getAll();
		for(Genre g: genres) {
			System.out.println(gService.getAll());
		}
	}
	
	static void addBook() {
		System.out.println("Enter your book's title: ");
		String title = scanner.nextLine();
		System.out.println("Enter ISBN: ");
		String isbn = scanner.nextLine();
		System.out.println("Enter price: ");
		double price = Double.parseDouble(scanner.nextLine());//surround in try catch
		System.out.println("Select your Genre(Enter its number)");
		List<Genre> genres = gService.getAll();
		for(int i = 0; i < genres.size(); i++) {
			System.out.println(i+1 + ": " + genres.get(i));
		}
		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
		int genreID = genres.get(genreIndex).getId();
		Book b = new Book(genreID, isbn, title, price, genreID);
	}

}
