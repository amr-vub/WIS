package com.org.wis.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
