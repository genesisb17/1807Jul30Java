package servletExample.pojo;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	//Reim fields
	private int rid;
	private double amount;
	private Timestamp sdate;
	private Timestamp rdate;
	private String info;
	private byte[] recpt;
	private String username;
	private String resolver;
	private String status;
	private String type;
	
	
	public Reimbursement() {}
	
	public Reimbursement(String username) {
		this.username = username;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
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
	public byte[] getRecpt() {
		return recpt;
	}
	public void setRecpt(byte[] recpt) {
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
