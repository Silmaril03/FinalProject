package com.psu.SWENG500.Powerlifting.models;

public class NewsArticle {
	private String articleTitle;
	
	private String siteOrigin;
	
	private String articleDate;
	
	private String articleShortDescription;
	
	private String bodyContents;
	
	public NewsArticle(String articleTitle, String siteOrigin, String articleDate, String articleShortDescription, String bodyContents)
	{
		this.articleTitle = articleTitle;
		this.siteOrigin = siteOrigin;
		this.articleDate = articleDate;
		this.articleShortDescription = articleShortDescription;
		this.bodyContents = bodyContents;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getSiteOrigin() {
		return siteOrigin;
	}

	public void setSiteOrigin(String siteOrigin) {
		this.siteOrigin = siteOrigin;
	}

	public String getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}

	public String getArticleShortDescription() {
		return articleShortDescription;
	}

	public void setArticleShortDescription(String articleShortDescription) {
		this.articleShortDescription = articleShortDescription;
	}

	public String getBodyContents() {
		return bodyContents;
	}

	public void setBodyContents(String bodyContents) {
		this.bodyContents = bodyContents;
	}
	
	public String toString() {
		return "SiteUrl: " + siteOrigin + "\nTitle: " + articleTitle + 
				"\nShort Description: " + articleShortDescription + 
				"\nBody: " + bodyContents + "\nDate: " + articleDate;
	}
}
