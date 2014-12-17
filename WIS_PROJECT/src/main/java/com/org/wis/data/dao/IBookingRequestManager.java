package com.org.wis.data.dao;

import com.org.wis.data.domain.BookingRequest;

public interface IBookingRequestManager {

	BookingRequest getBrByID(int brId);
	
	void saveBr(BookingRequest br);
	
	void updateBr(BookingRequest br);
	
	void deleteBr(BookingRequest br);
}
