package com.org.wis.data.dao;

import org.hibernate.SessionFactory;

public class BookerJob implements IBookerJob{

	SessionFactory sessionFactory;
	
	public BookerJob getBookerJobById(int BookerJobId) {
		return (BookerJob) getSessionFactory().getCurrentSession().get(BookerJob.class, BookerJobId);
	}

	public void saveBookerJob(BookerJob bookerJob) {
		getSessionFactory().getCurrentSession().save(bookerJob);
	}

	public void updateBookerJob(BookerJob bookerJob) {
		getSessionFactory().getCurrentSession().update(bookerJob);
	}

	public void deleteBookerJob(BookerJob bookerJob) {
		getSessionFactory().getCurrentSession().delete(bookerJob);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
