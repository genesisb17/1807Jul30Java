package com.rev.pojos;

import java.sql.Timestamp;

public class ReimbursementTicket {
	
	private long reimb_id;
	private double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private long reimb_author;
	private long reimb_resolver;
	private String reimb_type;
	ReimbursementTicket(){}
	public ReimbursementTicket(long reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, long reimb_author, long reimb_resolver, String reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_type = reimb_type;
	}
	public long getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(long reimb_id) {
		this.reimb_id = reimb_id;
	}
	public double getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public long getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(long reimb_author) {
		this.reimb_author = reimb_author;
	}
	public long getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(long reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public String getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	

}
