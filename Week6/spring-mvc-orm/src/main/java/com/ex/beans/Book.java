package com.ex.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BOOKS")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book")
	@SequenceGenerator(name="book", sequenceName="book_seq", allocationSize=1)
	@Column(name="BOOK_ID")
	private int id;
	
	@Column(unique=true, nullable=false)
	private String isbn;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private double price;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="GENRE_ID")
	private Genre genre;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="BOOK_AUTHORS",
			joinColumns=@JoinColumn(name="BOOK_ID"),
			inverseJoinColumns=@JoinColumn(name="AUTHOR_ID"))
	private Set<Author> authors;

	public Book() {}
	
	public Book(String isbn, String title, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	public Book(String isbn, String title, double price, Genre genre, Set<Author> authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genre = genre;
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", genre=" + genre
				+ ", authors=" + authors + "]";
	}
	
	

	
}