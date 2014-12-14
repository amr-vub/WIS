package com.org.wis.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.IUserManager;
import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;

@Service
public class userServiceImpl implements userService{

	@Autowired
	private IUserManager userM;
	
	
	public userServiceImpl(){	
	}
	
	public userServiceImpl(IUserManager userM){
		this.userM = userM;
		
	}
	
	
	
	@Transactional(readOnly = true)
	public User authenticateUser(String email,String password){
		UserAuthentication uA;
		User u = userM.getUserByEmail(email);
		if(u != null){
			uA = u.getUserAuthentication();
			if(uA != null){
				if( uA.getPassword().equals(password)){
					return u;
				}
			}
		}
		
		
		return null;	
		
	}
	
	@Transactional(readOnly = true)
	public User getUserById(int id){
		
		return userM.getUserById(id);
	
	}
	
	@Transactional
	public void updateUser(User user){
		
		userM.updateUser(user);
	
	}
	
	@Transactional(readOnly = true)
	public User getUserByEmail(String id){
		
		return userM.getUserByEmail(id);
	
	}

	@Transactional
	public boolean addUser(User user) {
		
		if(userM.getUserByEmail(user.getEmail()) == null){
			userM.saveUser(user);
			return true;
		}else return false;
	

	}

	@Transactional
	public void deleteUser(int userid) {
		userM.deleteUser(userM.getUserById(userid));
		
	}
	
	
}
