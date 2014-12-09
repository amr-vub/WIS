package com.org.wis.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;

@Repository
public class BookerJobManager implements IBookerJobManager{

	@Autowired
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

	public List<BookerJob> getBookerByLabel(String label, int nbrResults)
	{
		List<BookerJob> ret = (List<BookerJob>) getSessionFactory().getCurrentSession()
				.createQuery("SELECT u FROM BookerJob u WHERE u.label LIKE :label"
						+ " LIMIT :nbrResults").setParameter(":label", label)
						.setParameter(":nbrResults", nbrResults);
		return ret;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
