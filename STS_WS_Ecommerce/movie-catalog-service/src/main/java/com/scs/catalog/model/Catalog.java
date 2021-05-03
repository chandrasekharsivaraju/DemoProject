package com.scs.catalog.model;

public class Catalog {
	
	
	private String movieName;
	
	private String movieDesc;
	
	private int movieRating;
	
	
	public Catalog() {
		super();
		
	}

	public Catalog(String movieName, String movieDesc, int movieRating) {
		super();
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.movieRating = movieRating;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	@Override
	public String toString() {
		return "Catalog [movieName=" + movieName + ", movieDesc=" + movieDesc + ", movieRating=" + movieRating + "]";
	}



}
