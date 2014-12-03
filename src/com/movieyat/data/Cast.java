package com.movieyat.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cast {

	private String id;
	private String name;
	
	@JsonCreator
	public Cast(@JsonProperty("id") String id,@JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
