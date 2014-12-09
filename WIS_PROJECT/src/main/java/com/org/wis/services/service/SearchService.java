package com.org.wis.services.service;

import java.util.List;
import java.util.Map;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.User;


public interface SearchService {
	public List<ArtistJob> searchArtist(String alias, int nbrResults);
	public List<BookerJob> searchBooker(String name, int nbrResults);	
}
