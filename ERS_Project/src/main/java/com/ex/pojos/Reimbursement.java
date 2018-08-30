package com.ex.pojos;

import java.sql.Blob;
import java.util.Arrays;

public class Reimbursement {
	
	private int id;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private byte[] reciept;
	private String author;
	private String resolver;
	private int statusid;
	private int typeid;
	
	public Reimbursement() {}

	public Reimbursement(int id, double amount, String submitted, String resolved, String description, byte[] reciept,
			String author, String resolver, int statusid, int typeid) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.reciept = reciept;
		this.author = author;
		this.resolver = resolver;
		this.statusid = statusid;
		this.typeid = typeid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReciept() {
		return reciept;
	}

	public void setReciept(byte[] reciept) {
		this.reciept = reciept;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
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

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", reciept=" + Arrays.toString(reciept) + ", author=" + author
				+ ", resolver=" + resolver + ", statusid=" + statusid + ", typeid=" + typeid + "]";
	}
}
