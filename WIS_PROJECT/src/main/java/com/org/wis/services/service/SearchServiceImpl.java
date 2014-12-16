package com.org.wis.services.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.ArtistJobManager;
import com.org.wis.data.dao.BookerJobManager;
import com.org.wis.data.dao.IArtistJobManager;
import com.org.wis.data.dao.IBookerJobManager;
import com.org.wis.data.dao.IEventManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Event;
import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.User;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	IArtistJobManager artJobM;
	
	@Autowired
	IBookerJobManager bookJobM;
	
	@Autowired
	IEventManager eventM;
	
	public SearchServiceImpl() {		

	}

	@Transactional
	public List<ArtistJob> searchArtist(String alias, int nbrResults) {
	
		List<ArtistJob> artistList = artJobM.getArtistByAlias(alias, nbrResults);	
		
		return artistList;
	}

	@Transactional
	public List<BookerJob> searchBooker(String searchterm, int nbrResults) {
		
		return bookJobM.getBookerByLabel(searchterm,nbrResults);
	}
	
	@Transactional
	public List<Event> searchEvent(String searchterm, int nbrResults) {
		
		return eventM.getEventBytitle(searchterm);
	}
	
	@Transactional
	public List<ArtistJob> searchArtistInArea(String searchterm, int nbrResults, double lon, double lat, double radiuskm){
		
		
		
		
		//Thats actually tricky, because the distance in km of one degree longitude depends on the latitude
		//near the equator its much longer than near the pole.. use this formular
		//dist between two points (Radius of earth 6317km):
		// dist = arccos(sin(lat1) · sin(lat2) + cos(lat1) · cos(lat2) · cos(lon1 - lon2))* 6317km
		// http://janmatuschek.de/LatitudeLongitudeBoundingCoordinates
		double minlon=1;
		double maxlon = 15;
		double minlat = 1;
		double maxlat=15;
		return artJobM.searchArtistInArea(searchterm, nbrResults, minlon, maxlon, minlat, maxlat);//artJobM.getArtistsInRadius(searchterm,nbrResults, lon, lat, radius);
	}
	
	@Transactional
	public List<BookerJob> searchBookerInArea(String searchterm, int nbrResults, double lon, double lat, double radiusKm){
		searchterm = "sede";
		double minlon=1;
		double maxlon = 15;
		double minlat = 1;
		double maxlat=15;
		List <BookerJob> bjs = bookJobM.searchArtistInArea(searchterm, nbrResults, minlon, maxlon, minlat, maxlat);
		return bjs;
	}
	
	@Transactional
	public List<Event> searchEventsInArea(String searchterm, int nbrResults, double lon, double lat, double radiusKm){
		double minlon=1;
		double maxlon = 15;
		double minlat = 1;
		double maxlat=15;
		return eventM.searchEventsInArea(searchterm, nbrResults, minlon, maxlon, minlat, maxlat);
		
	}
	
	public IArtistJobManager getArtJobM() {
		return artJobM;
	}

	public void setArtJobM(IArtistJobManager artJobM) {
		this.artJobM = artJobM;
	}

	public IBookerJobManager getBookJobM() {
		return bookJobM;
	}

	public void setBookJobM(IBookerJobManager bookJobM) {
		this.bookJobM = bookJobM;
	}

	
}
