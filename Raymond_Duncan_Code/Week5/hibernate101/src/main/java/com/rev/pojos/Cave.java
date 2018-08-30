package com.rev.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVES")
public class Cave {

	@Id
	@Column
	@SequenceGenerator(name="C_ID_SEQ", sequenceName="C_ID_SEQ", allocationSize=5)
	@GeneratedValue(generator="C_ID_SEQ")
	private int caveID;
	
	@Column(name="SQFT")
	private double squareFootage;
	
	@Column
	private double rent;
	
	public Cave() {}

	public Cave(int caveID, double squareFootage, double rent) {
		super();
		this.caveID = caveID;
		this.squareFootage = squareFootage;
		this.rent = rent;
	}

	public int getCaveID() {
		return caveID;
	}

	public void setCaveID(int caveID) {
		this.caveID = caveID;
	}

	public double getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Cave [caveID=" + caveID + ", squareFootage=" + squareFootage + ", rent=" + rent + "]";
	}
	
	
}
