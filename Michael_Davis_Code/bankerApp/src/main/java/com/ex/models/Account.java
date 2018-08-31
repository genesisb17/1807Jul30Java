package com.ex.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BANK_ACCOUNTS")
public class Account {

	@Id
	@Column(name = "ACC_ID")
	@SequenceGenerator(name = "BU_ID", sequenceName = "BU_ID")
	@GeneratedValue(generator = "BU_ID", strategy = GenerationType.SEQUENCE)

	private int id;

	@JoinColumn(name="OWNER_ID")
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private User owner;
	
	@Column
	@Size(min=3,max=32)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable=false)
	@Min(0)
	private double balance;

	

	public Account(int id, User owner, String name, double balance) {
		super();
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.balance = balance;
	}

	public Account() {
		super();
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

}
