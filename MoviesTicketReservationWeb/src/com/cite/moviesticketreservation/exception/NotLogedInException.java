package com.cite.moviesticketreservation.exception;
public class NotLogedInException extends RuntimeException {
	
	public NotLogedInException() {
		super("You are not Loged In");
	}

}
