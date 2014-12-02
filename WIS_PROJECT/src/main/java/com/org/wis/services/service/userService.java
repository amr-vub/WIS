package com.org.wis.services.service;

import org.springframework.stereotype.Service;

@Service
public interface userService {
	
	public boolean authenticateUser(String user,String password);
}
