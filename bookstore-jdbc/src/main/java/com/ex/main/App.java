package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Book;
import com.ex.pojos.Genre;
import com.ex.service.BookService;
import com.ex.service.GenreService;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static GenreService gService = new GenreService();
	static BookService bService = new BookService();

	public static void main(String[] args) {
		/*
		 * BOOK STORE APP DRIVER
		 * should NOT interact directly with DAO layer!
		 * only the service layer
		 */
		System.out.println("WELCOME!\n"
				+ "Ready to Read?!");
		menu();
		
//		Dao dao = new BookDao();
//		Book b = new Book();
//		b.setGenreId(22);
//		b.setIsbn("91849789");
//		b.setTitle("Testing");
//		b.setPrice(10);
//		dao.save(b);
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
		case 1: viewBooks(); break;
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
	
	static void viewBooks() {
		//call service layer --> dao layer getAll
		//print out all books
		//allow user to edit or update books from here
	}
	
	static void addBook() {
		System.out.println("Enter your book's title:");
		String title = scanner.nextLine();
		System.out.println("Enter the ISBN (10-digit number):");
		/*
		 * SHOULD DO SOME INPUT VALIDATION
		 * make sure its 10 NUMBER digits -- input validation
		 * 
		 */
		
		String isbn = scanner.nextLine();
		System.out.println("Enter the price:");
		double price = Double.parseDouble(scanner.nextLine()); //SURROUND IN TRY CATCH FOR NFE
		System.out.println("Select your Genre(Enter its number)");
		List<Genre> genres = gService.getAll();
		for(int i = 0; i < genres.size(); i++) {
			System.out.println(i+1 + ": " + genres.get(i).getName());
		}
		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
		int genreID = genres.get(genreIndex).getId();
		Book b = new Book(isbn, title, price, genreID);
		//call book service addBook() which calls dao addBook()
		//WE HAVE MAINTAINED REFERENTIAL INTEGRITY
		b = bService.addBook(b);
		System.out.println(b.toString());
		System.out.println("Now who wrote the book! If it is one of"
				+ " our well known authors below, please enter the"
				+ " number next to their name. If not, please "
				+ "write No/N");
		String in = scanner.nextLine();
		
		//if No, call add author, and automatically add that 
		//author id to the book 
	
	}
	static void viewGenres() {
		System.out.println("Current Genres:");
		List<Genre> genres = gService.getAll();
		for(Genre g : genres) {
			System.out.println(g.getName());
		}
	}

}
