package com.ex.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
@Table(name="BANK_ACCOUNTS")
public class Account {

	@Id
	@Column(name="ACC_ID")
	@SequenceGenerator(name="ACC_ID", sequenceName="ACC_ID")
	@GeneratedValue(generator="ACC_ID", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="OWNER_ID")
	private User owner;
	
	@NotNull
	@Size(min=3, max = 32)
	private String name;
	
	@NotNull
	@Min(0)
	private double balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, User owner, String name, double balance) {
		super();
		this.id = id;
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
	}
	
}
