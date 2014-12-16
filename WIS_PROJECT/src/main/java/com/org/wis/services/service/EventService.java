package com.org.wis.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.Event;
import com.org.wis.data.domain.User;


public interface EventService {
	
Event getEventById(int EventID);
	
	void saveEvent(Event Event);
	
	void updateEvent(Event Event);
	
	void deleteEvent(int uid, int EventID);
	
	void addArtistToEvent(int aid, int EventID);
	void addBookerToEvent(int bid, int EventID);
	
}
