package com.naveen.dao;

import com.naveen.model.User;

public interface UserDao
{
	void saveUser(User user);
	
	Object[] loginUser(User user);
}
