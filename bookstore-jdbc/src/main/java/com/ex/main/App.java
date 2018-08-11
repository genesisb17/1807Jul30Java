package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.rev.pojos.Book;
import com.rev.pojos.Genre;
import com.rev.service.GenreService;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static GenreService = new GenreService();

	public static void main(String[] args) {
		/*
		 * BOOK STORE APP DRIVER
		 * should NOT interact directly with DAO layer!
		 * only the service layer
		 */
		System.out.print("WELCOME!\n"
				+ "Ready to Read?!");
		menu();
	}

	static void menu() {
		System.out.println("---------Main Menu--------\n"
				+ "1. View/Update Books\n"
				+ "2. View/Update Genres\n"
				+ "3. View/Update Authors\n"
				+ "4. Add Book\n"
				+ "5. Add Genre\n"
				+ "6. Add Author");
		int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 6 :)");
			menu();
		}
		
		switch(option) {
		case 1:
		case 2:
			viewGenres();
			break;
		case 3: 
			break;
		case 4:
			addBook();
			break;
			//
		}
	}
	
	static void addBook() {
		System.out.println("Enter your book's title:");
		String title = scanner.nextLine();
		System.out.println("Enter the ISBN (10-digit number):");
		String isbn = scanner.nextLine();
		System.out.println("Enter the price:");
		double price = Double.parseDouble(scanner.nextLine()); //SURROUND IN TRY CATCH FOR NFE
		System.out.println("Select your Genre(Enter its number)");
		List<Book> books = bService.getAll();
		for(int i = 0; i < books.size(); i++) {
			System.out.println(i+1 + ": " + books.get(i));
		}
		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
		int genreID = books.get(genreIndex).getId();
		Book b = new Book(isbn, title, price, genreID);
		//call book service addBook() which calls dao addBook()
		//WE HAVE MAINTAINED REFERENTIAL INTEGRITY
		
	}
	static void viewGenres() {
		System.out.println("Current Genres:");
		List<Genre> genres = gService.getAll();
		for(Genre g : genres) {
			System.out.println(g.getName());
		}
	}

}