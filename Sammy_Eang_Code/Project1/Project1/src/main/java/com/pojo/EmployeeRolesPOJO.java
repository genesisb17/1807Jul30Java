package com.pojo;

public class EmployeeRolesPOJO {

	private int emp_role_id;
	private String emp_role;
	
	public EmployeeRolesPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeRolesPOJO(int emp_role_id, String emp_role) {
		super();
		this.emp_role_id = emp_role_id;
		this.emp_role = emp_role;
	}
	
	@Override
	public String toString() {
		return "EmployeeRolesPOJO [emp_role_id=" + emp_role_id + ", emp_role=" + emp_role + "]";
	}

	public int getEmp_role_id() {
		return emp_role_id;
	}

	public void setEmp_role_id(int emp_role_id) {
		this.emp_role_id = emp_role_id;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	
	
	
}
