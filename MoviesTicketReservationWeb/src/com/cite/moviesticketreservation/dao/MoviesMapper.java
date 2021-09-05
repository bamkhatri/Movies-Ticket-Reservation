package com.cite.moviesticketreservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cite.moviesticketreservation.model.Movies;

public class MoviesMapper implements RowMapper<Movies> {

	@Override
	public Movies mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Movies movies = new Movies();
		movies.setId(rs.getInt("id"));
		movies.setMovieName(rs.getString("name"));
		movies.setReleasingDate(rs.getString("releasingDate"));
		movies.setGenre(rs.getString("genre"));
		movies.setYear(rs.getInt("year"));
		movies.setCast(rs.getString("cast"));
		movies.setType(rs.getString("type"));
		movies.setTrailer(rs.getString("trailer"));
		movies.setPoster(rs.getString("poster"));
		return movies;

	}

}
