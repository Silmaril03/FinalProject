package com.psu.SWENG500.Powerlifting.dal;

import java.util.List;

import com.psu.SWENG500.Powerlifting.models.Account;
import java.sql.*;

public class AccountDAO implements IAccountDAO
{
	private String dbName;
	
	protected AccountDAO(String dbName)
	{
		this.dbName = dbName;
	}
	
	public List<Account> GetAccounts()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Account GetAccount(int id) throws SQLException
	{
		Account tempAccount = null;
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	String sql = "SELECT * FROM SWENG500.USERS WHERE ID=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, id);
        	ResultSet rs = prep.executeQuery();
        	if (rs.next())
            {
        		tempAccount = new Account();
        		tempAccount.setUserId(rs.getInt("ID"));
        		tempAccount.setFirstName(rs.getString("FIRSTNAME"));
        		tempAccount.setLastName(rs.getString("LASTNAME"));
        		tempAccount.setNickname(rs.getString("NICKNAME"));
        		tempAccount.setEmailAddress(rs.getString("EMAILADDRESS"));
        		tempAccount.setGender(rs.getString("GENDER"));
        		tempAccount.setHeight(rs.getDouble("HEIGHT"));
        		tempAccount.setPhoneNumber(rs.getString("PHONENUMBER"));
        		tempAccount.setMfpUsername(rs.getString("MFPUSERNAME"));
        		tempAccount.setMfpPwd(rs.getString("MFPPASSWORD"));
        		prep.close();
            }
            conn.commit();
        } catch (SQLException e)
        {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
        return tempAccount;
	}

	public Account CreateAccount(Account a) throws SQLException
	{
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	String sql = "INSERT INTO SWENG500.USERS (FIRSTNAME, LASTNAME, NICKNAME, EMAILADDRESS, GENDER, HEIGHT, PHONENUMBER, MFPUSERNAME, MFPPASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";// * FROM USERS WHERE PASSWORD=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, a.getFirstName());
        	prep.setString(2, a.getLastName());
        	prep.setString(3, a.getNickname());
        	prep.setString(4, a.getEmailAddress());
        	prep.setString(5, a.getGender());
        	prep.setDouble(6, a.getHeight());
        	prep.setString(7, a.getPhoneNumber());
        	prep.setString(8, a.getMfpUsername());
        	prep.setString(9, a.getMfpPwd());
        	prep.executeUpdate();
        	ResultSet newId = prep.getGeneratedKeys();
        	if (newId.next())
        		a.setUserId(newId.getInt(1));
        	prep.close();
            conn.commit();
        } catch (SQLException e)
        {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
        return a;
	}

	public Account UpdateAccount(Account a)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean DeleteAccount(Account a)
	{
		// TODO Auto-generated method stub
		return false;
	}
}