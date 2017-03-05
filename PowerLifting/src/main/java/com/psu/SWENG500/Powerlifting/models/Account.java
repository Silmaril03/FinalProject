package com.psu.SWENG500.Powerlifting.models;

public class Account
{
	private int userId;
	private String firstName;
	private String lastName;
	private String nickname;
	private String emailAddress;
	private String phoneNumber;
	private String gender;
	private String mfpUsername;
	private String mfpPwd;
	//private String username;
	//private String password;
	private double height;
	
	public Account()
	{
	}
	
	public Account CreateAccount(String username, String pwd)
	{
		return new Account();
	}
	
	//public void ModifyAccount(String firstName, String nickname, String emailAddress, String phoneNumber, String gender, String mfpUsername, String mfpPwd, String username, String password, double height)
	public void ModifyAccount(String firstName, String nickname, String emailAddress, String phoneNumber, String gender, String mfpUsername, String mfpPwd, double height)
	{
		this.firstName = firstName;
		this.nickname = nickname;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.mfpUsername = mfpUsername;
		this.mfpPwd = mfpPwd;
		//this.username = username;
		//this.password = password;
		this.height = height;
	}
	
	public boolean Login()
	{
		return false;
	}
	
	public boolean Logout()
	{
		return false;
	}
	
	public int getUserId()
	{
		return this.userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getMfpUsername()
	{
		return mfpUsername;
	}

	public void setMfpUsername(String mfpUsername)
	{
		this.mfpUsername = mfpUsername;
	}

	public String getMfpPwd()
	{
		return mfpPwd;
	}

	public void setMfpPwd(String mfpPwd)
	{
		this.mfpPwd = mfpPwd;
	}
	
	//public String getUsername()
	//{
	//	return username;
	//}

	//public void setUsername(String username)
	//{
	//	this.username = username;
	//}

	//public String getPassword()
	//{
	//	return password;
	//}

	//public void setPassword(String password)
	//{
	//	this.password = password;
	//}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}
}