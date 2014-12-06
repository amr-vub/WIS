package com.org.wis.services.service;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.User;


public interface userService {
	
	public User authenticateUser(String user,String password);
	public boolean addUser(User user);
	public void deleteUser(int userid);
}
