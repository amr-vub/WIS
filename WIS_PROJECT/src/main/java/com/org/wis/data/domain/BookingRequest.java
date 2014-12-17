package com.org.wis.data.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class BookingRequest {

	@Id @GeneratedValue
	int bookingRequestId;
	
	@JsonIgnore
	@Column
	@OneToOne @JoinColumn(nullable=false)
	ArtistJob brArtistJob;
	
	@JsonIgnore
	@Column
	@OneToOne @JoinColumn(nullable=false)
	Event brEvent;
	
	@JsonIgnore
	@Column
	@OneToOne @JoinColumn(nullable=false)
	BookerJob brBooker;

	public int getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(int bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

	public ArtistJob getBrArtistJob() {
		return brArtistJob;
	}

	public void setBrArtistJob(ArtistJob brArtistJob) {
		this.brArtistJob = brArtistJob;
	}

	public Event getBrEvent() {
		return brEvent;
	}

	public void setBrEvent(Event brEvent) {
		this.brEvent = brEvent;
	}

	public BookerJob getBrBooker() {
		return brBooker;
	}

	public void setBrBooker(BookerJob brBooker) {
		this.brBooker = brBooker;
	}
	
	
	
	
}
