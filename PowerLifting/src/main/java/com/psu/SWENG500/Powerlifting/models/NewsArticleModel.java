package com.psu.SWENG500.Powerlifting.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

import com.psu.SWENG500.Powerlifting.ejbs.ConfigReader;
import com.psu.SWENG500.Powerlifting.ejbs.NewsArticle;

public class NewsArticleModel {
	private final List<NewsArticle> articleList = null;
	
	public List<NewsArticle> retrieveArticlesFromList(List<String> siteNames)
	{
		ConfigReader reader = ConfigReader.getInstance();
		List<String> siteUrls = reader.getSiteList();
		
		if(siteUrls == null)
		{
			System.out.println("No site URLs!!!!!!!!!!!!!!!!");
			return null;
		}
		
		List<NewsArticle> articleList = new ArrayList<NewsArticle>();
		
		for(String siteName: siteUrls)
		{
			articleList.addAll(retrieveArticle(siteName));
		}
		
		sortMostRecentArticles(articleList);
		return articleList;
	}
	
	private List<NewsArticle> retrieveArticle(String siteName)
	{
		try {
			Document doc = (Document) Jsoup.connect(siteName).timeout(3000).get();
			String htmlPageContent = doc.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return articleList;
	}
	
	private void sortMostRecentArticles(List<NewsArticle> articleList)
	{
		//TODO
	}
}
