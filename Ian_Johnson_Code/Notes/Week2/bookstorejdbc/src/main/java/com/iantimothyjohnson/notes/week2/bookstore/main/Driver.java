package com.iantimothyjohnson.notes.week2.bookstore.main;

import java.util.List;
import java.util.Scanner;

import com.iantimothyjohnson.notes.week2.bookstore.dao.BookDAO;
import com.iantimothyjohnson.notes.week2.bookstore.pojos.Genre;
import com.iantimothyjohnson.notes.week2.bookstore.service.GenreService;

public class Driver {
	// Our driver layer should not interact directly with the DAO layer, but
	// only with the service layer.

	private static Scanner scanner = new Scanner(System.in);
	private static GenreService gService = new GenreService();

	public static void main(String[] args) {
		System.out.println("Welcome!\n" + "This is a bookstore. Ready to read?");
		menu();
	}

	private static void menu() {
		System.out.println("Main menu\n" + "1. View/update books\n" + "2. View/update genres\n"
				+ "3. View/update authors\n" + "4. Add book\n" + "5. Add genre\n" + "6. Add author");
		int option = 0;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println("Sorry, you must enter a number between 1 and 6.");
			menu();
		}
		
		switch (option) {
		case 1:
			viewBooks();
			break;
		case 2:
			viewGenres();
			break;
		case 3:
			break;
		case 4:
			addBook();
			break;
		case 5:
			break;
		case 6:
			break;
		}
	}
	
	private static void viewBooks() {
		System.out.println("Current books:");
		BookDAO bdao = new BookDAO();
		bdao.findAll().forEach(System.out::println);
	}
	
	private static void viewGenres() {
		System.out.println("Current genres:");
		gService.getAll().forEach(System.out::println);
	}
	
	private static void addBook() {
		System.out.println("Book title:");
		String title = scanner.nextLine();
		System.out.println("ISBN:");
		String isbn = scanner.nextLine();
		System.out.println("Price:");
		// TODO: validate input.
		double price = Double.parseDouble(scanner.nextLine());
		System.out.println("Genre ID:");
		List<Genre> genres = gService.getAll();
		for (int i = 0; i < genres.size(); i++) {
			System.out.println((i + 1) + ": " + genres.get(i));
		}
		int genreIndex = Integer.parseInt(scanner.nextLine()) - 1;
		int genreId = genres.get(genreIndex).getId();
	}
}
