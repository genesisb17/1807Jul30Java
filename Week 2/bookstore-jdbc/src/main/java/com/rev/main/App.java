package com.rev.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.rev.pojos.Book;
import com.rev.pojos.Genre;
import com.rev.service.GenreService;

public class App {
	
	static Scanner scanner = new Scanner(System.in);
	static GenreService gService = new GenreService();
	
	public static void main(String[] args) {
		/*
		 * BOOK STORE APP DRIVER
		 */
		menu();
		
	}
	
	static void menu() {
		System.out.println("----------Main Menu----------\n"
				+ "1. View/ Books\n"
				+ "2. View/ Genres\n"
				+ "3. View/ Authors\n"
				+ "4. Add Book\n"
				+ "5. Add Genre\n"
				+ "6. Add Author");
		int option = 0;
		try{
			option = Integer.parseInt(scanner.nextLine());
		} catch(InputMismatchException e) {
			System.out.println("Sorry you must enter a number between 1 and 6.");
			menu();
		} catch(NumberFormatException e) {
			System.out.println("Please enter a valid number between 1 and 6.");
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
				break;
		}
	}
	
		static void viewGenres() {
			System.out.println("Current Genres: ");
			List<Genre> genres = gService.getAll();
			for(Genre g: genres) {
				System.out.println(g.getName());
			}
		}
	
		/*static void addBook() {
			System.out.println("enter your book's title: ");
			String title = scanner.nextLine();
			System.out.println("Enter the ISBN (10-digit number");
			String isbn = scanner.nextLine();
			System.out.println("Enter the price: ");
			double price = Double.parseDouble(scanner.nextLine());
			System.out.println("Enter your Genre(Enter its number)");
			List<Genre> genres = gService.getAll();
			for(int i = 0; i < genres.size(); i++) {
				System.out.println(i + 1 + ": " + genres.get(i));
			}
			int genreIndex = Integer.parseInt(scanner.nextLine())-1;
			int genreID = genres.get(genreIndex).getId();
			Book b = new Book(id, isbn, title, price, genreID);
		}*/
		
}
