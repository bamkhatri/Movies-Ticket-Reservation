 package com.cite.moviesticketreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cite.moviesticketreservation.dao.FeedbackDao;
import com.cite.moviesticketreservation.exception.InvalidInputException;
import com.cite.moviesticketreservation.model.Feedback;

public class FeedbackServiceImpl implements FeedbackServiceInf{

	@ Autowired
	private FeedbackDao feedbackDao;
	
	@Transactional
	public void saveFeedback(Feedback feedback) {
		String email = feedback.getEmail();
		String subject = feedback.getSubject();
		String body = feedback.getBody();
		
		Feedback db_feedback = new Feedback();
		if (email == null || email.trim().isEmpty())
			throw new InvalidInputException("please provide your Email");
		if (subject == null || subject.trim().isEmpty())
			throw new InvalidInputException("Please provide your Subject");
		if (body == null || body.trim().isEmpty())
			throw new InvalidInputException("Please provide Body");
		
		db_feedback.setId(db_feedback.getId());
		feedbackDao.saveFeedback(feedback);
		
	}

}
