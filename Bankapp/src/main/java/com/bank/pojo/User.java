package com.bank.pojo;

public class User {
	//Getting all the variables of the user attempting to login
	private int id;
	private String name;
	private String lname;
	private String uname;
	private String pword;

public User() {}
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}