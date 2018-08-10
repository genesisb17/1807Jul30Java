package com.app.main;


import java.util.List;
import java.util.Scanner;

import com.ex.pojo.Books;
import com.ex.pojo.Genre;
import com.ex.service.BookService;
import com.ex.service.GenreService;

public class App 
{
	/*
	 * should NOT interact directly with DAO layer!
	 * only the service layer
	 */
	
	static Scanner scanner =  new Scanner(System.in);
	static GenreService gService = new GenreService();
	static BookService bService = new BookService();
	
	public static void main(String[] args) 
	{
		List<Books> book = bService.getAll();
		for(Books b : book)
		{
			System.out.println(b);
		}
		
		System.out.println("WELCOME!\n"
				+ "Ready to Read?!");
		menu();
	}
	
	static void menu()
	{
		System.out.println("\n");
		System.out.println("---Main Menu---\n"
				+ "1. View/Update Books\n"
				+ "2. View/Update Genres\n"
				+ "3. View/Update AUthors\n"
				+ "4. View Books\n"
				+ "5. Add Genre\n"
				+ "6. Add Author");
		int option = 0;
		
		
		try
		{
			option = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Sorry please enter a valid input");
			menu();
		}
		
		switch(option)
		{
			case 1:
				break;
			case 2:
				viewGenres();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
		}
	}
	
	static void viewGenres() {
		System.out.println("Current Genres:");
		List<Genre> genres = gService.getAll();
		for(Genre g : genres)
		{
			System.out.println(g);
		}		
	}
	
	static void addBook()	
	{
		System.out.println("Enter your books title");
		String title = scanner.nextLine();
		System.out.println("Enter ISBN");
		String isbn = scanner.nextLine();
		System.out.println("Enter Price");
		double price = Double.parseDouble(scanner.nextLine());
		System.out.println("Select your genre(enter its number)");
		List<Genre> genres = gService.getAll();
		
		for (int i = 0; i < genres.size(); i++)
		{
			int genreIndex = Integer.parseInt(scanner.nextLine()) - 1;
			int genreID = genres.get(genreIndex).getId();
			Books b = new Books(title, isbn, price, genreID);
			//bService.save(b); -- need to create save in service layer
		}
	}
}





