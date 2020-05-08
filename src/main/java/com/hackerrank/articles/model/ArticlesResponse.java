package com.hackerrank.articles.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ArticlesResponse {

	@JsonProperty("page")
	private int page;
	
	@JsonProperty("per_page")
	private int perPage;
	
	@JsonProperty("total")
	private int total;
	
	@JsonProperty("total_pages")
	private int totalPages;
	
	@JsonProperty("data")
	private List<Article> data;
	
}
