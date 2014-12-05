package com.org.wis.data.dao;

import com.org.wis.data.domain.User;

public interface IUserManager {

	User getUserById(int userId);
	
	void saveUser(User user);
	
	void deleteUser(User user);
	
	void updateUser(User user);
}
