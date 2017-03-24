package com.psu.SWENG500.Powerlifting.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.psu.SWENG500.Powerlifting.models.Measurements;

public class MeasurementsDAO implements IMeasurementsDAO
{
private String dbName;
	
	protected MeasurementsDAO(String dbName)
	{
		this.dbName = dbName;
	}
	
	public List<Measurements> GetMeasurements()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Measurements GetMeasurement(int id) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void CreateMeasurement(Measurements m) throws SQLException
	{
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	conn.setAutoCommit(false);
        	String sql = "INSERT INTO SWENG500.USERMEASUREMENTS (USERID, MEASUREMENTDATE, HEIGHT, WEIGHT, WAIST, NECK, HIP, WRIST, FOREARM) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, m.getUserId());
        	prep.setDate(2, (Date) m.getMeasurementDate());
        	prep.setDouble(3, m.getHeight());
        	prep.setDouble(4, m.getWeight());
        	prep.setDouble(5, m.getWaist());
        	prep.setDouble(6, m.getNeck());
        	prep.setDouble(7, m.getHip());
        	prep.setDouble(8, m.getWrist());
        	prep.setDouble(9, m.getForearm());
        	prep.executeUpdate();
        	ResultSet newId = prep.getGeneratedKeys();
        	prep.close();
            conn.commit();
        } catch (SQLException e)
        {
        	throw e;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
	}

	public void UpdateMeasurement(Measurements m) throws SQLException
	{
		// TODO Auto-generated method stub
		
	}

	public boolean DeleteMeasurement(Measurements m)
	{
		// TODO Auto-generated method stub
		return false;
	}
}