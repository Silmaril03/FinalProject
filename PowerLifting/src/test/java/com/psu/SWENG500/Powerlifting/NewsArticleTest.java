package com.psu.SWENG500.Powerlifting;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.ejbs.NewsArticle;

import junit.framework.TestCase;

public class NewsArticleTest extends TestCase {

	private NewsArticle article;
	private Date articleDate = new Date(1486174210416L);
	
	@Before
	public void setUp() throws Exception {
		article = new NewsArticle("Title", "muscles.com", articleDate, "Short description", "Article contents.");
	}

	@Test
	public void articleTitleSuccess() {
		assertEquals("Title", article.getArticleTitle());
	}

	@Test
	public void siteOriginSuccess() {
		assertEquals("muscles.com", article.getSiteOrigin());
	}
	
	@Test
	public void articleDateSuccess() {
		long actualMilliseconds = articleDate.getTime();
		assertEquals(actualMilliseconds, article.getArticleDate().getTime());
	}
	
	@Test
	public void articleShortDescriptionSuccess() {
		assertEquals("Short description", article.getArticleShortDescription());
	}
	
	@Test
	public void articleContentsSuccess() {
		assertEquals("Article contents.", article.getArticleContents());
	}
}
