package com.org.wis.data.dao;

import java.util.List;

import com.org.wis.data.domain.ArtistJob;

public interface IArtistJobManager {

	ArtistJob getArtistJobById(int artistJobID);
	
	void saveArtistJob(ArtistJob artistJob);
	
	void updateArtistJob(ArtistJob artistJob);
	
	void deleteArtistJob(ArtistJob artistJob);
	
	public List<ArtistJob> getArtistByAlias(String alias, int nbrResults);
}
