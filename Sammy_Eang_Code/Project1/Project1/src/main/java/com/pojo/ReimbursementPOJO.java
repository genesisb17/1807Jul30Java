package com.pojo;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReimbursementPOJO {

	private int reimb_id;
	private double reimb_amount;
	private Timestamp date_submitted;
	private Timestamp date_resolved;
	private String reimb_description;
	//receipt 
	private int author_id;
	private int resolver_id;
	private int reimb_status_id;
	private int reimb_type_id;
	
	public ReimbursementPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementPOJO(double reimb_amount, Timestamp date_submitted, Timestamp date_resolved,
			String reimb_description, int author_id, int resolver_id, int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.reimb_description = reimb_description;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}
	
	public ReimbursementPOJO(int reimb_id, double reimb_amount, Timestamp date_submitted, Timestamp date_resolved,
			String reimb_description, int author_id, int resolver_id, int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.reimb_description = reimb_description;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	@Override
	public String toString() {
		return "ReimbursementPOJO [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", date_submitted="
				+ date_submitted + ", date_resolved=" + date_resolved + ", reimb_description=" + reimb_description
				+ ", author_id=" + author_id + ", resolver_id=" + resolver_id + ", reimb_status_id=" + reimb_status_id
				+ ", reimb_type_id=" + reimb_type_id + "]";
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Timestamp getDate_submitted() {
		return date_submitted;
	}

	public void setDate_submitted(Timestamp date_submitted) {
		this.date_submitted = date_submitted;
	}

	public Timestamp getDate_resolved() {
		return date_resolved;
	}

	public void setDate_resolved(Timestamp date_resolved) {
		this.date_resolved = date_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getResolver_id() {
		return resolver_id;
	}

	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}
	
	
	//---------------------------------------------------------------------------------------------------
	
}
