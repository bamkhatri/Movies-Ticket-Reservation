package com.cite.moviesticketreservation.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cite.moviesticketreservation.exception.InvalidInputException;
import com.cite.moviesticketreservation.exception.NotAuthorizedException;
import com.cite.moviesticketreservation.exception.NotLogedInException;
import com.cite.moviesticketreservation.model.AppError;

public class ControllerBase {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public AppError handleException(Exception e,HttpServletRequest req,HttpServletResponse res) {
		AppError appError = new AppError();
		System.out.println("an error occured" + e.getMessage());
		
		if(e instanceof InvalidInputException) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			appError.setMessage(e.getMessage());
		}else if(e instanceof NotLogedInException){
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			appError.setMessage(e.getMessage());
		}else if (e instanceof NotAuthorizedException) {
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			appError.setMessage(e.getMessage());
		} else {
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			appError.setMessage("Something Unexcepted went Wrong");
			e.printStackTrace();
		}
		return appError;
	}

}


