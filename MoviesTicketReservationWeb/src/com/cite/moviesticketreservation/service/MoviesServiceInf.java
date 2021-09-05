package com.cite.moviesticketreservation.service;

import java.util.List;

import com.cite.moviesticketreservation.model.Movies;

public interface MoviesServiceInf {
	
	public void movieRegister(Movies movies);
	
	public List<Movies> displayMovie();
		
	public void deleteMovie(int movieId);
	
	public void updateMovie(Movies movies);
	
	public Movies findMovie(int movieId);
	
}
