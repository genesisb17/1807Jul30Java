package com.ex.pojos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ers_users 
{

	private int ers_user_id;
	private String ers_username;
	private String ers_password;
	private String ers_first_name;
	private String ers_last_name;
	private String user_email;
	private int user_role_id;

	public ers_users()
	{
		
	}
	
	public ers_users(int ers_user_id, String ers_username, String ers_password, String ers_first_name,
			String ers_last_name, String user_email, int user_role_id) {
		super();
		this.ers_user_id = ers_user_id;
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.ers_first_name = ers_first_name;
		this.ers_last_name = ers_last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}



	@Override
	public String toString() {
		return "ers_users [ers_user_id=" + ers_user_id + ", ers_username=" + ers_username + ", ers_password="
				+ ers_password + ", ers_first_name=" + ers_first_name + ", ers_last_name=" + ers_last_name
				+ ", user_email=" + user_email + ", user_role_id=" + user_role_id + "]";
	}



	public int getErs_user_id() {
		return ers_user_id;
	}

	public void setErs_user_id(int ers_user_id) {
		this.ers_user_id = ers_user_id;
	}

	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getErs_first_name() {
		return ers_first_name;
	}

	public void setErs_first_name(String ers_first_name) {
		this.ers_first_name = ers_first_name;
	}

	public String getErs_last_name() {
		return ers_last_name;
	}

	public void setErs_last_name(String ers_last_name) {
		this.ers_last_name = ers_last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	
	
}
