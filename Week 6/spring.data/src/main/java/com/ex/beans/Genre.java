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
@Table(name="GENRES")
public class Genre {
	
	@Id
	@Column(name="GENRE_ID")
	@SequenceGenerator(name="G_SEQ_GEN", sequenceName="G_SEQ")
	@GeneratedValue(generator="G_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	public Genre() {}
	
	public Genre(int id, String name) {
		super();
		this.id = id;
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
