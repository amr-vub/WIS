package com.org.wis.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.User;


public interface BookingService {
	
	public void bookArtist(int bookerid, int artistid, int eventid);
}
