package com.revature.pojo;

import java.sql.Blob;
import java.sql.Timestamp;

public class ErsReimbursement {
	private int reimbId;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Blob reciept;
	private String author;
	private int authorId;
	private String resolver;
	private int resolverId;
	private String status;
	private String type;
	private int typeId;
	
	public ErsReimbursement() {	}
	
	public ErsReimbursement(int reimbId, int resolverId) {
		this.reimbId = reimbId;
		this.resolverId = resolverId;
	}
	
	public ErsReimbursement(double amount, String description, int typeId, int authorId) {
		super();
		this.amount = amount;
		this.description = description;
		this.authorId = authorId;
		this.typeId = typeId;
	}
	
	public ErsReimbursement(int reimbId, double amount, Timestamp submitted, Timestamp resolved, String description,
			Blob reciept, String author, String resolver, String type, String status) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.reciept = reciept;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", description=" + description + ", reciept=" + reciept + ", author="
				+ author + ", resolver=" + resolver + ", status=" + status + ", type=" + type + "]";
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	
	
	

}
