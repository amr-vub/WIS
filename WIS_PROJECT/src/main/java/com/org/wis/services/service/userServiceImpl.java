package com.org.wis.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.IUserManager;

@Service
public class userServiceImpl implements userService{

	@Autowired
	private IUserManager UM;
	
	
	public userServiceImpl(IUserManager UM){
		this.UM = UM;
		
	}
	
	@Transactional(readOnly = true)
	public boolean authenticateUser(String user,String password){
		
		if( password=="1234"/*check db*/){
			return true;
		}else{
			return false;	
		}
	}
}
