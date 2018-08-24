package com.ers.pojo;

import java.sql.Blob;
import java.sql.Timestamp;





public class Reimbursement {
	
	private int rid;
	private int amount;
	private Timestamp sdate;
	private Timestamp rdate;
	private String info;
	private Blob recpt;
	private String resolver;
	private String status;
	private String type;
	
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp timestamp) {
		this.sdate = timestamp;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Blob getRecpt() {
		return recpt;
	}
	public void setRecpt(Blob recpt) {
		this.recpt = recpt;
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
		return rid + " $" + amount  + " " + sdate + " " + rdate + " " + info + " " + recpt + " " + resolver + " " + status + type;
	}
	
	
	

}
