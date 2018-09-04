package com.revature.pojos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tickets {
	private String firstName;
	private String lastName;
	private double cash;
	private String submit;
	private String resolved;
	private String description;
	private String status;
	private int type;
	private int userId;
	private int ticketId;
	private int statusId;
	private int roleId;
	private String email;
	private String userName;
	private String password;
	
	public Tickets() {}
	
	public Tickets(double cash, String description, int type, int userId) {
		
		this.cash = cash;
		this.description = description;
		this.type = type;
		this.userId = userId;
	}
	
	
	public Tickets(int userId, int ticketId, int statusId, String firstName, String lastName, double cash, String submit, String resolved, String description,
			String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cash = cash;
		this.submit = submit;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
		this.userId = userId;
		this.ticketId = ticketId;
		this.statusId = statusId;
	}
	
	public Tickets(String firstName, String lastName, double cash, String submit, String resolved, String description,
			String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cash = cash;
		this.submit = submit;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
	}



	public Tickets(String firstName, String lastName, double cash, String submit, String resolved, String description,
			String status, int type, int userId, int roleId, String email, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cash = cash;
		this.submit = submit;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
		this.type = type;
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public double getCash() {
		return cash;
	}


	public void setCash(double cash) {
		this.cash = cash;
	}


	public String getSubmit() {
		return submit;
	}


	public void setSubmit(String submit) {
		this.submit = submit;
	}


	public String getResolved() {
		return resolved;
	}


	public void setResolved(String resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
	
	@Override
	public String toString() {
		return "Tickets [firstName=" + firstName + ", lastName=" + lastName + ", cash=" + cash + ", submit=" + submit
				+ ", resolved=" + resolved + ", description=" + description + ", status=" + status + ", type=" + type
				+ ", userId=" + userId + ", ticketId=" + ticketId + ", statusId=" + statusId + ", roleId=" + roleId
				+ ", email=" + email + ", userName=" + userName + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submit == null) ? 0 : submit.hashCode());
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
		Tickets other = (Tickets) obj;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submit == null) {
			if (other.submit != null)
				return false;
		} else if (!submit.equals(other.submit))
			return false;
		return true;
	}


	
	
}
