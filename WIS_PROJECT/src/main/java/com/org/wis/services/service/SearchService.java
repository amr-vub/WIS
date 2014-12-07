package com.org.wis.services.service;

import java.util.Map;

import com.org.wis.data.domain.User;


public interface SearchService {
	public Map<String,User> searchArtist(String alias, int nbrResults);
	public Map<String,User> searchBooker(String name, int nbrResults);
	
}
