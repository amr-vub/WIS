package com.org.wis.data.dao;

import com.org.wis.data.domain.ArtistJob;

public interface IArtistJobManager {

	ArtistJob getArtistJobById(int artistJobID);
	
	void saveArtistJob(ArtistJob artistJob);
	
	void updateArtistJob(ArtistJob artistJob);
	
	void deleteArtistJob(ArtistJob artistJob);
}
