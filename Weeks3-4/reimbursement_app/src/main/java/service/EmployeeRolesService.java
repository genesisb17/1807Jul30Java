package service;

import java.util.List;

import dao.DAO;
import dao.EmployeeRolesDAO;
import pojos.EmployeeRoles;

public class EmployeeRolesService {

static DAO<EmployeeRoles, Integer> eDAO = new EmployeeRolesDAO();
	
	public List<EmployeeRoles> getAll() {
		return eDAO.getAll();
	}

	public EmployeeRoles findOne(EmployeeRoles obj) {
		return eDAO.findOne(obj);
	}

	public EmployeeRoles save(EmployeeRoles obj) {
		return eDAO.save(obj);
	}

	public EmployeeRoles update(EmployeeRoles obj) {
		return eDAO.update(obj);
	}

	public void delete(EmployeeRoles obj) {
		// TODO Auto-generated method stub
		System.out.println("You need to write this method");
	}
}
