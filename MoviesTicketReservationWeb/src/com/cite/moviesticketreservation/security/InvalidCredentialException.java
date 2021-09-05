package com.cite.moviesticketreservation.security;

import org.springframework.security.core.AuthenticationException;

public class InvalidCredentialException extends AuthenticationException{
	
	public InvalidCredentialException(String msg) {
		super(msg);
	}

}
