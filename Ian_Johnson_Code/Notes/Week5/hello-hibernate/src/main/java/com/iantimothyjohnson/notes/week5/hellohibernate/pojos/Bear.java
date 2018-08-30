package com.iantimothyjohnson.notes.week5.hellohibernate.pojos;

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
@Table(name = "bears")
public class Bear {
	@Id
	@Column(name = "b_id")
	@SequenceGenerator(name = "seq_b_id", sequenceName = "bear_seq")
	@GeneratedValue(generator = "seq_b_id", strategy = GenerationType.SEQUENCE)
	private int bearId;
	@Column
	private String furColor;
	@Column
	private double height;
	@Column(nullable = false)
	private String breed;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "bear_cave")
	private Cave home;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "honeypot")
	private Honey potOfHoney;
	// Self-referencing many-to-many relationship:
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "parent_cub", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "cub_id"))
	private Set<Bear> bearCubs;

	public Bear() {
	}

	public Bear(String furColor, double height, String breed, Cave home, Honey potOfHoney, Set<Bear> bearCubs) {
		this.furColor = furColor;
		this.height = height;
		this.breed = breed;
		this.home = home;
		this.potOfHoney = potOfHoney;
		this.bearCubs = bearCubs;
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

	public Cave getHome() {
		return home;
	}

	public void setHome(Cave home) {
		this.home = home;
	}

	public Honey getPotOfHoney() {
		return potOfHoney;
	}

	public void setPotOfHoney(Honey potOfHoney) {
		this.potOfHoney = potOfHoney;
	}

	public Set<Bear> getBearCubs() {
		return bearCubs;
	}

	public void setBearCubs(Set<Bear> bearCubs) {
		this.bearCubs = bearCubs;
	}

	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", furColor=" + furColor + ", height=" + height + ", breed=" + breed
				+ ", home=" + home + ", potOfHoney=" + potOfHoney + ", bearCubs=" + bearCubs + "]";
	}
}
