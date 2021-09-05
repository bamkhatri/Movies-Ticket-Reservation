package com.cite.moviesticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cite.moviesticketreservation.dao.UserDao;
import com.cite.moviesticketreservation.exception.InvalidInputException;
import com.cite.moviesticketreservation.model.User;

public class UserServiceImpl implements UserServiceInf {

	@Autowired
	private UserDao userDao;

	@Transactional
	public boolean logIn(String email, String password) {
		// TODO: empty and null validation
		if (email == null || email.trim().isEmpty())
			throw new InvalidInputException("Please provide your Email");
		if (password == null || password.trim().isEmpty())
			throw new InvalidInputException("Please provide your Password");

		User dbUser = userDao.findUser(email);

		if (dbUser == null)
			return false;

		if (!dbUser.getPassword().equals(password))
			return false;

		return true;
	}

	@Transactional
	public void register(User u) {

		String name = u.getName();
		String email = u.getEmail();
		String moblieNo = u.getMobileNo();
//		String num = Integer.toString(moblieNo);
		String password = u.getPassword();
		String gender = u.getGender();
		// Date dob = new Date(u.getDob().getTime());
		String location = u.getLocation();

		// TODO: validate provided email and password
		if (name == null || name.trim().isEmpty())
			throw new InvalidInputException("please provide your Name");
		if (email == null || email.trim().isEmpty())
			throw new InvalidInputException("Please provide your Email");
		if (moblieNo == null || moblieNo.trim().isEmpty())
			throw new InvalidInputException("Please provide mobile number");
		if (password == null || password.trim().isEmpty())
			throw new InvalidInputException("Please provide your Password");
		if (gender == null || gender.trim().isEmpty())
			throw new InvalidInputException("Please provide your gender");
		if (location == null || location.trim().isEmpty())
			throw new InvalidInputException("Please provide your location ");
		/*
		 * if(dob == null) throw new
		 * InvalidInputException("Please provide Date of birth");
		 */

		// we should check if this email already exits in db or not

		User dbUser = userDao.findUser(email);

		if (dbUser == null)
			userDao.saveUser(u);
		else
			throw new InvalidInputException("something went wrong");
	}

	public List<User> displayUser() {
		List<User> user = userDao.findUser();
		return user;
	}

	@Override
	public User findUser(String email) {
		User u = userDao.findUser(email);
		return u;
	}

}
