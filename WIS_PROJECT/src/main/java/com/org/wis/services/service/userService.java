package com.org.wis.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;


public interface userService {
	
	public User authenticateUser(UserAuthentication ua);
	public boolean addUser(User user);
	public void deleteUser(int userid);
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public void updateUser(User user);
	public List<ArtistJob> getUserArtistJobs(int uid);
	public List<BookerJob> getUserBookerJob(int uid);
	
}
