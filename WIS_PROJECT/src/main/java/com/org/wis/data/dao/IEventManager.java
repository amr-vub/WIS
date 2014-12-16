package com.org.wis.data.dao;

import java.util.List;

import com.org.wis.data.domain.Event;

public interface IEventManager {

	Event findEventById(int eventID);
	
	void saveEvent(Event event);
	
	void updateEvent(Event event);
	
	void deleteEvent(Event event);
	
	public List<Event> searchEventsInArea(String searchterm, int nbrResults,
			double minlon, double maxlon, double minlat, double maxlat);
	
	public List<Event> getEventBytitle(String title);
}
