package com.psu.SWENG500.Powerlifting.dal;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2ConnectionFactory
{
	private static final String DB_DRIVER = "org.h2.Driver";
    private static String DB_CONNECTION;
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    
    public static Connection GetConnection()
    {
    	return H2ConnectionFactory.GetConnection("IplDb");
    	//DB_CONNECTION = "jdbc:h2:file:" + Paths.get("src/main/resources/IplDb").toAbsolutePath().toString();
    	//Connection h2Connection = null;
        //try
        //{
        //    Class.forName(DB_DRIVER);
        //} catch (ClassNotFoundException e)
        //{
        //    System.out.println(e.getMessage());
        //}
        //try 
        //{
        //	h2Connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        //    return h2Connection;
        //} catch (SQLException e) 
        //{
        //    System.out.println(e.getMessage());
        //}
        //return h2Connection;
    }
    
    public static Connection GetConnection(String dbName)
    {
    	DB_CONNECTION = "jdbc:h2:file:" + Paths.get("src/main/resources/" + dbName).toAbsolutePath();
    	Connection h2Connection = null;
        try
        {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try 
        {
        	h2Connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return h2Connection;
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return h2Connection;
    }
}