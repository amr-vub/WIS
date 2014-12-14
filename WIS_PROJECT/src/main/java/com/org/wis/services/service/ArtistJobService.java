package com.org.wis.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.User;


public interface ArtistJobService {
	
ArtistJob getArtistJobById(int artistJobID);
	
	void saveArtistJob(ArtistJob artistJob);
	
	void updateArtistJob(ArtistJob artistJob);
	
	void deleteArtistJob(int artistJobID);
	
	public List<ArtistJob> getArtistByAlias(String alias, int nbrResults);
}
