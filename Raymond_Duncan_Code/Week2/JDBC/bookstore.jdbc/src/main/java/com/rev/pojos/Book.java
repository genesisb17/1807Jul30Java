package com.rev.pojos;

public class Book {
	/**
	 * 	
	 */
	
	private int bookID;
	private int genreID;
	private double price;
	private String isbn;
	private String  title;
	
	public Book() {}
	
	public Book(int bookID, double price, int genreID, String isbn, String title) {
		super();
		this.bookID = bookID;
		this.price = price;
		this.genreID = genreID;
		this.isbn = isbn;
		this.title = title;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getGenreID() {
		return genreID;
	}

	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", price=" + price + ", genreID=" + genreID + ", isbn=" + isbn + ", title=" + title + "]";
	}
	
	

}
