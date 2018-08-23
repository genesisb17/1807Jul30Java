package com.rev.pojos;

import java.sql.Timestamp;

public class ReimbursementTicket {
	
	private long reimbID;
	private double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDescription;
	private long reimbAuthor;
	private long reimbResolver;
	private String reimbType;
	ReimbursementTicket(){}
	public ReimbursementTicket(long reimbID, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, long reimbAuthor, long reimbResolver, String reimbType) {
		super();
		this.reimbID = reimbID;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbType = reimbType;
	}
	public long getreimbID() {
		return reimbID;
	}
	public void setreimbID(long reimbID) {
		this.reimbID = reimbID;
	}
	public double getreimbAmount() {
		return reimbAmount;
	}
	public void setreimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public long getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(long reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public long getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(long reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	

}
