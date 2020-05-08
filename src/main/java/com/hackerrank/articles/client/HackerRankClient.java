package com.hackerrank.articles.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hackerrank.articles.model.ArticlesResponse;

/**
 * Spring Cloud Feign Client capable of calling the HackerRank REST API.
 * 
 * @author Rodrigo Bautista
 *
 */
@FeignClient(name = "hackerRankClient", url = "https://jsonmock.hackerrank.com")
public interface HackerRankClient {

	/**
	 * Specific HackerRank API.
	 * 
	 * @return ArticlesResponse that will be mapped with GET HTTP response boyd.
	 */
	@GetMapping("/api/articles")
	public ArticlesResponse getArticles();

}
