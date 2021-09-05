package com.cite.moviesticketreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cite.moviesticketreservation.model.Movies;
import com.cite.moviesticketreservation.service.MoviesServiceInf;

@Controller
@RequestMapping("/movies")
public class MoviesController extends ControllerBase {

	@Autowired
	private MoviesServiceInf moviesService;
	
	@RequestMapping(value = "/registermovies", method = RequestMethod.POST)
	@ResponseBody
	public Movies register(@RequestBody Movies movies) {
		moviesService.movieRegister(movies);
		return movies;
	}
	
	@RequestMapping(value = "/displaymovie", method = RequestMethod.GET)
	@ResponseBody
	public List<Movies> displayNowShowingMovies() {
		System.out.println("welcome to display");
		List<Movies> movies = moviesService.displayMovie();
		return movies;

	}
	
	@RequestMapping(value = "/deletemovie", method = RequestMethod.POST)
	@ResponseBody
	public void deleteMovie(@RequestBody Movies movies) {
		moviesService.deleteMovie(movies.getId());;
	}
	
	@RequestMapping(value = "/updatemovie", method = RequestMethod.POST)
	@ResponseBody
	public Movies updateMovie(@RequestBody Movies movies) {
		Movies movie = new Movies();
		movie.setId(movies.getId());
		movie.setMovieName(movies.getMovieName());
		movie.setReleasingDate(movies.getReleasingDate());
		movie.setGenre(movies.getGenre());
		movie.setYear(movies.getYear());
		movie.setCast(movies.getCast());
		movie.setType(movies.getType());
		moviesService.updateMovie(movies);
		return movie;
	}
	
	
	@RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
	@ResponseBody
	public Movies findMovie(@PathVariable int movieId) {
		Movies movies = moviesService.findMovie(movieId);
		return movies;
	}
	
	
}
