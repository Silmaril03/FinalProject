package com.psu.SWENG500.Powerlifting.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.psu.SWENG500.Powerlifting.ejbs.NewsArticle;

public class NewsArticleModel {
	
	public List<NewsArticle> retrieveArticlesFromSiteUrls(List<String> siteNames) {
		if(siteNames == null) {
			System.out.println("No site URLs!");
			return null;
		}
		
		List<NewsArticle> articleList = new ArrayList<NewsArticle>();
		for(String siteName: siteNames) {
			articleList.addAll(retrieveArticlesFromSite(siteName));
		}
		sortMostRecentArticles(articleList);
		return articleList;
	}
	
	private List<NewsArticle> retrieveArticlesFromSite(String siteName) {
		List<String> articleUrls = new ArrayList<String>();
		List<NewsArticle> articleList = new ArrayList<NewsArticle>();
		try {
			Document doc = (Document) Jsoup.connect(siteName).timeout(3000).get();
			Elements content = doc.getElementsByTag(ElementTags.ARTICLE.value());
			
			for(Element aticleLink: content) {
				Elements elementA = aticleLink.getElementsByTag(ElementTags.A.value());
				articleUrls.add(elementA.attr(ElementTags.HREF.value()));
			}
			
			articleList = extractContentFromArticleUrl(articleUrls);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return articleList;
	}
	
	private List<NewsArticle> extractContentFromArticleUrl(List<String> articleUrlList) {
		List<NewsArticle> articleList = new ArrayList<NewsArticle>();
		for(String articleUrl: articleUrlList) {
			try {
				Document doc = (Document) Jsoup.connect(articleUrl).timeout(3000).get();
				Element content = doc.getElementsByTag(ElementTags.ARTICLE.value()).first();
				
				Element header = content.getElementsByTag(ElementTags.H1.value()).first();
				String title = header.text();
				
				Element time = content.getElementsByTag(ElementTags.TIME.value()).first();
				String date = time.attr(ElementTags.DATETIME.value());
				
				articleList.add(generateNewsArticleObject(articleUrl, title, "", "", new Date(1487449942430L)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return articleList;
	}
	
	private void sortMostRecentArticles(List<NewsArticle> articleList)
	{
		//TODO
	}
	
	private NewsArticle generateNewsArticleObject(String siteUrl, String title, String shortDescription, String articleBody, Date articleDate) {
		return new NewsArticle(title, siteUrl, articleDate, shortDescription, articleBody);
	}
}
