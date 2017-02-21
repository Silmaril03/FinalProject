package com.psu.SWENG500.Powerlifting;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.psu.SWENG500.Powerlifting.models.*;

public class TestAccount
{
	private Account tempAccount;
	
	@Test
	public void testName()
	{
		tempAccount = new Account();
		tempAccount.setName("John Smith");
		Assert.assertEquals("John Smith", tempAccount.getName());
	}
	
	@Test
	public void testNickname()
	{
		tempAccount = new Account();
		tempAccount.setNickname("John");
		Assert.assertEquals("John", tempAccount.getNickname());
	}
	
	@Test
	public void testEmailAddress()
	{
		tempAccount = new Account();
		tempAccount.setEmailAddress("John.Smith@aol.com");
		Assert.assertEquals("John.Smith@aol.com", tempAccount.getEmailAddress());
	}
	
	@Test
	public void testPhoneNumber()
	{
		tempAccount = new Account();
		tempAccount.setPhoneNumber("(123) 456-7890");
		Assert.assertEquals("(123) 456-7890", tempAccount.getPhoneNumber());
	}
	
	@Test
	public void testGender()
	{
		tempAccount = new Account();
		tempAccount.setGender("Male");
		Assert.assertEquals("Male", tempAccount.getGender());
	}
	
	@Test
	public void testMfpUsername()
	{
		tempAccount = new Account();
		tempAccount.setMfpUsername("JSmith");
		Assert.assertEquals("JSmith", tempAccount.getMfpUsername());
	}
	
	@Test
	public void testMfpPwd()
	{
		tempAccount = new Account();
		tempAccount.setMfpPwd("1234567890");
		Assert.assertEquals("1234567890", tempAccount.getMfpPwd());
	}
	
	@Test
	public void testUsername()
	{
		tempAccount = new Account();
		tempAccount.setUsername("JoSmith");
		Assert.assertEquals("JoSmith", tempAccount.getUsername());
	}
	
	@Test
	public void testPassword()
	{
		tempAccount = new Account();
		tempAccount.setPassword("1234567890");
		Assert.assertEquals("1234567890", tempAccount.getPassword());
	}
	
	@Test
	public void testHeight()
	{
		tempAccount = new Account();
		tempAccount.setHeight(65);
		Assert.assertEquals(65, tempAccount.getHeight(), 0);
	}
	
	@Test
	public void testCreateAccount()
	{
		tempAccount = new Account();
		tempAccount.CreateAccount("JSmith", "12345");
		Assert.assertEquals("JSmith", tempAccount.getUsername());
	}
	
	@Test
	public void testModifyAccount()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testLogin()
	{
		tempAccount = new Account();
		tempAccount.CreateAccount("JSmith", "12345");
		Assert.assertTrue(tempAccount.Login());
	}
	
	@Test
	public void testLogout()
	{
		tempAccount = new Account();
		tempAccount.CreateAccount("JSmith", "12345");
		Assert.assertTrue(tempAccount.Logout());
	}
}