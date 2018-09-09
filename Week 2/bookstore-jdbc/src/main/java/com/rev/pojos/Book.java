package com.rev.pojos;

public class Book {
	private int id;
	private String isbn;
	private String title;
	private double price;
	private int genreId;
	
	public Book() {}
	
	public Book(String isbn, String title, double price, int genreId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genreId = genreId;
	}

	public Book(int id, String isbn, String title, double price, int genreId) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genreId = genreId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", genreId=" + genreId
				+ "]";
	}
	
	
	
	
}
