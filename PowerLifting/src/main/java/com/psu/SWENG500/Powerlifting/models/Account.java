package com.psu.SWENG500.Powerlifting.models;

public class Account
{
	String name;
	String nickname;
	String emailAddress;
	String phoneNumber;
	String gender;
	String mfpUsername;
	String mfpPwd;
	String username;
	String password;
	double height;
	
	public Account()
	{
	}
	
	public Account CreateAccount(String username, String pwd)
	{
		return new Account();
	}
	
	public void ModifyAccount(String name, String nickname, String emailAddress, String phoneNumber, String gender, String mfpUsername, String mfpPwd, String username, String password, double height)
	{
		this.name = name;
		this.nickname = nickname;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.mfpUsername = mfpUsername;
		this.mfpPwd = mfpPwd;
		this.username = username;
		this.password = password;
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
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
	
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}
}