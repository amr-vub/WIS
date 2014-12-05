package com.org.wis.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.org.wis.data.domain.UserAuthentication;

public class UserAuthentcationManager implements IUserAuthentcationManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int userExist(String username, String password) {
		
		List<UserAuthentication> potentialUserAuth = getSessionFactory().getCurrentSession().
		createQuery("SELECT u FROM UserAuthentication u WHERE u.username = :username AND "
				+ "u.password = :password ").setParameter("username", username).
				setParameter("password", password).list();
		
		if(potentialUserAuth != null)
			return potentialUserAuth.get(0).getUser().getUserId();
		
		return -1;
	}

	
}
