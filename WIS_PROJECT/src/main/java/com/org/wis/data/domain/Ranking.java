package com.org.wis.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ranking {

	@Id @GeneratedValue
	int rankID;
	
	@Column
	int rankValue;
	
	@ManyToOne @JoinColumn(nullable=false)
	ArtistJob rankArtistJob;

	public ArtistJob getRankArtistJob() {
		return rankArtistJob;
	}

	public void setRankArtistJob(ArtistJob rankArtistJob) {
		this.rankArtistJob = rankArtistJob;
	}

	public int getRankID() {
		return rankID;
	}

	public void setRankID(int rankID) {
		this.rankID = rankID;
	}

	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}
	
	
}
