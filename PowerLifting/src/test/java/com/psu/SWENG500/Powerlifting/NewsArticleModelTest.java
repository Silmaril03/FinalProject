package com.psu.SWENG500.Powerlifting;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.NewsArticle;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;

public class NewsArticleModelTest extends TestCase {
	
	private NewsArticleModel articleModel = new NewsArticleModel();

	public void testRetrieveArticlesFromListSuccess() {
		ConfigReader reader = ConfigReader.getInstance();
		reader.readSiteListFile("src/main/resources/SiteList.xml");
		List<String> siteUrls = reader.getSiteList();
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(siteUrls);
		assertNotNull(articleList);
	}
	
	public void testNullSiteUrls() {
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(null);
		assertNull(articleList);
	}
	
	public void testNoSiteUrls() {
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(new ArrayList<String>());
		assertNull(articleList);
	}
}