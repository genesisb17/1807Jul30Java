package com.reimbursement.pojos;

public class UserRole {
private int typeid;
private String Role;
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
@Override
public String toString() {
	return "UserRole [typeid=" + typeid + ", Role=" + Role + "]";
}
public UserRole(int typeid, String role) {
	super();
	this.typeid = typeid;
	Role = role;
}
public UserRole(String role) {
	super();
	Role = role;
}

}
