package com.iantimothyjohnson.notes.week6.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Author {
	@Id
	@SequenceGenerator(name = "seq_author_id", sequenceName = "seq_author_id")
	@GeneratedValue(generator = "seq_author_id", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Size(min = 15, message = "Bio must be at least 15 characters.")
	private String bio;

	public Author() {
	}

	public Author(String firstName, String lastName, String bio) {
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
