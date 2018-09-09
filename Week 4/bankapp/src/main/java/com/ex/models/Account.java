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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="BANK_ACCOUNTS")
public class Account {

	@Id
	@Column(name="ACC_ID")
	@SequenceGenerator(name = "ACC_ID", sequenceName="ACC_ID")
	@GeneratedValue(generator="ACC_ID", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="OWNER_ID")
	private User owner;
	
	@NotNull
	@Min(0)
	private double balance;
	
	@NotNull
	@Size(min=3, max=32)
	private String name;
	
	public Account(int id, User owner, double balance, String name) {
		super();
		this.id = id;
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
