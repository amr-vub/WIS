package com.org.wis.services.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Event;
import com.org.wis.data.domain.User;


public interface SearchService {
	public List<ArtistJob> searchArtist(String searchterm, int nbrResults);
	public List<BookerJob> searchBooker(String searchterm, int nbrResults);
	public List<Event> searchEvent(String searchterm, int nbrResults);
	public List<ArtistJob> searchArtistInArea(String searchterm, int nbrResults, double lon, double lat, double radiusKm);
	public List<BookerJob> searchBookerInArea(String searchterm, int nbrResults, double lon, double lat, double radiusKm);
	public List<Event> searchEventsInArea(String searchterm, int nbrResults, double lon, double lat, double radiusKm);
}
