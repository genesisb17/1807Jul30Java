package com.reimbursement.pojos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	public User() {
		super();
	}
	private int userid;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String username;
	private String userpassword;
	private String usersalt=null;
	private int userrole;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsersalt() {
		return usersalt;
	}
	public void setUsersalt(String usersalt) {
		this.usersalt = usersalt;
	}
	public int getUserrole() {
		return userrole;
	}
	
	public User(int userid, String fname, String lname, String email, String phone, String username,
			String userpassword, String usersalt, int userrole) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.userpassword = userpassword;
		this.usersalt = usersalt;
		this.userrole = userrole;
	}
	
	public User(String fname, String lname, String email, String phone, String username, String userpassword,
			int userrole) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.userpassword = userpassword;
		this.userrole = userrole;
	}
	public User(String fname, String lname, String email, String phone, String username, String userpassword,
			String usersalt, int userrole) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.userpassword = userpassword;
		this.usersalt = usersalt;
		this.userrole = userrole;
	}
	public void setUserrole(int userrole) {
		this.userrole = userrole;
	}

}
