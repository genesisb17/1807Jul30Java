package com.account.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="MS_ACCOUNT")
public class Account {

	@Id
	@Column(name = "ACC_ID")
	@SequenceGenerator(name="MS_ACC_ID",sequenceName = "MS_ACC_ID" )
	@GeneratedValue(generator="MS_ACC_ID",strategy=GenerationType.SEQUENCE)
	private int id;
	private int customerId;
	private double balance;
	
	public Account() {}
	
	
	public Account( int customerId, double balance) {
		super();
		this.customerId = customerId;
		this.balance = balance;
	}
	
	public Account(int id, int customerId, double balance) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}