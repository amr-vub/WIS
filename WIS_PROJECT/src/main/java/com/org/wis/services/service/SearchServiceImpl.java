package com.org.wis.services.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.wis.data.dao.ArtistJobManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.User;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	ArtistJobManager artJobM;
	
	@Autowired
	BookerJobManager bookJobM;
	
	//searching for artists and bookers and get back the first 'nbrResults' results from db
	public Map<String, User> searchArtist(String alias, int nbrResults) {
	
		//should this return only the artistjob or the user object?
		Map<String, ArtistJob> m = artJobM.searchAlias(alias,nbrResults);	
		return null;
	}

	public Map<String, User> searchBooker(String name, int nbrResults) {
		
		//what is search field.. name?
		return bookJobM.search(name,nbrResults);
	}
	
	//TODO
	//maybe search functionality to show artists within a radius of a place(lang,lat)

}
