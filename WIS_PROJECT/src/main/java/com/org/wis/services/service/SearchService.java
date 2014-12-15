package com.org.wis.services.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Event;
import com.org.wis.data.domain.User;


public interface SearchService {
	public List<ArtistJob> searchArtist(String alias, int nbrResults);
	public List<BookerJob> searchBooker(String name, int nbrResults);	
	public List<ArtistJob> searchArtistInArea(String name, int nbrResults, int lon, int lat, int radiusKm);
	public List<Event> searchEventsInArea(String name, int nbrResults, int lon, int lat, int radiusKm);
}
