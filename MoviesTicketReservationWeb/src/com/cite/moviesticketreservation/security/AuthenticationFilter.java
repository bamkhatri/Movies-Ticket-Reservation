package com.cite.moviesticketreservation.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cite.moviesticketreservation.model.AppError;
import com.cite.moviesticketreservation.model.SessionToken;
import com.cite.moviesticketreservation.model.User;
import com.cite.moviesticketreservation.util.JsonUtil;
import com.cite.moviesticketreservation.util.SessionUtil;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	public AuthenticationFilter() {
		this.setFilterProcessesUrl("/user/login");
	}
	
	@Override
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Control-Allow-Origin,Access-Control-Allow-Header,Authorization");
			response.setHeader("Content-Type", "application/json");
			
			if(request.getMethod().equals(HttpMethod.OPTIONS.toString()))
				return null;
				
			
			System.out.println("Http Method "+request.getMethod());
			ServletInputStream in = request.getInputStream();
			User u = JsonUtil.parseJSON(in, User.class);
			
			System.out.println("performing authentication with data: "+JsonUtil.getJSONString(u));
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(u.getEmail(), u.getPassword());
			return getAuthenticationManager().authenticate(auth);
		}catch(IOException e1) {
			throw new RuntimeException(e1);
		}
		
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authResult;
		User user = (User) authToken.getDetails();
		System.out.println("Successfull authentication for user");
		System.out.println("User Details "+JsonUtil.getJSONString(user));
		
		SessionToken sessionToken = SessionUtil.generateToken(user);
		PrintWriter writer = response.getWriter();
		writer.write(JsonUtil.getJSONString(sessionToken));
		writer.close();
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		System.out.println("Invalid authentication "+failed.getMessage());
		
		PrintWriter writer = response.getWriter();
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		AppError appError = new AppError();
		appError.setMessage(failed.getMessage());
		writer.write(JsonUtil.getJSONString(appError));
		writer.close();
	}
	

}
