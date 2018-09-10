package com.example.beans;

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
@Table(name="Authors")
public class Author {
	@Id
	@Column(name="Author_ID")
	@SequenceGenerator(name="A_SEQ_GEN", sequenceName="A_SEQ")
	@GeneratedValue(generator="A_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	private String firstname;
	private String lastname;
	private String bio;
	
	public Author() {}

	public Author(int id, String firstname, String lastname, String bio) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", bio=" + bio + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
}
