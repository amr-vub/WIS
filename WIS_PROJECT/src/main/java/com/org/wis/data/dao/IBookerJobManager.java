package com.org.wis.data.dao;

import java.util.List;

import com.org.wis.data.domain.BookerJob;

public interface IBookerJobManager {

	BookerJob getBookerJobById(int BookerJobId);
	
	void saveBookerJob(BookerJob bookerJob);
	
	void updateBookerJob(BookerJob bookerJob);
	
	void deleteBookerJob(BookerJob bookerJob);
	
	public List<BookerJob> getBookerByLabel(String label, int nbrResults);
}
