package com.org.wis.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.IEventManager;
import com.org.wis.data.dao.IUserManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Event;



@Service
public class EventServiceImpl implements EventService {

	@Autowired
	IEventManager eventM;
	
	@Autowired
	IUserManager userM;

	@Transactional(readOnly = true)
	public Event findEventById(int EventID) {
		Event aj =  eventM.findEventById(EventID);
		return aj;
	}

	@Transactional
	public void saveEvent(Event event) {
		
		eventM.saveEvent(event);
		
	}

	@Transactional
	public void updateEvent(Event updatedEv) {
		Event dbEv = eventM.findEventById(updatedEv.getEventID());
		dbEv.setDescription(updatedEv.getDescription());
		dbEv.setEventDate(updatedEv.getEventDate());
		
		eventM.updateEvent(dbEv);
		
	}

	@Transactional
	public void deleteEvent(int uid, int EventID) {
		Event ev = eventM.findEventById(EventID);
		/*
		List<BookerJob> bookers = ev.getEventsBookers();
		boolean allowedToDelete = false;
		for(BookerJob bj: bookers){
			if(bj.getBookerUser().getUserId() == uid) allowedToDelete = true;
			break;
		}
		if(!allowedToDelete){
			
			List<ArtistJob> artists = ev.getEventsArts();
			for(ArtistJob aj: artists){
				if(aj.getArtUser().getUserId() == uid) allowedToDelete = true;
				break;
			}
		}
		*/

		eventM.deleteEvent(ev);
	
	}

	@Transactional
	public Event getEventById(int eventID) {
		return eventM.findEventById(eventID);
	}

	

}
