package com.revature.pojos;

public class Author {
	
	private int	author_id;
	private String first;
	private String last;
	private String biography;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int author_id, String first, String last, String biography) {
		super();
		this.author_id = author_id;
		this.first = first;
		this.last = last;
		this.biography = biography;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	
}
