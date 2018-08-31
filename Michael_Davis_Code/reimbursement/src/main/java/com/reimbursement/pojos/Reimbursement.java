package com.reimbursement.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	private int id;
	private double amount;
	private Timestamp submittedTime;
	private Timestamp resolvedTime;
	private String description;
	private Blob receipt;
	private int author;
	private int resolver;
	private int statusid;
	private int typeid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getSubmittedTime() {
		return submittedTime;
	}
	public void setSubmittedTime(Timestamp submittedTime) {
		this.submittedTime = submittedTime;
	}
	public Timestamp getResolvedTime() {
		return resolvedTime;
	}
	public void setResolvedTime(Timestamp resolvedTime) {
		this.resolvedTime = resolvedTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	
	public Reimbursement(double amount, String description, int typeid) {
		super();
		this.amount = amount;
		this.description = description;
		this.typeid = typeid;
	}
	public Reimbursement(int id, int amount, Timestamp submittedTime, String description, int author, int typeid) {
		super();
		this.id = id;
		this.amount = amount;
		this.submittedTime = submittedTime;
		this.description = description;
		this.author = author;
		this.typeid = typeid;
	}
	public Reimbursement(int amount, Timestamp submittedTime, String description, int author, int typeid) {
		super();
		this.amount = amount;
		this.submittedTime = submittedTime;
		this.description = description;
		this.author = author;
		this.typeid = typeid;
	}
	public Reimbursement(int amount, Timestamp submittedTime, Timestamp resolvedTime, String description, Blob receipt,
			int author, int resolver, int statusid, int typeid) {
		super();
		this.amount = amount;
		this.submittedTime = submittedTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.typeid = typeid;
	}
	public Reimbursement(int id, int amount, Timestamp submittedTime, Timestamp resolvedTime, String description,
			Blob receipt, int author, int resolver, int statusid, int typeid) {
		super();
		this.id = id;
		this.amount = amount;
		this.submittedTime = submittedTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.typeid = typeid;
	}
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submittedTime=" + submittedTime + ", resolvedTime="
				+ resolvedTime + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", statusid=" + statusid + ", typeid=" + typeid + "]";
	}
	
	

}
