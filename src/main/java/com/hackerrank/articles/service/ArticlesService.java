package com.hackerrank.articles.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.articles.client.HackerRankClient;
import com.hackerrank.articles.model.Article;
import com.hackerrank.articles.model.ArticlesResponse;
import com.hackerrank.articles.utils.LoggingUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Service that can inspect a list of Articles from HackerRank API and order
 * them by number of comments.
 * 
 * @author Rodrigo Bautista
 *
 */
@Service
@Slf4j
public class ArticlesService {

	/**
	 * Feing Client that performs the HTTP GET call.
	 */
	@Autowired
	HackerRankClient client;

	/**
	 * Method that receives a limit as input and obtains a list of Articles from
	 * which it will parse the response ordering the articles by number of comments
	 * and get the corresponding Aritcle Titles.
	 * 
	 * @param limit integer representing how many articles will be parsed.
	 * @return a list of the most voted Article Titles.
	 */
	public List<String> getMostCommentedArticleTitles(int limit) {

		log.info("ArticlesService::getMostCommentedArticleTitles called with limit: {}", limit);
		ArticlesResponse articlesResponse = client.getArticles();

		List<Article> articlesList = articlesResponse.getData();

		List<String> mostCommentedArticleTitles = articlesList.stream()
				.sorted(Comparator.comparing(Article::getNumComments).reversed())
				.map(article -> getArticleTtitleOrFallbackOnStoryTitle(article)).limit(limit)
				.collect(Collectors.toList());
		log.info("ArticlesService::getMostCommentedArticleTitles responding with titles list: {}",
				LoggingUtils.getJsonFormat(articlesList, false));
		return mostCommentedArticleTitles;
	}

	/**
	 * Method used to help mapping process and determine if the article title is
	 * null to use the story title string instead.
	 * 
	 * @param article instance object from where the title will be evaluated.
	 * @return the title string if not null, the story title otherwise.
	 */
	private String getArticleTtitleOrFallbackOnStoryTitle(Article article) {
		if (article.getTitle() != null) {
			return article.getTitle();
		} else {
			return article.getStoryTitle();
		}
	}

}
