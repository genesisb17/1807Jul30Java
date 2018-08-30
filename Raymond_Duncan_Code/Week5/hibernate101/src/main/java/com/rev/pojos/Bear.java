package com.rev.pojos;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEARS")
public class Bear {
	
	@Id
	@Column(name="B_ID")
	@SequenceGenerator(name="B_SEQ_GEN", sequenceName="BEAR_SEQ")
	@GeneratedValue(generator="B_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int bearID;
	@Column
	private String furColor;
	private double Height;
	@Column(nullable=false)
	private String breed;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="BEAR_CAVE")
	private Cave home;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="HONEY_POT")
	private Honey honey;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PARENT_TO_CUB", joinColumns=@JoinColumn(name="PARENT_ID"), inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private Set<Bear> bearCubs;
	//Self referencing many-to-many relationship
	
	public Bear() {}
	public Bear(String furColor, double height, String breed, Cave home, Honey honey, Set<Bear> bearCubs) {
		super();
		this.furColor = furColor;
		Height = height;
		this.breed = breed;
		this.home = home;
		this.honey = honey;
		this.bearCubs = bearCubs;
	}
	public int getBearID() {
		return bearID;
	}
	public void setBearID(int bearID) {
		this.bearID = bearID;
	}
	public String getFurColor() {
		return furColor;
	}
	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	public double getHeight() {
		return Height;
	}
	public void setHeight(double height) {
		Height = height;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Cave getHome() {
		return home;
	}
	public void setHome(Cave home) {
		this.home = home;
	}
	public Honey getHoney() {
		return honey;
	}
	public void setHoney(Honey honey) {
		this.honey = honey;
	}
	public Set<Bear> getBearCubs() {
		return bearCubs;
	}
	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}
	@Override
	public String toString() {
		return "Bear [bearID=" + bearID + ", furColor=" + furColor + ", Height=" + Height + ", breed=" + breed
				+ ", home=" + home + ", honey=" + honey + ", bearCubs=" + bearCubs + "]";
	}
	
	
	
	
}
