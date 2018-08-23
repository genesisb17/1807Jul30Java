package com.pojo;

public class ReimbursementTypePOJO {

	private int reimb_type_id;
	private String reimb_status;
	
	public ReimbursementTypePOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementTypePOJO(int reimb_type_id, String reimb_status) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_status = reimb_status;
	}

	@Override
	public String toString() {
		return "ReimbursementTypePOJO [reimb_type_id=" + reimb_type_id + ", reimb_status=" + reimb_status + "]";
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	
}
