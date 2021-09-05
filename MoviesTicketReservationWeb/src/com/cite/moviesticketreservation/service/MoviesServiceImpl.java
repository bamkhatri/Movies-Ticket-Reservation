package com.cite.moviesticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cite.moviesticketreservation.dao.MoviesDao;
import com.cite.moviesticketreservation.exception.InvalidInputException;
import com.cite.moviesticketreservation.exception.NotAuthorizedException;
import com.cite.moviesticketreservation.model.Movies;

public class MoviesServiceImpl implements MoviesServiceInf {

	@Autowired
	private MoviesDao moviesDao;

	@Transactional
	public void movieRegister(Movies movies) {
		String name = movies.getMovieName();
		String genre = movies.getGenre();
		String cast = movies.getCast();
		int movieId = movies.getId();
		String type = movies.getType();
		if (name == null || name.trim().isEmpty())
			throw new InvalidInputException("please provide your Name");
		if (genre == null || genre.trim().isEmpty())
			throw new InvalidInputException("Please provide your genre");
		if (cast == null || cast.trim().isEmpty())
			throw new InvalidInputException("Please provide cast");
		if (type == null || type.trim().isEmpty())
			throw new InvalidInputException("Please provide your type");
		if (Integer.toString(movieId) == null || Integer.toString(movieId).trim().isEmpty())
			throw new InvalidInputException("Please provide your gender");
		// we have to valid date and year here below
		Movies dbMovies = moviesDao.findMovies(movieId);

		if (dbMovies == null)
			moviesDao.saveMovies(movies);
		else
			throw new InvalidInputException("something went wrong");
	}

	public List<Movies> displayMovie() {
		List<Movies> movies = moviesDao.moviesList();
		return movies;
	}


	@Transactional
	public void deleteMovie(int movieId) {
		Movies movies = moviesDao.findMovies(movieId);
		if (moviesDao.findMovies(movieId) == null) {
			throw new InvalidInputException("Database has no such movie Id" + movieId);
		}
		if (movies.getId() == movies.getId()) {
			moviesDao.deleteMovie(movieId);
		} else {
			throw new NotAuthorizedException();
		}
	}
	
	@Transactional
	public void updateMovie(Movies movies) {
		Movies movie = moviesDao.findMovies(movies.getId());
		if(movie == null) {
			throw new InvalidInputException("Movie does not exist "+movies.getId());
		}
		if(movie.getId() == movies.getId()) {
			moviesDao.updateMovie(movies);
		}else {
			throw new NotAuthorizedException();
		}
		
	}


	public Movies findMovie(int movieId) {
		Movies m = moviesDao.findMovies(movieId);
		System.out.println(moviesDao.findMovies(movieId));
		return m;
	}

	
	

}
