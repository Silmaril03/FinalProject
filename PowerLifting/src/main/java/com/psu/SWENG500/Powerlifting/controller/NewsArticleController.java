package com.psu.SWENG500.Powerlifting.controller;

import java.util.List;

import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;
import com.psu.SWENG500.Powerlifting.models.ui.NewsArticle;

public class NewsArticleController {
	
	private NewsArticleModel articleModel = new NewsArticleModel();
	
	public List<NewsArticle> retrieveNewsArticleList(){
		ConfigReader reader = ConfigReader.getInstance();
		reader.readSiteListFile("src/main/resources/SiteList.xml");
		List<String> siteUrls = reader.getSiteList();
		return articleModel.retrieveArticlesFromSiteUrls(siteUrls);
	}
}
