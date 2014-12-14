package com.org.wis.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.IEventManager;
import com.org.wis.data.domain.Event;



@Service
public class EventServiceImpl implements EventService {

	@Autowired
	IEventManager eventM;

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
	public void deleteEvent(int EventID) {
		Event ev = eventM.findEventById(EventID);
		if(ev != null){
			eventM.deleteEvent(ev);
		}
	}

	@Transactional
	public Event getEventById(int eventID) {
		return eventM.findEventById(eventID);
	}

	

}
