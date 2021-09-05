package com.cite.moviesticketreservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cite.moviesticketreservation.model.BookingDetail;

public class BookingDetailMapper implements RowMapper<BookingDetail> {

	@Override
	public BookingDetail mapRow(ResultSet rs, int rowNumber) throws SQLException {
		BookingDetail bookingDetails = new BookingDetail();
		bookingDetails.setId(rs.getInt("id"));
		bookingDetails.setNumberOfSeat(rs.getInt("numberOfSeat"));
		bookingDetails.setShowTime(rs.getString("showTime"));
		bookingDetails.setBookingDate(rs.getDate("bookingDate"));
		bookingDetails.setPrice(rs.getInt("price"));
		bookingDetails.setUserId(rs.getInt("userId"));
		bookingDetails.setMovieId(rs.getInt("movieId"));
		return bookingDetails;
	}

}
