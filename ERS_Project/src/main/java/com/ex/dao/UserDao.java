package com.ex.dao;

import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.RequestForm;
import com.ex.pojos.User;
import com.ex.pojos.UserInformation;

public interface UserDao {
	
	User getUser(String username);
	String getPasswordHash(User user);
	UserInformation getUserInformation(String username);
	List<Reimbursement> getEmpTables(String username);
	int submitRequest(RequestForm requestForm);
	
}
