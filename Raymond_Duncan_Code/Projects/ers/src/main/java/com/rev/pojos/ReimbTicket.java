package com.rev.pojos;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReimbTicket {
	
	private Long reimbID;
	private double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDescription;
	private Blob receipt;
	private Long reimbAuthor;
	private Long reimbResolver;
	private int reimbStatus;
	private int reimbType;
	public ReimbTicket(){}
	public ReimbTicket(Long reimbID, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Long reimbAuthor, Long reimbResolver, int reimbType) {
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
	public Long getreimbID() {
		return reimbID;
	}
	public void setreimbID(Long reimbID) {
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
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public Long getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(Long reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public Long getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(Long reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public int getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public int getReimbType() {
		return reimbType;
	}
	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}
}
