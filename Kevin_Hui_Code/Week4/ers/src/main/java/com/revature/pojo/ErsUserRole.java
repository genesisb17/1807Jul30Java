package com.revature.pojo;

public class ErsUserRole {
	private int roleId;
	private String userRole;
	
	public ErsUserRole(int roleId, String userRole) {
		super();
		this.roleId = roleId;
		this.userRole = userRole;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "ErsUserRole [roleId=" + roleId + ", userRole=" + userRole + "]";
	}
	
	
}
