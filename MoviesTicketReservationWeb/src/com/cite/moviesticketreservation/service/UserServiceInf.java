package com.cite.moviesticketreservation.service;

import java.util.List;

import com.cite.moviesticketreservation.model.User;

public interface UserServiceInf {
	
	public boolean logIn(String email, String password);

	public void register(User u);

	public List<User> displayUser();

	public User findUser(String email);

}
