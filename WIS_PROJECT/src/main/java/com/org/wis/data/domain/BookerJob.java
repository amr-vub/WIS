package com.org.wis.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	@Column
	String description;

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
