package com.cite.moviesticketreservation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cite.moviesticketreservation.model.User;


public class UserDao {


		@Autowired
		private JdbcTemplate jdbcT;

		public User findUser(String email) {
			String query = "select * from users where email = ?";
			try {
				User s = jdbcT.queryForObject(query,new UserMapper(), email);
				System.out.println("Name:"+s.getName()+s.getId());
				return s;
				
			} catch (EmptyResultDataAccessException e) {
				return null;
			}

		}
		
		public void saveUser(User u)  {
				String query = "insert into users(name,email,mobileNo,password,gender,dob,location) values(?,?,?,?,?,?,?)";
				jdbcT.update(query,u.getName(),u.getEmail(),u.getMobileNo(),u.getPassword(),u.getGender(),u.getDob(),u.getLocation());
			
		}
		
		public List<User> findUser() {

			String query = "select * from users";

			List<User> user = jdbcT.query(query, new UserMapper());
			return user;

		}


	}


