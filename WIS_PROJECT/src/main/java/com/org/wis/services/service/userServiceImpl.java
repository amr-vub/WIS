package com.org.wis.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class userServiceImpl {

	private Object db;
	
	@Autowired
	public userServiceImpl(Object db){
		this.db = db;
		
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
