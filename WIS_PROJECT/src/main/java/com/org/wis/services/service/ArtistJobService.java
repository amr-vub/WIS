package com.org.wis.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.User;


public interface ArtistJobService {
	
ArtistJob getArtistJobById(int artistJobID);
	
	void addArtistJob(int uid, ArtistJob artistjob);
	
	
	void updateArtistJob(ArtistJob artistJob);
	
	void deleteArtistJob(int artistJobID);
	
	void addRanking(int artistJobID, int rankValue, int uid);
	
	int getRanking(int artistJobId);
	
	public List<ArtistJob> getArtistByAlias(String alias, int nbrResults);
}
