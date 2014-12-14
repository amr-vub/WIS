package com.org.wis.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.wis.data.domain.Location;

@Repository
public class LocationManager implements ILocationManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public Location getLocationById(int LocId) {
		return (Location) getSessionFactory().getCurrentSession().get(Location.class, LocId);		
	}

	public Location getLocaByCoord(String coords) {
		List<Location> locs = getSessionFactory().getCurrentSession().
				createQuery("SELECT u FROM Location u WHERE u.coordenate LIKE :coordenate").
				setParameter("coordenate", coords).list();
		if(locs.size()!=0)
			return locs.get(0);
		return null;
	}

	public void saveLocation(Location loc) {
		getSessionFactory().getCurrentSession().save(loc);
	}

	public void updateLocation(Location loc) {		
		getSessionFactory().getCurrentSession().update(loc);
	}

	public void DeleteLocation(Location loc) {
		getSessionFactory().getCurrentSession().delete(loc);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
