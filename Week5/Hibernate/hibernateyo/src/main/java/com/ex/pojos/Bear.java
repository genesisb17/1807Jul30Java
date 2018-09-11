package com.ex.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEARS")
public class Bear {
	
	@Id
	@Column(name="B_ID")
	@SequenceGenerator(name = "B_SEQ_GEN", sequenceName="BEAR_SEQ")
	@GeneratedValue(generator="B_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int bearId;
	
	@Column
	private String furColor;
	
	@Column
	private double height;
	
	@Column(nullable=false)
	private String breed;
	
	public Bear() {}
	
	public Bear(int bearId, String furColor, double height, String breed) {
		super();
		this.bearId = bearId;
		this.furColor = furColor;
		this.height = height;
		this.breed = breed;
	}

	public int getBearId() {
		return bearId;
	}

	public void setBearId(int bearId) {
		this.bearId = bearId;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
}
