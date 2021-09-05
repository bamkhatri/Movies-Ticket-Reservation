package com.cite.moviesticketreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cite.moviesticketreservation.model.BookingDetail;
import com.cite.moviesticketreservation.model.Movies;
import com.cite.moviesticketreservation.service.BookingDetailServiceInf;
import com.cite.moviesticketreservation.service.MoviesServiceInf;

@Controller
@RequestMapping("/booking")
public class BookingDetailController extends ControllerBase {

	@Autowired
	private BookingDetailServiceInf bookingDetailService;
	
	@Autowired
	private MoviesServiceInf moviesService;

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	@ResponseBody
	public List<BookingDetail> displayAllBooking() {
		System.out.println("welcome to display");
		List<BookingDetail> bookingDetails = bookingDetailService.findAllBooking();
		return bookingDetails;

	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public void saveBooking(@RequestBody BookingDetail bookingDetail) {
		System.out.println("My user ID is:"+bookingDetail.getUserId());
		bookingDetailService.saveBookingDetail(bookingDetail);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public void deleteBooking(@RequestBody BookingDetail bookingDetail) {
		bookingDetailService.deleteBookingDetail(bookingDetail.getId());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public BookingDetail updateBookingDetail(@RequestBody BookingDetail bookingDetail) {
		BookingDetail booking = new BookingDetail();

		booking.setId(bookingDetail.getId());
		booking.setNumberOfSeat(bookingDetail.getNumberOfSeat());
		booking.setShowTime(bookingDetail.getShowTime());
		booking.setBookingDate(bookingDetail.getBookingDate());
		booking.setPrice(bookingDetail.getPrice());
		bookingDetailService.updateBookingDetail(booking);
		return booking;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BookingDetail findBooking(@PathVariable int id) {
		BookingDetail bookingDetail = bookingDetailService.findBooking(id);
		return bookingDetail;
	}
	
	
	
	@RequestMapping(value = "/getmovie/{movieId}", method = RequestMethod.GET)
	@ResponseBody
	public Movies findMovies(@PathVariable int movieId) {
		System.out.println("sdihfsuidfhusd:" +movieId);
		Movies movie = moviesService.findMovie(movieId);
		System.out.println("Hello: "+movie);
		return movie;
	}

}
