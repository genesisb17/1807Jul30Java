package com.iantimothyjohnson.notes.week5.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Account {
	@Id
	@SequenceGenerator(name = "seq_account_id", sequenceName = "seq_account_id")
	@GeneratedValue(generator = "seq_account_id", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User owner;
	
	@Column(nullable = false, scale = 2)
	@Min(0)
	private double balance;
	
	@Column(nullable = false)
	@Size(min = 3, max = 32)
	private String name;

	public Account() {
	}

	public Account(User owner, double balance, String name) {
		this.owner = owner;
		this.balance = balance;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", owner=" + owner + ", balance=" + balance + ", name=" + name + "]";
	}
}
