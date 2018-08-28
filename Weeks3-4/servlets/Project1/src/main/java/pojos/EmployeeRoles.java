package pojos;

public class EmployeeRoles {
	
	private int emp_role_id;
	private String employee_role;
	
	public EmployeeRoles() {}
	
	public EmployeeRoles(int emp_role_id, String employee_role) {
		super();
		this.emp_role_id = emp_role_id;
		this.employee_role = employee_role;
	}

	public int getEmp_role_id() {
		return emp_role_id;
	}

	public void setEmp_role_id(int emp_role_id) {
		this.emp_role_id = emp_role_id;
	}

	public String getEmployee_role() {
		return employee_role;
	}

	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}

	@Override
	public String toString() {
		return "EmployeeRoles [emp_role_id=" + emp_role_id + ", employee_role=" + employee_role + "]";
	}
	
	
}
