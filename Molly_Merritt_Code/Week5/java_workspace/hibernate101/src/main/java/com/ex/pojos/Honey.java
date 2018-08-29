package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEYPOTS")
public class Honey {
	
	@Id
	@Column(name="HP_ID")
	@SequenceGenerator(name="HP_SEQ_GEN", sequenceName="HP_SEQ")
	@GeneratedValue(generator="HP_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column	// not necessary
	private double weight;
	
	@Column
	private String honey;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return weight;
	}

	public void setAmount(double weight) {
		this.weight = weight;
	}

	public String getHoney() {
		return honey;
	}

	public void setHoney(String honey) {
		this.honey = honey;
	}	
	
	

}
