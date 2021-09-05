package com.cite.moviesticketreservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cite.moviesticketreservation.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
		User users = new User();
		users.setId(rs.getInt("id"));
		users.setName(rs.getString("name"));
		users.setEmail(rs.getString("email"));
		users.setMobileNo(rs.getString("mobileNo"));
		users.setPassword(rs.getString("password"));
		users.setGender(rs.getString("gender"));
		users.setDob(rs.getDate("dob"));
		users.setLocation(rs.getString("location"));
		return users;
	}

}
