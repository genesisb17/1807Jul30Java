package pojos;

public class Employee {
	
	private int employee_id;
	private String emp_username;
	private String emp_password;
	private String first_name;
	private String last_name;
	private String email;
	private int emp_role_id;
	
	public Employee() {}
	
	public Employee(int employee_id, String emp_username, String emp_password, String first_name, String last_name,
			String email, int emp_role_id) {
		super();
		this.employee_id = employee_id;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.emp_role_id = emp_role_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmp_username() {
		return emp_username;
	}
	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmp_role_id() {
		return emp_role_id;
	}
	public void setEmp_role_id(int emp_role_id) {
		this.emp_role_id = emp_role_id;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", emp_username=" + emp_username + ", emp_password="
				+ emp_password + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", emp_role_id=" + emp_role_id + "]";
	}
	
	
}
