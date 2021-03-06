package com.org.wis.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class User {

	@Id @GeneratedValue
	int userId;
	
	@Column
	String fname;
	
	@Column
	String lname;
	
	@Column
	String userName;
	
	@Column
	String GSM;
	
	@Column
	String email;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy="user") 
	UserAuthentication userAuthentication;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "artUser")
	List<ArtistJob> artistJob = new ArrayList<ArtistJob>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bookerUser")
	List<BookerJob> bookerJob = new ArrayList<BookerJob>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="User_Event")
	List<Event> userEvent = new ArrayList<Event>();
	
	public UserAuthentication getUserAuthentication() {
		return userAuthentication;
	}

	public void setUserAuthentication(UserAuthentication userAuthentication) {
		this.userAuthentication = userAuthentication;
	}

	public List<ArtistJob> getArtistJob() {
		return artistJob;
	}

	public void setArtistJob(List<ArtistJob> artistJob) {
		this.artistJob = artistJob;
	}

	public List<BookerJob> getBookerJob() {
		return bookerJob;
	}

	public void setBookerJob(List<BookerJob> bookerJob) {
		this.bookerJob = bookerJob;
	}

	public List<Event> getUserEvent() {
		return userEvent;
	}

	public void setUserEvent(List<Event> userEvent) {
		this.userEvent = userEvent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGSM() {
		return GSM;
	}

	public void setGSM(String gSM) {
		GSM = gSM;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
}
