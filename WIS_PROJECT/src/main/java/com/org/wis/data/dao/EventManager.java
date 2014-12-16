package com.org.wis.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.wis.data.domain.Event;

@Repository
public class EventManager implements IEventManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public Event findEventById(int eventID) {
		return (Event) getSessionFactory().getCurrentSession().get(Event.class, eventID);
	}

	public void saveEvent(Event event) {
		getSessionFactory().getCurrentSession().save(event);
	}

	public void updateEvent(Event event) {
		getSessionFactory().getCurrentSession().update(event);
		
	}

	public void deleteEvent(Event event) {
		getSessionFactory().getCurrentSession().delete(event);
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Event> searchEventsInArea(String searchterm, int nbrResults,
			double minlon, double maxlon, double minlat, double maxlat) {
		
		List<Event> lis = (List<Event>) getSessionFactory().getCurrentSession()
		.createQuery("SELECT u FROM Event u WHERE u.eventLocation.lon BETWEEN :langLow AND :langHigh "
				+ " AND u.artLocation.lat BETWEEN :latLow AND :latHigh")
		.setParameter("longLow", minlon).setParameter("langHigh", maxlon).
		setParameter("latLow", minlat).setParameter("latHigh", maxlat).setMaxResults(nbrResults);
		
		return lis;
	}

	public List<Event> getEventBytitle(String title) {
		
		List<Event> lis = (List<Event>) getSessionFactory().getCurrentSession().
				createQuery("SELECT u FROM Event u WHERE u.title LIKE ?").setString(0, "%"+title+"%").list();
				
		return lis;
	}

}
