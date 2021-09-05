package com.cite.moviesticketreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cite.moviesticketreservation.model.Feedback;
import com.cite.moviesticketreservation.service.FeedbackServiceInf;

@Controller
@RequestMapping("/feedback")
public class FeedbackController extends ControllerBase {
	
	@Autowired
	private FeedbackServiceInf feedbackService;
	
	@RequestMapping(value = "/registerfeedback", method = RequestMethod.POST)
	@ResponseBody
	public Feedback register(@RequestBody Feedback feedback) {
		feedbackService.saveFeedback(feedback);
		return feedback;
	}

}
