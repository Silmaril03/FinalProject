package com.psu.SWENG500.Powerlifting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.ejbs.NewsArticle;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;

import junit.framework.TestCase;

public class NewsArticleModelTest extends TestCase {
	
	private NewsArticleModel articleModel;
	private List<String> siteNames;
	
	@Before
	public void setUp() throws Exception {
		articleModel = new NewsArticleModel();
		siteNames = new ArrayList<String>();
		
		siteNames.add("muscles.com");
		siteNames.add("bigmuscles.com");
		siteNames.add("smallmuscles.com");
	}

	@Test
	public void retrieveArticlesFromListSuccess() {
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromList(siteNames);
		assertNotNull(articleList);
		assertEquals(5, articleList.size());
	}
	
	@Test
	public void retrieveArticlesFromListNull() {
		List<NewsArticle> articleList = articleModel.retrieveArticlesFromList(new ArrayList<String>());
		assertNull(articleList);
	}

}

