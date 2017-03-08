package com.psu.SWENG500.Powerlifting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.NewsArticle;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;

import junit.framework.TestCase;

public class NewsArticleModelTest extends TestCase {
	
	private NewsArticleModel articleModel = new NewsArticleModel();

	@Test
	public void testRetrieveArticlesFromListSuccess() {
		ConfigReader reader = ConfigReader.getInstance();
		reader.readSiteListFile("src/main/resources/SiteList.xml");
		List<String> siteUrls = reader.getSiteList();
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(siteUrls);
		assertNotNull(articleList);
	}
	
	@Test
	public void testNullSiteUrls() {
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(null);
		assertNull(articleList);
	}
	
	@Test
	public void testNoSiteUrls() {
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(new ArrayList<String>());
		assertNull(articleList);
	}
}