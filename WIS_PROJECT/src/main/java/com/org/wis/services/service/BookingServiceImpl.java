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
import com.org.wis.data.dao.IEventManager;
import com.org.wis.data.dao.IUserManager;
import com.org.wis.data.dao.LocationManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.Ranking;
import com.org.wis.data.domain.User;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	IArtistJobManager artJobM;
	
	@Autowired
	IBookerJobManager bookerM;
	
	@Autowired
	IEventManager eventM;
	
	@Autowired
	IBookingRequestManager bookingM;
	
	@Transactional
	public void bookArtist(int bid, int aid, int eid) {
		BookerJob bj = bookerM.getBookerJobById(bid);
		ArtistJob aj = artJobM.getArtistJobById(aid);
		Event e = eventM.getEventById(eid);
		bookingM.addBookingRequest(bid, aid,eid);
	}

}
