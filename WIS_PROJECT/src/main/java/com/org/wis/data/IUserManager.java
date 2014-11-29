package com.org.wis.data;

import com.org.wis.data.domain.User;

public interface IUserManager {

	User getUserById(int userId);
	
	void saveUser(User user);
}
