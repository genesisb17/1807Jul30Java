package com.iantimothyjohnson.notes.week6.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Genre {
	@Id
	@SequenceGenerator(name = "seq_genre_id", sequenceName = "seq_genre_id")
	@GeneratedValue(generator = "seq_genre_id", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(nullable = false)
	private String name;
	
	public Genre() {
	}

	public Genre(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}
}
