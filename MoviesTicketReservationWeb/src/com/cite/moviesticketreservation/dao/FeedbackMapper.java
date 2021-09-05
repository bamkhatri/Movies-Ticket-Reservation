package com.cite.moviesticketreservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cite.moviesticketreservation.model.Feedback;

public class FeedbackMapper implements RowMapper<Feedback> {
	@Override
	public Feedback mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Feedback feedback = new Feedback();
		feedback.setId(rs.getInt("id"));
		feedback.setEmail(rs.getString("email"));
		feedback.setSubject(rs.getString("subject"));
		feedback.setBody(rs.getString("body"));
		return feedback;
	}
}
