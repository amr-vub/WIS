package com.org.wis.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.User;


public interface LocationService {
	
	Location getLocationById(int LocationID);
	
	void saveLocation(Location Location);
	
	void updateLocation(Location Location);
	
	void deleteLocation(int uid, int LocationID);
	
	
}
