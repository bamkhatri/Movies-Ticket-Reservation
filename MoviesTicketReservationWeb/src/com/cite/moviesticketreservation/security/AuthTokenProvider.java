package com.cite.moviesticketreservation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.cite.moviesticketreservation.model.User;
import com.cite.moviesticketreservation.service.UserServiceInf;


public class AuthTokenProvider implements AuthenticationProvider{

	@Autowired
	private UserServiceInf userService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getPrincipal().toString();
		
		if(authentication.getCredentials() == null)
			return authentication;
		
		String password  = authentication.getCredentials().toString();
		
		System.out.println("Authenticating Email = "+email+", Password = "+password);
		
		boolean isLogIn = userService.logIn(email,password);
		if(isLogIn == false) {
			throw new InvalidCredentialException("Invalid Email or Password");
		}
		User dbUser = userService.findUser(email);
		
		UsernamePasswordAuthenticationToken authenticated = new UsernamePasswordAuthenticationToken(email, password);
		authenticated.setDetails(dbUser);
		return authenticated;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	

}
