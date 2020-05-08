package com.hackerrank.articles;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hackerrank.articles.service.ArticlesService;
import com.hackerrank.articles.utils.LoggingUtils;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GetArticlesTest {

	@Autowired
	ArticlesService service;
	
	@Test
	public void testArticles() {
		
		log.info("HACKER RANK CLIENT TEST");
		
		List<String> articles = service.getMostCommentedArticleTitles(2);
		
		log.info("----- MOST VOTED ARTICLES TITLES {}", LoggingUtils.getJsonFormat(articles, false));
		
	}
	
	
	
}
