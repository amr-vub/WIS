package com.org.wis.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.wis.data.domain.ArtistJob;

@Repository
public class ArtistJobManager implements IArtistJobManager{

	@Autowired
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

	public List<ArtistJob> getArtistByAlias(String alias, int nbrResults)
	{
		List<ArtistJob> ret = (List<ArtistJob>) getSessionFactory().getCurrentSession()
				.createQuery("SELECT u FROM ArtistJob u WHERE u.aliase LIKE :aliase")
				.setParameter("aliase", alias).setMaxResults(nbrResults).list();
		return ret;
	}
	
	public List<ArtistJob> searchArtistInArea(String searchterm, int nbrResults,
			double minlon, double maxlon, double minlat, double maxlat){
		List<ArtistJob> ret = (List<ArtistJob>) getSessionFactory().getCurrentSession()
				.createQuery("SELECT u FROM ArtistJob u WHERE u.artLocation.lon BETWEEN :langLow AND :langHigh "
						+ " AND u.artLocation.lat BETWEEN :latLow AND :latHigh")
				.setParameter("longLow", minlon).setParameter("langHigh", maxlon).
				setParameter("latLow", minlat).setParameter("latHigh", maxlat).setMaxResults(nbrResults);
		
		return ret;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
