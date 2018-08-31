package com.ex.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.data.UserRepository;
import com.ex.models.User;

import com.ex.util.ConnectionUtil;

public class Main {
	
	public static void main(String[] args) {
		
		UserRepository up=new UserRepository();
		User u=new User();
		u.setFirstName("M");
		u.setLastNamee("DD");
		u.setPassword("aaa");
		u.setUsername("mduname");
		
		up.save(u);

	}	

		
	}
	

