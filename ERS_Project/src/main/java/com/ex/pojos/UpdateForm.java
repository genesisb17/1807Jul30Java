package com.ex.pojos;

public class UpdateForm {
	
	private int statusid;
	private int id;
	
	public UpdateForm() {}
	
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UpdateForm(int statusid, int id) {
		super();
		this.statusid = statusid;
		this.id = id;
	}
	@Override
	public String toString() {
		return "UpdateForm [statusid=" + statusid + ", id=" + id + "]";
	}

}
