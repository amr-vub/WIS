package com.org.wis.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Event {

	@Id @GeneratedValue
	int eventID;
	
	@Column
	String title;
	
	@Column @Temporal(value = TemporalType.DATE)
	Date eventStartDate;
	
	@Column @Temporal(value = TemporalType.DATE)
	Date eventEndDate;
	
	@Column
	String eventStartTime;
	
	@Column
	String eventEndTime;
	
	@Column(length=8192)
	String description;

	@JsonIgnore
	@ManyToMany(mappedBy="userEvent")
	List<User> eventsUser = new ArrayList<User>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="events")
	List<ArtistJob> eventsArts = new ArrayList<ArtistJob>();	
	
	@JsonIgnore
	@ManyToMany(mappedBy="events")
	List<BookerJob> eventsBookers = new ArrayList<BookerJob>();

	
	@ManyToOne @JoinColumn(nullable=true)
	Location eventLocation;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="brEvent")
	BookingRequest brEvent;
	
	
	
	public BookingRequest getBrEvent() {
		return brEvent;
	}

	public void setBrEvent(BookingRequest brEvent) {
		this.brEvent = brEvent;
	}

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

	public Location getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(Location eventLocation) {
		this.eventLocation = eventLocation;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
