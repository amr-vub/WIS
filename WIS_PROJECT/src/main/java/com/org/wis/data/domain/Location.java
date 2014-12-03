package com.org.wis.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

	@Id @GeneratedValue
	int locationId;
	
	@Column
	String placeName;
	
	@Column
	String coordenate;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCoordenate() {
		return coordenate;
	}

	public void setCoordenate(String coordenate) {
		this.coordenate = coordenate;
	}
		
	
}
