package com.iantimothyjohnson.notes.week5.hellohibernate.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "caves")
public class Cave {
	@Id
	@Column(name = "cave_id")
	@SequenceGenerator(name = "seq_cave_id", sequenceName = "seq_cave_id", allocationSize = 5, initialValue = 100)
	@GeneratedValue(generator = "seq_cave_id", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "sqft")
	private double squareFootage;
	@Column
	private double rent;

	public Cave() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(rent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(squareFootage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cave other = (Cave) obj;
		if (id != other.id) {
			return false;
		}
		if (Double.doubleToLongBits(rent) != Double.doubleToLongBits(other.rent)) {
			return false;
		}
		if (Double.doubleToLongBits(squareFootage) != Double.doubleToLongBits(other.squareFootage)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", squareFootage=" + squareFootage + ", rent=" + rent + "]";
	}
}
