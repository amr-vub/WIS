package com.org.wis.services.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.IUserAuthentcationManager;
import com.org.wis.data.dao.IUserManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;

@Service
public class userServiceImpl implements userService{

	@Autowired
	private IUserManager userM;
	
	@Autowired
	private IUserAuthentcationManager userAM;
	
	ObjectMapper mapper;
	
	public userServiceImpl(){
		mapper = new ObjectMapper();
	}
	
	public userServiceImpl(IUserManager userM){
		this.userM = userM;
		
	}
	
	
	
	@Transactional(readOnly = true)
	public User authenticateUser(UserAuthentication ua){
		int uid = userAM.userExist(ua.getUsername(), ua.getPassword());
		if(uid > -1){
			return userM.getUserById(uid);
		}else {
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public User getUserById(int id){
	
		return userM.getUserById(id);
	
	}
	
	@Transactional
	public List<ArtistJob> getUserArtistJobs(int uid){
		
		User u = userM.getUserById(uid);
		List<ArtistJob> ajs = u.getArtistJob();
		return ajs;
	}
	
	
	
	@Transactional
	public void updateUser(User updatedUser){
		
		User dbUser = userM.getUserById(updatedUser.getUserId());
		dbUser.setEmail(updatedUser.getEmail());
		dbUser.setGSM(updatedUser.getGSM());
		dbUser.getUserAuthentication().setUsername(updatedUser.getUserAuthentication().getUsername());
		dbUser.getUserAuthentication().setPassword(updatedUser.getUserAuthentication().getPassword());
		userM.updateUser(dbUser);
	
	}
	
	@Transactional(readOnly = true)
	public User getUserByEmail(String id){
		
		return userM.getUserByEmail(id);
	
	}

	@Transactional
	public boolean addUser(User user) {
		
		if(userM.getUserByEmail(user.getEmail()) == null)
		{
			user.getUserAuthentication().setUser(user);
			userM.saveUser(user);
			return true;
		}
		return false;
		
	}

	@Transactional
	public void deleteUser(int userid) {
		userM.deleteUser(userM.getUserById(userid));
		
	}
	
}
