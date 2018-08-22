package com.ex.pojo;

public class Books 
{
	private int book_id;
	private String isb;
	private String title;
	private double price;
	private int genre_id;
	
	public Books() {}
	
	public Books(String isb, String title, double price, int genre_id) {
		super();
		//this.book_id = book_id;
		this.isb = isb;
		this.title = title;
		this.price = price;
		this.genre_id = genre_id;
	}



	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", isb=" + isb + ", title=" + title + ", price=" + price + ", genre_id="
				+ genre_id + "]";
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getIsb() {
		return isb;
	}
	public void setIsb(String isb) {
		this.isb = isb;
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
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	
	
}
