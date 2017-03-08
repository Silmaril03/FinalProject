package com.psu.SWENG500.Powerlifting.dal;

import java.sql.SQLException;
import java.util.List;

import com.psu.SWENG500.Powerlifting.models.*;

public interface IAccountDAO
{
	List<Account> GetAccounts();
	Account GetAccount(int id) throws SQLException;
	Account CreateAccount(Account a) throws SQLException;
	Account UpdateAccount(Account a);
	boolean DeleteAccount(Account a);
}