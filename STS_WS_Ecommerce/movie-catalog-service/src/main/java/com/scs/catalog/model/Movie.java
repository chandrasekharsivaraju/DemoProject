package com.scs.catalog.model;

public class Movie {
	
	private int movieId;
	
	private String movieName;
	
	private String movieDescription;
	
	
	public Movie() {
		super();
	}

	public Movie(int movieId, String movieName, String movieDescription) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ "]";
	}
	
	
	

}
