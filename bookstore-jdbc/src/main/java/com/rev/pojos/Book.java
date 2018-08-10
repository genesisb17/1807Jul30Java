package com.rev.pojos;

public class Book {
	
	private int id;
	private String ISBN;
	private String title;
	private Double price;
	private String genre_id;
	
	public Book() {}
	
	public Book(int id, String iSBN, String title, Double price, String genre_id) {
		super();
		this.id = id;
		ISBN = iSBN;
		this.title = title;
		this.price = price;
		this.genre_id = genre_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN=" + ISBN + ", title="
				+ title + ", price=" + price + ", genre_id=" + genre_id
				+ "]";
	}

	
	

}
