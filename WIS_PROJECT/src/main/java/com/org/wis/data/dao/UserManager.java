package com.org.wis.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.wis.data.domain.User;


@Repository
public class UserManager implements IUserManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserManager() {
		// TODO Auto-generated constructor stub
	}
	
	public User getUserById(int userId) {
		
		return (User) getSessionFactory().getCurrentSession().get(User.class, userId);
	}

	public User getUserByEmail(String email) {
		
		List<User> lis = 
				(List<User>) getSessionFactory().getCurrentSession().
				createQuery("SELECT u FROM USER u WHERE u.email :email");
		if(lis!=null)
			return lis.get(0);
		return null;
	}
	public void saveUser(User user) {
		
		getSessionFactory().getCurrentSession().save(user);		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
		
	}

	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
		
	}
	
}
