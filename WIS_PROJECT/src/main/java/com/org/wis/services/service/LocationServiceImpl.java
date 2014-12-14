package com.org.wis.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.wis.data.dao.ILocationManager;
import com.org.wis.data.dao.IUserManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Event;
import com.org.wis.data.domain.Location;



@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	ILocationManager locationM;
	
	@Autowired
	IUserManager userM;

	@Transactional(readOnly = true)
	public Location findLocationById(int LocationID) {
		Location aj =  locationM.getLocationById(LocationID);
		return aj;
	}

	@Transactional
	public void saveLocation(Location location) {
		
		locationM.saveLocation(location);
		
	}

	@Transactional
	public void updateLocation(Location updatedLo) {
		Location dbLo = locationM.getLocationById(updatedLo.getLocationId());
		dbLo.setPlaceName(updatedLo.getPlaceName());
		dbLo.setCoordenate(updatedLo.getCoordenate());
		
		locationM.updateLocation(dbLo);
		
	}

	@Transactional
	public void deleteLocation(int uid, int LocationID) {
		Location lo = locationM.getLocationById(LocationID);
		
		locationM.DeleteLocation(lo);
	
	}

	@Transactional
	public Location getLocationById(int locationID) {
		return locationM.getLocationById(locationID);
	}

	

}
