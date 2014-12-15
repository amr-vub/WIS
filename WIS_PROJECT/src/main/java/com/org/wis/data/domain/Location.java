package com.org.wis.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {

	@Id @GeneratedValue
	int locationId;
	
	@Column
	String placeName;
	
	@Column
	double lon;

	@Column
	double lat;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "artLocation")
	List<ArtistJob> artistJobs = new ArrayList<ArtistJob>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "location")
	List<Place> places = new ArrayList<Place>();
	
	public List<ArtistJob> getArtistJobs() {
		return artistJobs;
	}

	public void setArtistJobs(List<ArtistJob> artistJobs) {
		this.artistJobs = artistJobs;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

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
