package com.revature.pojo;

public class ErsReimbStatus {
	private int statusId;
	private String status;
	
	public ErsReimbStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	
	public ErsReimbStatus(String status) {
		this(-1, status);
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErsReimbStatus [statusId=" + statusId + ", status=" + status + "]";
	}
	
	
}
