package com.psu.SWENG505.PowerLifting.ejbs;

import java.util.Date;

public class NewsArticle {
	private String articleTitle;
	
	private String siteOrigin;
	
	private Date articleDate;
	
	private String articleShortDescription;
	
	private String articleContents;
	
	public NewsArticle()
	{
		
	}
	
	public NewsArticle(String articleTitle, String siteOrigin, Date articleDate, String articleShortDescription, String articleContents)
	{
		this.articleTitle = articleTitle;
		this.siteOrigin = siteOrigin;
		this.articleDate = articleDate;
		this.articleShortDescription = articleShortDescription;
		this.articleContents = articleContents;
	}

	public String getArticleTitle() {
//		return articleTitle;
		return null;
	}

	public void setArticleTitle(String articleTitle) {
//		this.articleTitle = articleTitle;
	}

	public String getSiteOrigin() {
//		return siteOrigin;
		return null;
	}

	public void setSiteOrigin(String siteOrigin) {
//		this.siteOrigin = siteOrigin;
	}

	public Date getArticleDate() {
//		return articleDate;
		return null;
	}

	public void setArticleDate(Date articleDate) {
//		this.articleDate = articleDate;
	}

	public String getArticleShortDescription() {
//		return articleShortDescription;
		return null;
	}

	public void setArticleShortDescription(String articleShortDescription) {
//		this.articleShortDescription = articleShortDescription;
	}

	public String getArticleContents() {
//		return articleContents;
		return null;
	}

	public void setArticleContents(String articleContents) {
//		this.articleContents = articleContents;
	}
}
