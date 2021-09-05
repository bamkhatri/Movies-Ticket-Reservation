package com.cite.moviesticketreservation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cite.moviesticketreservation.model.BookingDetail;

public class BookingDetailDao {

	@Autowired
	private JdbcTemplate jdbcT;

	public List<BookingDetail> findBooking(int userId) {
		System.out.println("Inside booking detail");
		String query = "select * from bookingdetail where userId = ? ";
		List<BookingDetail> booking = jdbcT.query(query, new BookingDetailMapper(), userId);
		return booking;

	}

	public BookingDetail findBookingDetail(int id) {
		String query = "select * from bookingdetail where id = ?";
		BookingDetail bookingDetail;
		try {
			bookingDetail = (BookingDetail) jdbcT.queryForObject(query, new BookingDetailMapper(), id);
			System.out.println(id);
			return bookingDetail;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void saveBookingDetial(BookingDetail bookingObj) {

		String query = "insert into bookingdetail(numberOfSeat,showTime,bookingDate,price,userId,movieId) values(?,?,?,?,?,?)";
		jdbcT.update(query, bookingObj.getNumberOfSeat(), bookingObj.getShowTime(), bookingObj.getBookingDate(),
				bookingObj.getPrice(), bookingObj.getUserId(),bookingObj.getMovieId());
	}

	public void deleteBookingDetail(int id) {
		String query = "delete from bookingdetail where id = ?";
		jdbcT.update(query, id);
	}

	public void updateBookingDetail(BookingDetail bookingDetail) {
		String query = "update  bookingdetail set numberOfSeat = ?, showTime = ?,bookingDate = ?,price = ? where id = ?";
		jdbcT.update(query, bookingDetail.getNumberOfSeat(), bookingDetail.getShowTime(),
				bookingDetail.getBookingDate(), bookingDetail.getPrice(), bookingDetail.getId());
	}

	

}
