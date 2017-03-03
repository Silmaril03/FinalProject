package com.psu.SWENG500.Powerlifting;

import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.models.NewsArticle;

import junit.framework.TestCase;

public class NewsArticleTest extends TestCase {

	private NewsArticle article;
	private String date = "Feb 28 2017";
	
	@Before
	public void setUp() throws Exception {
		article = new NewsArticle("Title", "muscles.com", date, "Short description", "Article contents.");
	}

	@Test
	public void testArticleTitleSuccess() {
		assertEquals("Title", article.getArticleTitle());
	}

	@Test
	public void testSiteOriginSuccess() {
		assertEquals("muscles.com", article.getSiteOrigin());
	}
	
	@Test
	public void testArticleDateSuccess() {
		assertEquals(date, article.getArticleDate());
	}
	
	@Test
	public void testArticleShortDescriptionSuccess() {
		assertEquals("Short description", article.getArticleShortDescription());
	}
	
	@Test
	public void testArticleContentsSuccess() {
		assertEquals("Article contents.", article.getBodyContents());
	}
}
