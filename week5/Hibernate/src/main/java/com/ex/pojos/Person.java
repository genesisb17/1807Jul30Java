package com.ex.pojos;

public class Person {
	private int id;
	private String firstName;
	private String lastname;

	public int getId() {
		return id;
	}

	public Person() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
