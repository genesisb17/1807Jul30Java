package com.pojo;

public class EmployeePOJO {

	private int emp_id;
	private String username;
	private String pw;
	private String first_name;
	private String last_name;
	private String email;
	private int user_role_id;
	
	public EmployeePOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeePOJO(String username, String pw, String first_name, String last_name, String email,
			int user_role_id) {
		super();
		this.username = username;
		this.pw = pw;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.user_role_id = user_role_id;
	}
	
	public EmployeePOJO(int emp_id, String username, String pw, String first_name, String last_name, String email,
			int user_role_id) {
		super();
		this.emp_id = emp_id;
		this.username = username;
		this.pw = pw;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.user_role_id = user_role_id;
	}

	@Override
	public String toString() {
		return "EmployeePOJO [emp_id=" + emp_id + ", username=" + username + ", pw=" + pw + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", user_role_id=" + user_role_id + "]";
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	
}
