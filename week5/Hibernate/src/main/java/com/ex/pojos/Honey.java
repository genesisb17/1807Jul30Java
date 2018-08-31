package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity//needed
@Table(name="HONEYPOTS")
public class Honey {
	@Id
	@Column(name="H_ID")
	@SequenceGenerator(name="h_seq_gen",sequenceName="HONEY_SEQ")
	@GeneratedValue(generator="h_seq_gen",strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	public Honey() {
		super();
	}

	@Column
	private double amount;
	
	@Column
	private String honey;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getHoney() {
		return honey;
	}

	public void setHoney(String honey) {
		this.honey = honey;
	}
	

}
