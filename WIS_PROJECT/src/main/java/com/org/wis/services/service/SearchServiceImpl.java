package com.org.wis.services.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.ArtistJobManager;
import com.org.wis.data.dao.BookerJobManager;
import com.org.wis.data.dao.IArtistJobManager;
import com.org.wis.data.dao.IBookerJobManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.User;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	IArtistJobManager artJobM;
	
	@Autowired
	IBookerJobManager bookJobM;
	
	public SearchServiceImpl() {		

	}

	//searching for artists and bookers and get back the first 'nbrResults' results from db
	@Transactional
	public List<ArtistJob> searchArtist(String alias, int nbrResults) {
	
		List<ArtistJob> m = artJobM.getArtistByAlias(alias, nbrResults);	
		
		return m;
	}

	@Transactional
	public List<BookerJob> searchBooker(String name, int nbrResults) {
		
		return bookJobM.getBookerByLabel(name,nbrResults);
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
	
	
	
	//TODO
	//maybe search functionality to show artists within a radius of a place(lang,lat)

}
