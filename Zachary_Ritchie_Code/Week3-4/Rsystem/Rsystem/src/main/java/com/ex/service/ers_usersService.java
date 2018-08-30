package com.ex.service;

import com.ex.dao.DAO;
import com.ex.dao.ers_usersDAO;
import com.ex.pojos.ers_users;

public class ers_usersService
{
	static DAO<ers_users, Integer> aDao = new ers_usersDAO();
	static ers_usersDAO ers = new ers_usersDAO();
	
	public ers_users findOne(String[] obj)
	{

		ers_users output = new ers_users();
		
		String username = obj[0];
		String password = obj[1];
		
		if (!username.equals("") && !password.equals(""))
		{			
			output = ers.findOne(username);
			
			if (output.getErs_password().equals(password))
			{
				return output;
			}
			else
			{
				return output = null;
			}
		}
		else
		{
			return output = null;
		}	
		
	}
	
	public ers_users findEmployee(String[] obj)
	{
		String temp = obj[0];
		return ers.find(temp);
	}
	
	public ers_users saving(String[] userInformation)
	{
		ers_users newUser = new ers_users();
		ers_users uniqueUsername = new ers_users();
		ers_users uniqueEmail = new ers_users();
		String username = userInformation[0];
		String password = userInformation[1];
		String firstname = userInformation[2];
		String lastname = userInformation[3];
		String email = userInformation[4];
		String role = userInformation[5];
		
		
		if (!username.equals("") && !password.equals("") && !firstname.equals("") && !lastname.equals("") && !email.equals(""))
		{
			
			//create user object and store values
			//System.out.println(username + " " + password + " " + firstname + " " + lastname + " " + email);
			newUser.setErs_first_name(firstname);
			newUser.setErs_last_name(lastname);
			newUser.setErs_username(username);
			newUser.setErs_password(password);
			newUser.setUser_email(email);
			newUser.setUser_role_id(Integer.parseInt(role));
			
			uniqueUsername = ers.findOne(username);
			uniqueEmail = ers.findOneEmail(email);
			
			//Checks to see if entered username is unique

			if(uniqueUsername != null)
			{
				newUser.setErs_username(null);
				return newUser;				
			}			
			else if(uniqueEmail != null)
			{
				newUser.setUser_email(null);
				return newUser;
			}
			else
			{
				aDao.save(newUser);
				//Gets the user id and role id
				newUser = ers.findOne(username);
				
				return newUser;
			}
			
			
		}
		else 
		{
			return newUser = null;
		}
	}
}
