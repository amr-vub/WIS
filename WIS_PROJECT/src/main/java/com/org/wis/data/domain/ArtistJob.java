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
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class ArtistJob {

	@Id @GeneratedValue
	int artistJobID;
	
	@Column
	String artFrom;
	
	@Column
	String aliase;
	
	@Column
	String personalWebSite;
	
	@Column
	String sondCloudLink;
	
	@Column
	String description;
	
	@Column
	int rankingValue;
		
	@ManyToOne @JoinColumn(nullable=false)	
	User artUser;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "rankArtistJob")
	List<Ranking> rankings = new ArrayList<Ranking>(); 
	
	@ManyToOne @JoinColumn(nullable=false)	
	Location artLocation;
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="arts_Event")
	List<Event> events = new ArrayList<Event>();
	
	
	
	public User getArtUser() {
		return artUser;
	}

	public void setArtUser(User artUser) {
		this.artUser = artUser;
	}

	public List<Ranking> getRankings() {
		return rankings;
	}

	public void setRankings(List<Ranking> rankings) {
		this.rankings = rankings;
	}

	public Location getArtLocation() {
		return artLocation;
	}

	public void setArtLocation(Location artLocation) {
		this.artLocation = artLocation;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public int getArtistJobID() {
		return artistJobID;
	}

	public void setArtistJobID(int artistJobID) {
		this.artistJobID = artistJobID;
	}

	public String getArtFrom() {
		return artFrom;
	}

	public void setArtFrom(String artFrom) {
		this.artFrom = artFrom;
	}

	public String getAliase() {
		return aliase;
	}

	public void setAliase(String aliase) {
		this.aliase = aliase;
	}

	public String getPersonalWebSite() {
		return personalWebSite;
	}

	public void setPersonalWebSite(String personalWebSite) {
		this.personalWebSite = personalWebSite;
	}

	public String getSondCloudLink() {
		return sondCloudLink;
	}

	public void setSondCloudLink(String sondCloudLink) {
		this.sondCloudLink = sondCloudLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRankingValue() {
		return rankingValue;
	}

	public void setRankingValue(int rankingValue) {
		this.rankingValue = rankingValue;
	}
	
	
}
