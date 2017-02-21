package com.psu.SWENG500.Powerlifting;

import static org.junit.Assert.*;
import java.sql.*;

import org.junit.Assert;
import org.junit.Test;
import com.psu.SWENG500.Powerlifting.dal.*;

public class TestH2Connection
{
	@Test
	public void testGetConnection()
	{
		Connection conn = H2ConnectionFactory.GetConnection();
		Assert.assertNotNull(conn);
	}
	
	@Test
	public void testGetConnectionWithParam()
	{
		Connection conn = H2ConnectionFactory.GetConnection("TestDb");
		Assert.assertNotNull(conn);
	}
}