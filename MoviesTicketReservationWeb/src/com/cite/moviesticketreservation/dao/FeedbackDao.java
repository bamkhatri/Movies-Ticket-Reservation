package com.cite.moviesticketreservation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cite.moviesticketreservation.model.Feedback;

public class FeedbackDao {

	@Autowired
	private JdbcTemplate jdbcT;
	
	public Feedback feedbackId(int id) {
		String query = "select * from bookingdetail where id = ?";
		Feedback feedback;
		try {
			feedback = (Feedback) jdbcT.queryForObject(query, new FeedbackMapper(), id);
			System.out.println(id);
			return feedback;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	
	public void saveFeedback(Feedback feedback) {

		String query = "insert into feedback(email,subject,body) values(?,?,?)";
		jdbcT.update(query, feedback.getEmail(),feedback.getSubject(),feedback.getBody() );
	}

}
