package com.org.wis.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * 
 * Very simple naive way of user authentication
 * 
 */

@Entity
public class UserAuthentication {

	@Id
	int userAuthentication;
	
	@Column
	String username;
	
	@Column
	String password;
	
	@Column @Temporal(value = TemporalType.DATE)
	Date lasetLogin;
	
	@OneToOne @JoinColumn(nullable=false)
	User user;	

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserAuthentication() {
		return userAuthentication;
	}

	public void setUserAuthentication(int userAuthentication) {
		this.userAuthentication = userAuthentication;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLasetLogin() {
		return lasetLogin;
	}

	public void setLasetLogin(Date lasetLogin) {
		this.lasetLogin = lasetLogin;
	}
		
}
