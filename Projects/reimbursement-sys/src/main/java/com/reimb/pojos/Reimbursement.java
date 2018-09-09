package com.reimb.pojos;

import java.util.Date;

public class Reimbursement {
	private String descrip;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String fname;
	private String lname;
	private String useremail;
	private int usersid;
	private int userroleid;
	private int reimbid;
	private int reimbtypeid;
	private int statustypeid;
	private int amt;
	private int author;
	private int resolver;
	private int type;
	private String status;
	private String reimbtype;
	private String submitted;
	private String resolved;
	
	public Reimbursement() {}
		
	


	public Reimbursement(String descrip, String username, String password, String firstname, String lastname,
			String fname, String lname, String useremail, int usersid, int userroleid, int reimbid, int reimbtypeid,
			int statustypeid, int amt, String submitted, String resolved, int author, int resolver, int type, String status,
			String reimbtype) {
		super();
		this.descrip = descrip;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fname = fname;
		this.lname = lname;
		this.useremail = useremail;
		this.usersid = usersid;
		this.userroleid = userroleid;
		this.reimbid = reimbid;
		this.reimbtypeid = reimbtypeid;
		this.statustypeid = statustypeid;
		this.amt = amt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
		this.reimbtype = reimbtype;
	}




	public String getDescrip() {
		return descrip;
	}




	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
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




	public String getUseremail() {
		return useremail;
	}




	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}




	public int getUsersid() {
		return usersid;
	}




	public void setUsersid(int usersid) {
		this.usersid = usersid;
	}




	public int getUserroleid() {
		return userroleid;
	}




	public void setUserroleid(int userroleid) {
		this.userroleid = userroleid;
	}




	public int getReimbid() {
		return reimbid;
	}




	public void setReimbid(int reimbid) {
		this.reimbid = reimbid;
	}




	public int getReimbtypeid() {
		return reimbtypeid;
	}




	public void setReimbtypeid(int reimbtypeid) {
		this.reimbtypeid = reimbtypeid;
	}




	public int getStatustypeid() {
		return statustypeid;
	}




	public void setStatustypeid(int statustypeid) {
		this.statustypeid = statustypeid;
	}




	public int getAmt() {
		return amt;
	}




	public void setAmt(int amt) {
		this.amt = amt;
	}




	public String getSubmitted() {
		return submitted;
	}




	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}




	public String getResolved() {
		return resolved;
	}




	public void setResolved(String resolved) {
		this.resolved = resolved;
	}




	public int getAuthor() {
		return author;
	}




	public void setAuthor(int author) {
		this.author = author;
	}




	public int getResolver() {
		return resolver;
	}




	public void setResolver(int resolver) {
		this.resolver = resolver;
	}




	public int getType() {
		return type;
	}




	public void setType(int type) {
		this.type = type;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getReimbtype() {
		return reimbtype;
	}




	public void setReimbtype(String reimbtype) {
		this.reimbtype = reimbtype;
	}




	@Override
	public String toString() {
		return "Reimbursement [descrip=" + descrip + ", username=" + username + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", fname=" + fname + ", lname=" + lname
				+ ", useremail=" + useremail + ", usersid=" + usersid + ", userroleid=" + userroleid + ", reimbid="
				+ reimbid + ", reimbtypeid=" + reimbtypeid + ", statustypeid=" + statustypeid + ", amt=" + amt
				+ ", submitted=" + submitted + ", resolved=" + resolved + ", author=" + author + ", resolver="
				+ resolver + ", type=" + type + ", status=" + status + ", reimbtype=" + reimbtype + "]";
	}

	
	
}
