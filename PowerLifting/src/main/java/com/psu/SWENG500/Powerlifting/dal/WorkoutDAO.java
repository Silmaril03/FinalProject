package com.psu.SWENG500.Powerlifting.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

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
				tempWorkout.setWorkoutDate(tempCal.getTime());
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
				tempWorkout.setWorkoutDate(tempCal.getTime());
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
		ResultSet newId;
        try
        {
        	//Timestamp t = new Timestamp(w.getWorkoutDate().getTime());
        	conn.setAutoCommit(false);
        	String sql = "INSERT INTO SWENG500.WORKOUTS (USERID, DESCRIPTION, WORKOUTDATE) VALUES (?, ?, ?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, userId);
        	prep.setString(2, w.getDescription());
        	prep.setTimestamp(3, new Timestamp(w.getWorkoutDate().getTime()));
        	prep.executeUpdate();
        	newId = prep.getGeneratedKeys();
        	if (newId.next())
        		w.setWorkoutId(newId.getInt(1));
        	prep.close();
            conn.commit();
            //List<WorkoutSet> sets = new ArrayList<WorkoutSet>();
            for (WorkoutSet ws : w.GetWorkoutSets())
            {
            	//IWorkoutSetDAO wsDao = WorkoutSetDaoFactory.GetWorkoutSetDAO(this.dbName);
            	try
        		{
            		sql = "INSERT INTO SWENG500.WORKOUTSETS (WORKOUTID, SETNUMBER, REPCOUNT, WEIGHTLIFTED, EXERCISENAME, PARTOFTOTAL) VALUES (?, ?, ?, ?, ?, ?)";
            		PreparedStatement prep2 = conn.prepareStatement(sql);
            		prep2 = conn.prepareStatement(sql);
            		prep2.setInt(1, w.getWorkoutId());
            		prep2.setInt(2, ws.getSetNumber());
            		prep2.setInt(3, ws.getRepCount());
            		prep2.setDouble(4, ws.getWeightLifted());
            		prep2.setString(5, ws.getExerciseName());
            		prep2.setBoolean(6, ws.isPartOfTotal());
            		prep2.executeUpdate();
                	ResultSet newWsId = prep2.getGeneratedKeys();
                	if (newWsId.next())
                		ws.setWorkoutSetId(newWsId.getInt(1));
                	prep2.close();
                	conn.commit();
        			//sets.add(wsDao.CreateWorkoutSet(ws, newId.getInt(1)));
        		} catch (SQLException e)
        		{
        			e.printStackTrace();
        		}
            }
            //w.SetWorkoutSets(sets);
            
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