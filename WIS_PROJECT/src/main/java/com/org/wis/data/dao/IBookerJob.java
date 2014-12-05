package com.org.wis.data.dao;

public interface IBookerJob {

	BookerJob getBookerJobById(int BookerJobId);
	
	void saveBookerJob(BookerJob bookerJob);
	
	void updateBookerJob(BookerJob bookerJob);
	
	void deleteBookerJob(BookerJob bookerJob);
}
