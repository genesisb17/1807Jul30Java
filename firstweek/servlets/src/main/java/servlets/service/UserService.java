package servlets.service;

import java.util.ArrayList;

import servlets.pojo.User;

public class UserService {
	
	static ArrayList <User> users = new ArrayList<User>();
	{
		users.add(new User("Dylan", "admin"));
		users.add(new User("Dylan1", "admin1"));
		
	}
	
	public User getUsers(String name) {
		User u = users.stream().filter(x -> x.getUser().equals(name)).findAny().orElse(null);
		return u;
	}

}
