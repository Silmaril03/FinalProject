package com.psu.SWENG500.Powerlifting.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import com.psu.SWENG500.Powerlifting.models.Workout;

public class WorkoutDAO implements IWorkoutDAO
{
	private String dbName;
	protected WorkoutDAO(String dbName)
	{
		this.dbName = dbName;
	}
	
	public List<Workout> GetWorkouts(int userId) throws SQLException
	{
		List<Workout> workouts = null;
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
		try
		{
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM SWENG500.WORKOUTS WHERE USERID=? ORDER BY WORKOUTDATE ASC";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, userId);
			ResultSet rs = prep.executeQuery();
			workouts = new ArrayList<Workout>();
			while (rs.next())
			{
				Workout tempWorkout = new Workout();
				tempWorkout.setWorkoutId(rs.getInt("ID"));
				tempWorkout.setDescription(rs.getString("DESCRIPTION"));
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTimeInMillis(rs.getTimestamp("WORKOUTDATE").getTime());
				tempWorkout.setDate(tempCal);
				workouts.add(tempWorkout);
			}
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
        return workouts;
	}
	
	public Workout GetWorkout(int id) throws SQLException
	{
		Workout tempWorkout = null;
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
		try
		{
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM SWENG500.WORKOUTS WHERE ID=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			if (rs.next())
			{	
				tempWorkout = new Workout();
				tempWorkout.setWorkoutId(rs.getInt("ID"));
				tempWorkout.setDescription(rs.getString("DESCRIPTION"));
				Calendar tempCal = Calendar.getInstance();
				tempCal.setTimeInMillis(rs.getTimestamp("WORKOUTDATE").getTime());
				tempWorkout.setDate(tempCal);
			}
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
        return tempWorkout;
	}
	
	public Workout CreateWorkout(Workout w, int userId) throws SQLException
	{
		Connection conn = H2ConnectionFactory.GetConnection(this.dbName);
        try
        {
        	Timestamp t = new Timestamp(w.getDate().getTimeInMillis());
        	conn.setAutoCommit(false);
        	String sql = "INSERT INTO SWENG500.WORKOUTS (USERID, DESCRIPTION, WORKOUTDATE) VALUES (?, ?, ?)";// * FROM USERS WHERE PASSWORD=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, userId);
        	prep.setString(2, w.getDescription());
        	prep.setTimestamp(3, new Timestamp(w.getDate().getTimeInMillis()));
        	prep.executeUpdate();
        	ResultSet newId = prep.getGeneratedKeys();
        	if (newId.next())
        		w.setWorkoutId(newId.getInt(1));
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
        return w;
	}

	public Workout UpdateWorkout(Workout w) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean DeleteWorkout(Workout w) {
		// TODO Auto-generated method stub
		return false;
	}

}