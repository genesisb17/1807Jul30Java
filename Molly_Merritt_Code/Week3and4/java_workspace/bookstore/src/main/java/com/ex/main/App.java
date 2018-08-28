package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Book;
import com.ex.pojos.Genre;
import com.ex.service.AuthorService;
import com.ex.service.BookService;
import com.ex.service.GenreService;

public class App {
	static Scanner scanner = new Scanner(System.in);
	static BookService bService = new BookService();
	static GenreService gService = new GenreService();
	static AuthorService aService = new AuthorService();
	
	public static void main(String[] args) {
//		List<Genre> genres = gService.getAll();
//		for(int i=0; i<genres.size(); i++) {
//			System.out.println(i+1 + ": " + genres.get(i));
//		}
//		Genre g = new Genre();
//		g.setName("Fiction");
//		gService.addGenre(g);
		
		
//		List<Book> books = bService.getAll();
//		for(int i=0; i<books.size(); i++) {
//			System.out.println(i+1 + ": " + books.get(i));
//		}
		addBook();
	}
	
	static void addBook() {
		System.out.println("Enter your book's title:");
		String title = scanner.nextLine();
		System.out.println("Enter the ISBN (10-digit number):");
		String isbn = scanner.nextLine();
		System.out.println("Enter the price:");
		double price = Double.parseDouble(scanner.nextLine());	// SURROUND IN TRY CATCH
		System.out.println("Select your Genre (Enter its number)");
		List<Genre> genres = gService.getAllGenres();
		for(int i=0; i<genres.size(); i++) {
			System.out.println(i+1 + ": " + genres.get(i));
		}
		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
		int genreID = genres.get(genreIndex).getId();
		Book b = new Book(isbn, title, price, genreID);
		bService.addBook(b);
	}
	
//	static void viewGenres() {
//		System.out.println("Current Genres:");
//		List<Genre> genres = g.Service.getAll();
//		for (Genre g : genres) {
//			System.out.println
//		}
//	}

}
