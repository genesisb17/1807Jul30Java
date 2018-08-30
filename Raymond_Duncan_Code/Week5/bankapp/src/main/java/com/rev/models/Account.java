package com.rev.models;

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
@Table(name="ACCOUNTS")
public class Account {
	
	@Id
	@Column(name="ACCT_ID")
	@SequenceGenerator(name="ACCT_ID",sequenceName="ACCT_ID")
	@GeneratedValue(generator="ACCT_ID",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="OWNER_ID")
	private User owner;
	
	@Column(nullable=false)		// @NotNull is also acceptable here
	@Size(min=3, max=32)
	private String name;
	
	@Column(nullable=false)
	@Min(0)						// TODO This should eventually be changed to allow overdrafting!
	private double balance;

	public Account() {}

	public Account(User owner, String name, double balance) {
		super();
		this.owner = owner;
		this.name = name;
		this.balance = balance;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", owner=" + owner + ", name=" + name + ", balance=" + balance + "]";
	};
	
	
	
}
