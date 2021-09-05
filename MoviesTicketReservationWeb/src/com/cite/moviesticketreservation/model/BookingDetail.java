package com.cite.moviesticketreservation.model;

import java.util.Date;

public class BookingDetail {
	private int id;
	private int numberOfSeat;
	private Date bookingDate;
	private String showTime;
	private int price;
	private int userId;
	private int movieId;
	
	
	
	
	
	@Override
	public String toString() {
		return "BookingDetail [id=" + id + ", numberOfSeat=" + numberOfSeat + ", bookingDate=" + bookingDate
				+ ", showTime=" + showTime + ", price=" + price + ", userId=" + userId + "]";
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
