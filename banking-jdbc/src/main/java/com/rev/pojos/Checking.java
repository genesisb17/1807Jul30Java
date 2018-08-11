package com.rev.pojos;

public class Checking {
	
	private int checkingsid;
	private int userid;
	private double total;
	
	public Checking() {}
	
	public Checking(int checkingsid, int userid, double total) {
		super();
		this.checkingsid = checkingsid;
		this.userid = userid;
		this.total = total;
	}

	public int getCheckingsid() {
		return checkingsid;
	}

	public void setCheckingsid(int checkingsid) {
		this.checkingsid = checkingsid;
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
		return "Checking [checkingsid=" + checkingsid + ", userid=" + userid + ", total=" + total + "]";
	}

}
