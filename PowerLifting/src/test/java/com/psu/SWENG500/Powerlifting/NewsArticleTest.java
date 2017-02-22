package com.psu.SWENG500.Powerlifting;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.models.NewsArticle;

import junit.framework.TestCase;

public class NewsArticleTest extends TestCase {

	private NewsArticle article;
	private Date articleDate = new Date(1486174210416L);
	
	@Before
	public void setUp() throws Exception {
		article = new NewsArticle("Title", "muscles.com", articleDate, "Short description", "Article contents.");
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
		long actualMilliseconds = articleDate.getTime();
		assertEquals(actualMilliseconds, article.getArticleDate().getTime());
	}
	
	@Test
	public void testArticleShortDescriptionSuccess() {
		assertEquals("Short description", article.getArticleShortDescription());
	}
	
	@Test
	public void testArticleContentsSuccess() {
		assertEquals("Article contents.", article.getArticleContents());
	}
}
