package com.movieyat.data;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	@JsonProperty("id")
	private String id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("year")
	private String year;
	@JsonProperty("release_dates")
	private Map<String, String> release_dates;
	@JsonProperty("ratings")
	private Map<String, String> ratings;
	@JsonProperty("synopsis")
	private String synopsis;
	@JsonProperty("posters")
	private Map<String, String> posters;
	@JsonProperty("abridged_cast")
	private List<Cast> casts;
	@JsonProperty("links")
	private Map<String, String> links;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Map<String, String> getRelease_dates() {
		return release_dates;
	}
	public void setRelease_dates(Map<String, String> release_dates) {
		this.release_dates = release_dates;
	}
	public Map<String, String> getRatings() {
		return ratings;
	}
	public void setRatings(Map<String, String> ratings) {
		this.ratings = ratings;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Map<String, String> getPosters() {
		return posters;
	}
	public void setPosters(Map<String, String> posters) {
		this.posters = posters;
	}
	public List<Cast> getCasts() {
		return casts;
	}
	public void setCasts(List<Cast> casts) {
		this.casts = casts;
	}
	public Map<String, String> getLinks() {
		return links;
	}
	public void setLinks(Map<String, String> links) {
		this.links = links;
	}
	
}
