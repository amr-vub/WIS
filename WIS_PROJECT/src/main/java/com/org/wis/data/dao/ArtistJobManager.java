package com.org.wis.data.dao;

import org.hibernate.SessionFactory;

import com.org.wis.data.domain.ArtistJob;

public class ArtistJobManager implements IArtistJobManager{

	SessionFactory sessionFactory;
	
	public ArtistJob getArtistJobById(int artistJobID) {
		return (ArtistJob) getSessionFactory().getCurrentSession().get(ArtistJob.class, artistJobID);
	}

	public void saveArtistJob(ArtistJob artistJob) {
		getSessionFactory().getCurrentSession().save(artistJob);
	}

	public void updateArtistJob(ArtistJob artistJob) {
		getSessionFactory().getCurrentSession().update(artistJob);
	}

	public void deleteArtistJob(ArtistJob artistJob) {
		getSessionFactory().getCurrentSession().delete(artistJob);
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
