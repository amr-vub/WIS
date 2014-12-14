package com.org.wis.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.User;


public interface BookerJobService {
	
BookerJob getBookerJobById(int bookerJobID);
	
	void saveBookerJob(BookerJob bookerJob);
	
	void updateBookerJob(BookerJob bookerJob);
	
	void deleteBookerJob(int bookerJobID);
	
	public List<BookerJob> getBookerByLabel(String label, int nbrResults);
}
