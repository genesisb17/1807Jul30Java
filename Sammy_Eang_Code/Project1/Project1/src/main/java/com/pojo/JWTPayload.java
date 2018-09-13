package com.pojo;

public class JWTPayload {

	private String username;
	private String pw;
	private String secret;
	
	public JWTPayload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JWTPayload(String username, String password, String secret) {
		super();
		this.username = username;
		this.pw = password;
		this.secret = secret;
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

	public void setPw(String password) {
		this.pw = password;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
}
