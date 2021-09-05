package com.cite.moviesticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cite.moviesticketreservation.dao.BookingDetailDao;
import com.cite.moviesticketreservation.exception.InvalidInputException;
import com.cite.moviesticketreservation.exception.NotAuthorizedException;
import com.cite.moviesticketreservation.exception.NotLogedInException;
import com.cite.moviesticketreservation.model.BookingDetail;
import com.cite.moviesticketreservation.model.User;
import com.cite.moviesticketreservation.util.SessionUtil;

public class BookingDetailServiceImpl implements BookingDetailServiceInf {

	@Autowired
	private BookingDetailDao bookingDetailDao;

	public List<BookingDetail> findAllBooking() {
		checkLogIn();
		User user = SessionUtil.getCurrentSession();
		List<BookingDetail> bookingDetails = bookingDetailDao.findBooking(user.getId());
		return bookingDetails;
	}

	@Transactional
	public void saveBookingDetail(BookingDetail bookingDetail) {
		checkLogIn();
		User u = SessionUtil.getCurrentSession();
		System.out.println("test form here 1"+u.getId());
		bookingDetail.setUserId(u.getId());
		bookingDetailDao.saveBookingDetial(bookingDetail);
	}
	
	@Transactional
	public void deleteBookingDetail(int id) {
		checkLogIn();
		BookingDetail bookingDetail = bookingDetailDao.findBookingDetail(id);
		if (bookingDetailDao.findBookingDetail(id) == null) {
			throw new InvalidInputException("Database has no such Id" + id);
		}

		User currentUser = SessionUtil.getCurrentSession();

		if (currentUser.getId() == bookingDetail.getUserId()) {
			bookingDetailDao.deleteBookingDetail(id);
		} else {
			throw new NotAuthorizedException();
		}
	}
	
	@Transactional
	public void updateBookingDetail(BookingDetail bookingDetail) {
		checkLogIn();
		BookingDetail bookingDetails = bookingDetailDao.findBookingDetail(bookingDetail.getId());

		if (bookingDetails == null) {
			throw new InvalidInputException("Data doesnot exist" + bookingDetail.getId());
		}
		User u = SessionUtil.getCurrentSession();
		if (u.getId() == bookingDetails.getUserId()) {
			bookingDetailDao.updateBookingDetail(bookingDetails);
		} else {
			throw new NotAuthorizedException();

		}

	}
	
	
	
	public BookingDetail findBooking(int id) {
		checkLogIn();
		BookingDetail bookingDetail = bookingDetailDao.findBookingDetail(id);
		return bookingDetail;
	}
	
	
	private void checkLogIn() {
		User user = SessionUtil.getCurrentSession();
		if (user == null) {
			throw new NotLogedInException();
		}
	}

}
