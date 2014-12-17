package com.org.wis.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.wis.data.domain.BookingRequest;

@Repository
public class BookingRequestManager implements IBookingRequestManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public BookingRequest getBrByID(int brId) {
		
		return (BookingRequest) getSessionFactory().getCurrentSession().get(BookingRequest.class, brId);
	}

	public void saveBr(BookingRequest br) {
		getSessionFactory().getCurrentSession().save(br);
	}

	public void updateBr(BookingRequest br) {
		getSessionFactory().getCurrentSession().update(br);
	}

	public void deleteBr(BookingRequest br) {
		getSessionFactory().getCurrentSession().delete(br);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
