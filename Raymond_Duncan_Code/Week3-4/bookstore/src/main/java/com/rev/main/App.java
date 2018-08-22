package com.rev.main;

import java.util.List;
import java.util.Scanner;

import com.rev.dao.BookDAO;
import com.rev.pojos.Book;
import com.rev.pojos.Genre;
import com.rev.services.GenreService;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static BookDAO bookDAO= new BookDAO();
	static GenreService genreService = new GenreService();
	
	public static void main(String[] args) {
		/*
		 * BOOK STORE APP DRIVER
		 */
		System.out.println("Welcome to our store!");
		bookDAO.findAll();
	}
	
	static void mainMenu() {
		boolean leaveMenu;
		do {
			leaveMenu = true;
			System.out.println("============================== MAIN MENU ==============================\n"
					+ "Please select an option:\n"
					+ "1. View Books\n"
					+ "2. View Genres\n"
					+ "3. View Authors\n"
					+ "4. Add Book\n"
					+ "5. Add Genre\n"
					+ "6. Add Author\n"
					+ "=======================================================================");

			int option = 0;
			while(true) {
				try {
					option = Integer.parseInt(scanner.nextLine());
					break;

				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid selection");
				}
			}

			switch(option) {
			case 1:
				break;
			case 2:
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
			default:
				leaveMenu = false;
			}
		} while(!leaveMenu);
	}

	private static void addBook() {
		System.out.println("What is your book's title?");
		String title = scanner.nextLine();
		System.out.println("What is the book's ISBN (10 digit number)");
		String isbn = scanner.nextLine();
		System.out.println("Enter the price");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.println("Selct your Genre(Enter the GenreID)");
		List<Genre> genres = genreService.getAll();
		for(int i = 0; i < genres.size(); i++) {
			System.out.println(i+1 + ": " + genres.get(i));
		}
		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
		int genreID = genres.get(genreIndex).getId();
		Book book = new Book(1,price,genreID,isbn,title);
		//Call book service addBook() which calls DAO addBook()
		//THUS WE HAVE MAINTAINED REFERENTIAL INTEGRITY
		
	}
	
}
