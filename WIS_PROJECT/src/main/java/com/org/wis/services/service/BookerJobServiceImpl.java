package com.org.wis.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.org.wis.data.dao.IBookerJobManager;
import com.org.wis.data.domain.BookerJob;



@Service
public class BookerJobServiceImpl implements BookerJobService {

	@Autowired
	IBookerJobManager bookerJobM;

	@Transactional(readOnly = true)
	public BookerJob getBookerJobById(int bookerJobID) {
		BookerJob bj =  bookerJobM.getBookerJobById(bookerJobID);
		return bj;
	}

	@Transactional
	public void saveBookerJob(BookerJob bookerJob) {
		
		
		bookerJobM.saveBookerJob(bookerJob);
		
	}

	@Transactional
	public void updateBookerJob(BookerJob updatedBJ) {
		BookerJob dbBJ = bookerJobM.getBookerJobById(updatedBJ.getBookerJob());
		dbBJ.setDescription(updatedBJ.getDescription());
		dbBJ.setEmail(updatedBJ.getEmail());
		dbBJ.setGsm(updatedBJ.getGsm());
		dbBJ.setLabel(updatedBJ.getLabel());
		
		bookerJobM.updateBookerJob(dbBJ);
		
	}

	@Transactional
	public void deleteBookerJob(int bookerJobID) {
		BookerJob bj = bookerJobM.getBookerJobById(bookerJobID);
		if(bj != null){
			bookerJobM.deleteBookerJob(bj);
		}
	}

	@Transactional(readOnly = true)
	public List<BookerJob> getBookerByLabel(String label, int nbrResults) {
		return bookerJobM.getBookerByLabel(label, nbrResults);
	}
	
}
