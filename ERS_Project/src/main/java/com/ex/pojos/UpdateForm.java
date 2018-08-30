package com.ex.pojos;

public class UpdateForm {
	
	private int statusId;
	private int id;
	
	public UpdateForm(int statusId, int id) {
		super();
		this.statusId = statusId;
		this.id = id;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UpdateForm [statusId=" + statusId + ", id=" + id + "]";
	}

}
