package com.revature.pojo;

import java.sql.Blob;
import java.sql.Timestamp;

public class ErsReimbursement {
	private int reimbId;
	private int amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Blob reciept;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;

	public ErsReimbursement(int reimbId, int amount, Timestamp submitted, Timestamp resolved, String description,
			Blob reciept, int author, int resolver, int statusId, int typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.reciept = reciept;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public ErsReimbursement(int amount, Timestamp submitted, Timestamp resolved, String description, Blob reciept,
			int author, int resolver, int statusId, int typeId) {
		this(-1, amount, submitted, resolved, description, reciept, author, resolver, statusId, typeId);
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReciept() {
		return reciept;
	}

	public void setReciept(Blob reciept) {
		this.reciept = reciept;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", description=" + description + "]";
	}

}
