package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="AUTHORS")
public class Author {
	
	@Id
	@Column(name="AUTHOR_ID")
	@SequenceGenerator(name="A_SEQ_GEN", sequenceName="A_SEQ", allocationSize=1)
	@GeneratedValue(generator="A_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	private String firstName;
	private String lastName;
	private String bio;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String firstName, String lastName, String bio) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
	}
	
	public Author(int id, String firstName, String lastName, String bio) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
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
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", bio=" + bio + "]";
	}
	
}
