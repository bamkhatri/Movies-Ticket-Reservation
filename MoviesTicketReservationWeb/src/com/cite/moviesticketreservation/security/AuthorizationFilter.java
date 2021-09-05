package com.cite.moviesticketreservation.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.cite.moviesticketreservation.exception.SessionExpiredException;
import com.cite.moviesticketreservation.model.AppError;
import com.cite.moviesticketreservation.model.User;
import com.cite.moviesticketreservation.util.JsonUtil;
import com.cite.moviesticketreservation.util.SessionUtil;

public class AuthorizationFilter extends BasicAuthenticationFilter{
	
	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		
		
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader("Authorization");
		System.out.println("Auth header value = "+header);
		
		if(header == null || !header.startsWith("Bearer")) {
			System.out.println("No Bearer Found");
			chain.doFilter(req, res);
			return;
		}
		
		String token = header.replace("Bearer", "").trim();
		System.out.println("Try setting session here for header: "+token);
		
		
		try {
			User user = SessionUtil.getUserFromToken(token);
			SessionUtil.saveSession(user);
			chain.doFilter(req, res);
		} catch (SessionExpiredException e) {
			res.setHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Control-Allow-Origin,Access-Control-Allow-Header,Authorization");
			res.setHeader("Content-Type", "application/json");
			
			PrintWriter writer = res.getWriter();
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			
			AppError appError = new AppError();
			appError.setMessage(e.getMessage());
			writer.write(JsonUtil.getJSONString(appError));
			writer.close();
		}
	}
}
