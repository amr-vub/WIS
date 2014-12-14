package com.org.wis.data.dao;

import com.org.wis.data.domain.Location;

public interface ILocationManager {
	
	Location getLocationById(int LocId);
	
	Location getLocaByCoord(String coords); 
	
	void saveLocation(Location loc);
	
	void updateLocation(Location loc);
	
	void DeleteLocation(Location loc);

}

