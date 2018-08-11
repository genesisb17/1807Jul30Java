package com.rev.pojos;

public class Savings {
	
	private int savingsid;
	private int userid;
	private double total;
	
	public Savings(int savingsid, int userid, double total) {
		super();
		this.savingsid = savingsid;
		this.userid = userid;
		this.total = total;
	}

	public int getSavingsid() {
		return savingsid;
	}

	public void setSavingsid(int savingsid) {
		this.savingsid = savingsid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Savings [savingsid=" + savingsid + ", userid=" + userid + ", total=" + total + "]";
	}
}
