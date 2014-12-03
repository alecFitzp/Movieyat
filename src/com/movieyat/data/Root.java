package com.movieyat.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {

	@JsonProperty("movies")
	private List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
