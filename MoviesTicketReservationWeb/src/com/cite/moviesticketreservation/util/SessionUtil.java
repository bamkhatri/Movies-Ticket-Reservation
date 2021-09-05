package com.cite.moviesticketreservation.util;

import java.util.Base64;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cite.moviesticketreservation.exception.SessionExpiredException;
import com.cite.moviesticketreservation.model.SessionToken;
import com.cite.moviesticketreservation.model.User;


public class SessionUtil {
	public static void saveSession(User user) {
		UsernamePasswordAuthenticationToken authenticatedUser =
				new UsernamePasswordAuthenticationToken(user.getEmail(), null);
		
		authenticatedUser.setDetails(user);
		
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
	
	public static User getCurrentSession() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth.getPrincipal() == null || auth.getPrincipal().equals("anonymousUser")) {
			return null;
		}
		User u = (User) auth.getDetails();
		return u;
		
		
	}
	
	public static SessionToken generateToken(User u) {
		String token = u.getId()+"-"+u.getEmail()+"-"+System.currentTimeMillis();
		
		String encodedToken = encode(token);
		
		SessionToken sessionToken = new SessionToken();
		sessionToken.setToken(encodedToken);
		return sessionToken;
	}
	
	
	public static User getUserFromToken(String encodedToken) throws SessionExpiredException {
		String token = decode(encodedToken);
		String [] data = token.split("-");
		
		int id = Integer.parseInt(data[0]);
		String email = data[1];
		long tokenCreatedTime = Long.parseLong(data[2]);
		long currentTime = System.currentTimeMillis();
		
		long diffInMin = (currentTime - tokenCreatedTime)/(1000 * 60);
		
		//will expire after a day
		if(diffInMin > (60 * 24))
			throw new SessionExpiredException("Your session has expired. Please Login Again.");
		
		User u = new User();
		u.setId(id);
		u.setEmail(email);
		return u;
		
	}

	private static String encode(String arg) {
		byte[] strBytes = arg.getBytes();
		return Base64.getEncoder().encodeToString(strBytes);
	}
	
	private static String decode(String arg) {
		byte[] decodedBytes = Base64.getDecoder().decode(arg);
		return new String(decodedBytes);
	}

}
