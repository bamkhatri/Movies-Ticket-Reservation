package com.cite.moviesticketreservation.service;

import java.util.List;

import com.cite.moviesticketreservation.model.BookingDetail;

public interface BookingDetailServiceInf {
	
	public List<BookingDetail> findAllBooking();

	public void saveBookingDetail(BookingDetail bookingDetail);

	public void deleteBookingDetail(int id);

	public void updateBookingDetail(BookingDetail bookingDetail);

	public BookingDetail findBooking(int id);
	
	
	
	
	
	

}
