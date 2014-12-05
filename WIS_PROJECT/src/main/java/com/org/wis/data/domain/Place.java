package com.org.wis.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Place {

	@Id @GeneratedValue
	int placeID;
	// TODO : add attributes or remove

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "place")
	List<Event> events = new ArrayList<Event>();
	
	@ManyToOne @JoinColumn(nullable = false)
	Location location;
		
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}
	
	
}
