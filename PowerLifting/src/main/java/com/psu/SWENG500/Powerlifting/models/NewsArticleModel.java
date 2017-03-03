package com.psu.SWENG500.Powerlifting.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsArticleModel {
	
	public List<NewsArticle> retrieveArticlesFromSiteUrls(List<String> siteUrls) {
		if(siteUrls == null || siteUrls.isEmpty()) {
			System.out.println("No site URLs!");
			return null;
		}
		
		List<NewsArticle> articleList = new ArrayList<NewsArticle>();
		for(String siteName: siteUrls) {
			articleList.addAll(retrieveArticlesFromSite(siteName));
		}
		return articleList;
	}
	
	private List<NewsArticle> retrieveArticlesFromSite(String siteName) {
		List<String> articleUrls = new ArrayList<String>();
		List<NewsArticle> articleList = new ArrayList<NewsArticle>();
		try {
			Document doc = (Document) Jsoup.connect(siteName).timeout(3000).get();
			Elements content = doc.getElementsByTag(ElementTags.ARTICLE.value());
			
			for(int i =0; i < 5; i++) {
				Elements elementA = content.get(i).getElementsByTag(ElementTags.A.value());
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
				
				Elements body = content.getElementsByTag(ElementTags.P.value());
				StringBuilder bodyBuilder = new StringBuilder();
				for(Element element: body){
					String elementText = element.text();
					bodyBuilder.append(elementText);
					
					if(!elementText.endsWith(" ")) {
						bodyBuilder.append(" ");
					}
				}
				
				Element time = content.getElementsByTag(ElementTags.TIME.value()).first();
				String date = time.attr(ElementTags.DATETIME.value());
				///////////////
				NewsArticle theArticle = generateNewsArticleObject(articleUrl, title, bodyBuilder.toString().substring(0,60), bodyBuilder.toString(), date);
				System.out.println(theArticle.toString());
				/////////////////
				articleList.add(generateNewsArticleObject(articleUrl, title, bodyBuilder.toString().substring(0,60), bodyBuilder.toString(), date));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return articleList;
	}
	
	private NewsArticle generateNewsArticleObject(String siteUrl, String title, String shortDescription, String articleBody, String articleDate) {
		return new NewsArticle(title, siteUrl, articleDate, shortDescription, articleBody);
	}
}
