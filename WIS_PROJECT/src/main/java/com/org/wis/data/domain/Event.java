package com.org.wis.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {

	@Id @GeneratedValue
	int eventID;
	
	@Column @Temporal(value = TemporalType.DATE)
	Date eventDate;
	
	@Column
	String description;

	@ManyToMany(mappedBy="userEvent")
	List<User> eventsUser = new ArrayList<User>();
	
	@ManyToMany(mappedBy="events")
	List<ArtistJob> eventsArts = new ArrayList<ArtistJob>();	
	
	@ManyToMany(mappedBy="events")
	List<BookerJob> eventsBookers = new ArrayList<BookerJob>();

	@ManyToOne @JoinColumn(nullable=false)
	Place place;
	
	
	
	public List<User> getEventsUser() {
		return eventsUser;
	}

	public void setEventsUser(List<User> eventsUser) {
		this.eventsUser = eventsUser;
	}

	public List<ArtistJob> getEventsArts() {
		return eventsArts;
	}

	public void setEventsArts(List<ArtistJob> eventsArts) {
		this.eventsArts = eventsArts;
	}

	public List<BookerJob> getEventsBookers() {
		return eventsBookers;
	}

	public void setEventsBookers(List<BookerJob> eventsBookers) {
		this.eventsBookers = eventsBookers;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
