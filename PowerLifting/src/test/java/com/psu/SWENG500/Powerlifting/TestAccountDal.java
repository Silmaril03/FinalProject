package com.psu.SWENG500.Powerlifting;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import com.psu.SWENG500.Powerlifting.dal.*;
import com.psu.SWENG500.Powerlifting.models.*;

public class TestAccountDal
{
	private Account testAccount;
	private static final String TEST_DB = "TestDb";
	
	@Before
	public void setUp() throws Exception
	{
		testAccount = new Account();
		testAccount.setFirstName("Test User");
		testAccount.setLastName("User");
		testAccount.setNickname("Test Nickname");
		testAccount.setEmailAddress("test@test.com");
		testAccount.setGender("Male");
		testAccount.setHeight(72);
		testAccount.setPhoneNumber("1234567890");
		testAccount.setMfpUsername("testMfpUserName");
		testAccount.setMfpPwd("testMfpPwd");
	}
	
	@Test
	public void TestCreateAccount()
	{
		IAccountDAO dao = AccountDaoFactory.GetAccountDAO(TEST_DB);
		Account a = null;
		try
		{
			a = dao.CreateAccount(testAccount);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		Assert.assertNotNull(a);
	}
	
	@Test
	public void TestGetAccount()
	{
		IAccountDAO dao = AccountDaoFactory.GetAccountDAO(TEST_DB);
		Account a = null;
		try
		{
			a = dao.GetAccount(38);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		Assert.assertNotNull(a);
	}
	
	@Test
	public void TestGetAccountNotFound()
	{
		IAccountDAO dao = AccountDaoFactory.GetAccountDAO(TEST_DB);
		Account a = null;
		try
		{
			a = dao.GetAccount(2000);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		Assert.assertNull(a);
	}
}