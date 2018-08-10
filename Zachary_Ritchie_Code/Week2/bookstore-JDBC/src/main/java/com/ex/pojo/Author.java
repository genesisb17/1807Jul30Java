package com.ex.pojo;

public class Author 
{
	private int Author_id;
	private String firstname;
	private String lastname;
	private String bio;
	
	public Author() {}
	
	public Author(int author_id, String firstname, String lastname, String bio) {
		super();
		Author_id = author_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bio = bio;
	}

	public int getAuthor_id() {
		return Author_id;
	}

	public void setAuthor_id(int author_id) {
		Author_id = author_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author [Author_id=" + Author_id + ", firstname=" + firstname + ", lastname=" + lastname + ", bio=" + bio
				+ "]";
	}
	
	
}
