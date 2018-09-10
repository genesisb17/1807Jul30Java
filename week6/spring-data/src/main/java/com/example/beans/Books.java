package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Books")
public class Books {
	@Id
	@Column(name="Book_ID")
	@SequenceGenerator(name="B_SEQ_GEN", sequenceName="B_SEQ")
	@GeneratedValue(generator="B_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(nullable=true)
	private String isbn;
	@Column(nullable=false)
	private String title;
	@Column(nullable=true)
	private double price;

	

}
