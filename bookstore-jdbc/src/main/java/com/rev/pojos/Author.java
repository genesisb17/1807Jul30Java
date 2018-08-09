package com.rev.pojos;

public class Author {
	
	private int id;
	private String First_Name;
	private String Last_Name;
	private String Bio;
	
	public Author() {}
	
	public Author(int id, String first_Name, String last_Name, String bio) {
		super();
		this.id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getBio() {
		return Bio;
	}

	public void setBio(String bio) {
		Bio = bio;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Bio=" + Bio + "]";
	}
}
