package com.ex.main;

import com.ex.data.UserRepository;
import com.ex.models.User;

public class MainClass 
{
	public static void main(String[] arg)
	{
		UserRepository repo = new UserRepository();
		
		User u = new User();
		u.setFirstName("Zack");
		u.setLastName("R");
		u.setUsername("zr");
		u.setPassword("1234");
		
		repo.save(u);
	}
}
