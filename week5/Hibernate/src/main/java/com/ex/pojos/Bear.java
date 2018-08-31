package com.ex.pojos;

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

@Entity
@Table(name="BEARS")
public class Bear {
	@Id
	@Column(name="B_ID")
	@SequenceGenerator(name="b_seq_gen",sequenceName="BEAR_SEQ")
	@GeneratedValue(generator="b_seq_gen",strategy=GenerationType.SEQUENCE)
	private int bearId;
	
	@Column(nullable=false)
	private String breed;
	
	
	@Column
	private String furColor;
	
	
	@Column
	private double height;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="BEAR_CAVE")
	private Cave home;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PARENT_CUB", joinColumns=@JoinColumn(name="PARENT_ID"),
	inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private Set<Bear> bearCubs;
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", breed=" + breed + ", furColor=" + furColor + ", height=" + height
				+ ", home=" + home + ", bearCubs=" + bearCubs + "]";
	}




	public Bear(String breed, String furColor, double height, Cave home, Set<Bear> bearCubs) {
		super();
		this.breed = breed;
		this.furColor = furColor;
		this.height = height;
		this.home = home;
		this.bearCubs = bearCubs;
	}




	public Bear(int bearId, String breed, String furColor, double height, Cave home, Set<Bear> bearCubs) {
		super();
		this.bearId = bearId;
		this.breed = breed;
		this.furColor = furColor;
		this.height = height;
		this.home = home;
		this.bearCubs = bearCubs;
	}




	public int getBearId() {
		return bearId;
	}




	public void setBearId(int bearId) {
		this.bearId = bearId;
	}




	public String getBreed() {
		return breed;
	}




	public void setBreed(String breed) {
		this.breed = breed;
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




	public Cave getHome() {
		return home;
	}




	public void setHome(Cave home) {
		this.home = home;
	}




	public Set<Bear> getBearCubs() {
		return bearCubs;
	}




	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}




	public Bear() {
		super();
	}
	
	
}