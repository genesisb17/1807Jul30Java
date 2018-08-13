package com.rev.pojos;

public class Author {
	/*
	 * Author_ID number(10) PRIMARY KEY, 
	 * First_Name varchar2(256) NOT NULL,
	 * Last_Name varchar2(256), 
	 * Biography varchar2(2048)
	 */
	
	private int authorID;
	private String firstName;
	private String lastName;
	private String bio;
	
	public Author() {}
	
	public Author(int authorID, String firstName, String lastName, String bio) {
		super();
		this.authorID = authorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", firstName=" + firstName + ", lastName=" + lastName + ", bio=" + bio
				+ "]";
	}
	
	
}
