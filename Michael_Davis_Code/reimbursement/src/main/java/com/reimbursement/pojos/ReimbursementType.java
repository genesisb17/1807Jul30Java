package com.reimbursement.pojos;

public class ReimbursementType {
private int id;
private String type;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public ReimbursementType(String type) {
	super();
	this.type = type;
}
public ReimbursementType(int id, String type) {
	super();
	this.id = id;
	this.type = type;
}
@Override
public String toString() {
	return "ReimbursmentType [id=" + id + ", type=" + type + "]";
}
}
