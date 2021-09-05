package com.cite.moviesticketreservation.model;

public class Movies {
	private String movieName;
	private String releasingDate;
	private String genre;
	private int year;
	private int id;
	private String cast;
	private String type;
	private String trailer;
	private String poster;

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getReleasingDate() {
		return releasingDate;
	}

	public void setReleasingDate(String releasingDate) {
		this.releasingDate = releasingDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String moviesName) {
		this.movieName = moviesName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int movieId) {
		this.id = movieId;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

}
