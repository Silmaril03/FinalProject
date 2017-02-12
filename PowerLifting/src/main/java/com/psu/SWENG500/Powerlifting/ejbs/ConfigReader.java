package com.psu.SWENG500.Powerlifting.ejbs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigReader {
	private static ConfigReader reader;
	private List<String> siteList;
	private static final String SITE_LIST_TAG = "";
	private static final String SITE_TAG = "";
	
	private ConfigReader()
	{
	}
	
	public static synchronized ConfigReader getInstance()
	{
		if(reader == null)
		{
			reader = new ConfigReader();
		}
		return reader;
	}
	
	public synchronized void readSiteListFile(String siteFile)
	{
		File file = new File(siteFile);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(file); 
			document.getDocumentElement().normalize();
			NodeList nodeList = document.getElementsByTagName(SITE_LIST_TAG);
			siteList = new ArrayList<String>();
			
			for(int i=0; i<nodeList.getLength();i++)
			{
				Node node = nodeList.item(i);
				Element element = (Element) node;
				siteList.add(element.getElementsByTagName(SITE_TAG).item(0).getTextContent());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getSiteList()
	{
		return siteList;
	}
}
