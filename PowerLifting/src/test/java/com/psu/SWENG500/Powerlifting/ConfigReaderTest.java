package com.psu.SWENG500.Powerlifting;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.models.ConfigReader;

import junit.framework.TestCase;

public class ConfigReaderTest extends TestCase {
	
	private ConfigReader reader;

	@Before
	public void setUp() throws Exception {
		reader = ConfigReader.getInstance();
	}

	@Test
	public void testNullConfigFilename() {
		reader.readSiteListFile(null);
		List<String> nullList = reader.getSiteList();
		assertNull(nullList);
	}
	
	@Test
	public void testNonexistentConfigFilename() {
		reader.readSiteListFile("fake.properties");
		List<String> nullList = reader.getSiteList();
		assertNull(nullList);
	}

	@Test
	public void testReaderFileSuccess() {
		reader.readSiteListFile("src/main/resources/SiteList.xml");
		List<String> siteNameList = reader.getSiteList();
		assertEquals(3, siteNameList.size());
	}
}
