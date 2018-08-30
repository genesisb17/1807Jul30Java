package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEY")
public class Honey 
{
	@Id
	@Column(name="H_ID")
	@SequenceGenerator(name="H_SEQ_GEN", sequenceName="HONEY_SEQ")
	@GeneratedValue(generator="H_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;

	@Column
	private double amount;
	
	@Column
	private String honey;

	public Honey()
	{
		
	}
	
	@Override
	public String toString() {
		return "Honey [id=" + id + ", amount=" + amount + ", honey=" + honey + "]";
	}



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



	public Honey(int id, double amount, String honey) {
		super();
		this.id = id;
		this.amount = amount;
		this.honey = honey;
	}
	
	
}
