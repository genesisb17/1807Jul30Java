package com.ex.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_USERS")
public class User {
	
@Id
@SequenceGenerator(name="BU_ID" ,sequenceName="BU_ID")
@GeneratedValue(generator="BU_ID",strategy=GenerationType.SEQUENCE)
@Column
private int id;

@Column(nullable=false)
private String firstName;

@Column(nullable=false)
private String lastNamee;

@Column(nullable=false,unique=true)
private String username;

@Column(nullable=false)
private String password;
public User() {
	super();
}
public int getId() {
	return id;
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
public String getLastNamee() {
	return lastNamee;
}
public void setLastNamee(String lastNamee) {
	this.lastNamee = lastNamee;
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
}
