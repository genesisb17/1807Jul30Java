package pojos;

import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.BasicConfigurator;

@XmlRootElement
public class Employee {
	
	private int employee_id;
	private String emp_username;
	private String emp_password;
	private String first_name;
	private String last_name;
	private String email;
	private int emp_role_id;
	
	static final Logger logger = Logger.getAnonymousLogger();
	
	public Employee() {
		super();
	}
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emp_password == null) ? 0 : emp_password.hashCode());
		result = prime * result + emp_role_id;
		result = prime * result + ((emp_username == null) ? 0 : emp_username.hashCode());
		result = prime * result + employee_id;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emp_password == null) {
			if (other.emp_password != null)
				return false;
		} else if (!emp_password.equals(other.emp_password))
			return false;
		if (emp_role_id != other.emp_role_id)
			return false;
		if (emp_username == null) {
			if (other.emp_username != null)
				return false;
		} else if (!emp_username.equals(other.emp_username))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}
	
}
