package com.scs.catalog.model;

public class Rating {
	
	private int movieId;
	
	private int Rating;
	
	

	public Rating() {
		super();
		
	}

	public Rating(int movieId, int rating) {
		super();
		this.movieId = movieId;
		Rating = rating;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", Rating=" + Rating + "]";
	}
	
	

}
