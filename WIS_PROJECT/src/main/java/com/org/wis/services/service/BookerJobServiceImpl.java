package com.org.wis.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






import com.org.wis.data.dao.IBookerJobManager;
import com.org.wis.data.dao.IUserManager;
import com.org.wis.data.dao.LocationManager;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.User;



@Service
public class BookerJobServiceImpl implements BookerJobService {

	@Autowired
	IUserManager userM;
	
	@Autowired
	IBookerJobManager bookerJobM;

	@Autowired
	LocationManager locationM;
	
	@Autowired
	userService userS;
	
	@Transactional(readOnly = true)
	public BookerJob getBookerJobById(int bookerJobID) {
		BookerJob bj =  bookerJobM.getBookerJobById(bookerJobID);
		return bj;
	}

	
	@Transactional
	public void addBookerJob(int id, BookerJob newBJ){
	
		User u = userS.getUserById(id);
		u.getBookerJob().add(newBJ);
		newBJ.setBookerUser(u);
		Location l = newBJ.getBookerLocation();
		l.getBookerJobs().add(newBJ);
		userM.updateUser(u);
		locationM.saveLocation(l);
		bookerJobM.saveBookerJob(newBJ);
		
	}

	@Transactional
	public void updateBookerJob(BookerJob updatedBJ) {
		BookerJob dbBJ = bookerJobM.getBookerJobById(updatedBJ.getBookerJob());
		dbBJ.setDescription(updatedBJ.getDescription());
		dbBJ.setEmail(updatedBJ.getEmail());
		dbBJ.setGsm(updatedBJ.getGsm());
		dbBJ.setLabel(updatedBJ.getLabel());
		Location l =updatedBJ.getBookerLocation();
		dbBJ.getBookerLocation().setLon(l.getLon());
		dbBJ.getBookerLocation().setLat(l.getLat());
		locationM.updateLocation(l);
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
