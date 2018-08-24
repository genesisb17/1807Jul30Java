package com.iantimothyjohnson.notes.week4.dao;

import com.iantimothyjohnson.notes.week4.pojos.User;
import com.iantimothyjohnson.notes.week4.pojos.UserInformation;

public interface UserDao {
	User getUser(String username);

	String getPasswordHash(User user);

	UserInformation getUserInformation(String username);
}
