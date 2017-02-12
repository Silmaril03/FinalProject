package com.psu.SWENG500.Powerlifting.ejbs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
		URLConnection urlConn = null;
		InputStream inputStream = null;
		try {
			URL url = new URL(siteName);
			urlConn = url.openConnection();
			inputStream = urlConn.getInputStream();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(inputStream != null)
				{
					inputStream.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return articleList;
	}
	
	private void sortMostRecentArticles(List<NewsArticle> articleList)
	{
		//TODO
	}
}
