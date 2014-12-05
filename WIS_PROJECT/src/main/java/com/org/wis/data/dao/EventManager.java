package com.org.wis.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.org.wis.data.domain.Event;

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

}
