package com.org.wis.data.dao;

import com.org.wis.data.domain.Event;

public interface IEventManager {

	Event findEventById(int eventID);
	
	void saveEvent(Event event);
	
	void updateEvent(Event event);
	
	void deleteEvent(Event event);
}
