package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
	
	@Size(min=15, message="Bio must be at least 15 characters.")
	private String bio;
	
	public Author() {
		super();
	}

	public Author(String firstName, String lastName, String bio) {
		super();
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
