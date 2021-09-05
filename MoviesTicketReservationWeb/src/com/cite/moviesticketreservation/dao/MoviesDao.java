package com.cite.moviesticketreservation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cite.moviesticketreservation.model.Movies;

public class MoviesDao {
	@Autowired
	private JdbcTemplate jdbcT;

	public Movies findMovies(int movieId) {
		System.out.println("Inside movies table????");
		String query = "select * from movies where id = ?";
		try {
			Movies movies = jdbcT.queryForObject(query, new MoviesMapper(), movieId);
			System.out.println("Name of movies:" + movies.getMovieName());
			return movies;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public void saveMovies(Movies m) {
		String query = "insert into movies (name,releasingDate,genre,year,cast,type) values(?,?,?,?,?,?,?)";
		jdbcT.update(query, m.getMovieName(), m.getReleasingDate(), m.getGenre(), m.getYear(), m.getCast(),m.getType());

	}
	
	public List<Movies>  moviesList() {
		String query = "select * from movies";
		List<Movies> movies = jdbcT.query(query, new MoviesMapper());
		return movies;
	}
	

	
	public void deleteMovie(int movieId) {
		String query = "delete from movies where id = ?";
		jdbcT.update(query, movieId);
	}
	
	public void updateMovie(Movies movies) {
		String query = "update  movies set name = ?,releasingDate = ?,genre = ?,year = ?,cast = ? ,type = ? where id = ?";
		jdbcT.update(query,movies.getMovieName(), movies.getReleasingDate(), movies.getGenre(), movies.getYear(), movies.getCast(), movies.getType(),movies.getId());
		
	}
	
	
}
