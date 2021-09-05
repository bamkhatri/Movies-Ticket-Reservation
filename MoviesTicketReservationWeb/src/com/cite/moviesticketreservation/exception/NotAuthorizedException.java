package com.cite.moviesticketreservation.exception;

public class NotAuthorizedException extends RuntimeException {
	
	public NotAuthorizedException(){
		super("You are not Legal User");
	}

}
