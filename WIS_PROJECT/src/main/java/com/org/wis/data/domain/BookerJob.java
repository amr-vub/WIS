package com.org.wis.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class BookerJob {

	@Id @GeneratedValue
	int bookerJob;
	
	@Column
	String label;
	
	@Column
	String email;
	
	@Column
	String gsm;
	
	@Column(length=8192)
	String description;

	@JsonIgnore
	@ManyToOne @JoinColumn(nullable=false)	
	User bookerUser;
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="bookers_Event")
	List<Event> events = new ArrayList<Event>();
		
	@ManyToOne @JoinColumn(nullable=false)	
	Location bookerLocation;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="brBooker")
	BookingRequest brBooker;
	
	public BookingRequest getBrBooker() {
		return brBooker;
	}

	public void setBrBooker(BookingRequest brBooker) {
		this.brBooker = brBooker;
	}

	public Location getBookerLocation() {
		return bookerLocation;
	}

	public void setBookerLocation(Location bookerLocation) {
		this.bookerLocation = bookerLocation;
	}

	public User getBookerUser() {
		return bookerUser;
	}

	public void setBookerUser(User bookerUser) {
		this.bookerUser = bookerUser;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public int getBookerJob() {
		return bookerJob;
	}

	public void setBookerJob(int bookerJob) {
		this.bookerJob = bookerJob;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
