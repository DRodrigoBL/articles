package com.hackerrank.articles.model;

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
public class Article {

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("author")
	private String author;
	
	@JsonProperty("num_comments")
	private int numComments;
	
	@JsonProperty("story_id")
	private String storyId;
	
	@JsonProperty("story_title")
	private String storyTitle;
	
	@JsonProperty("story_url")
	private String storyUrl;
	
	@JsonProperty("parent_id")
	private long parentId;
	
	@JsonProperty("created_at")
	private long createdAt;
	
}
