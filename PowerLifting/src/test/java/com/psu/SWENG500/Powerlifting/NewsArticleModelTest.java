package com.psu.SWENG500.Powerlifting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.NewsArticle;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;

import junit.framework.TestCase;

public class NewsArticleModelTest extends TestCase {
	
	private NewsArticleModel articleModel = new NewsArticleModel();
//	private List<String> siteNames;
	
//	@Before
//	public void setUp() throws Exception {
//		articleModel = new NewsArticleModel();
//		siteNames = new ArrayList<String>();
//		
//		siteNames.add("muscles.com");
//		siteNames.add("bigmuscles.com");
//		siteNames.add("smallmuscles.com");
//	}

	@Test
	public void testRetrieveArticlesFromListSuccess() {
		ConfigReader reader = ConfigReader.getInstance();
		reader.readSiteListFile("src/main/resources/SiteList.xml");
		List<String> siteUrls = reader.getSiteList();
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromSiteUrls(siteUrls);
		assertNotNull(articleList);
		assertEquals(5, articleList.size());
	}
	
//	@Test
//	public void retrieveArticlesFromListNull() {
//		List<NewsArticle> articleList = articleModel.retrieveArticlesFromList(new ArrayList<String>());
//		assertNull(articleList);
//	}

}

