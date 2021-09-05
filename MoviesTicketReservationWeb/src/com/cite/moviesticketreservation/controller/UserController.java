package com.cite.moviesticketreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cite.moviesticketreservation.dao.UserDao;
import com.cite.moviesticketreservation.exception.InvalidInputException;
import com.cite.moviesticketreservation.model.User;
import com.cite.moviesticketreservation.service.UserServiceInf;
@Controller
@RequestMapping("/user")
public class UserController extends ControllerBase {
	@Autowired
	private UserServiceInf userService;
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public User register(@RequestBody User user) {
		userService.register(user);
		return user;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User logIn(@RequestBody User user) {
		boolean check = userService.logIn(user.getEmail(), user.getPassword());
		if (check == true) {
			System.out.println("login");
			getUserByEmail(user.getEmail());
			return user;
			
		} else {
			throw new InvalidInputException("Invalid email or password");
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<User> displayUserList() {
		List<User> user = userService.displayUser();
		return user;
	}
	
	public User getUserByEmail(String email) {
		User users =  userDao.findUser(email);
		return users;
	}
}






