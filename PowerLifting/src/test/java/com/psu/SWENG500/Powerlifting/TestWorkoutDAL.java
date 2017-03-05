package com.psu.SWENG500.Powerlifting;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.dal.*;
import com.psu.SWENG500.Powerlifting.models.*;

public class TestWorkoutDAL
{
	private Workout testWorkout;
	private static final String TEST_DB = "TestDb";
	
	@Before
	public void setUp() throws Exception
	{
		testWorkout = new Workout();
		testWorkout.setDescription("This is my first workout!");
		testWorkout.setDate(Calendar.getInstance());
	}
	
//	@Test
//	public void TestCreateWorkout()
//	{
//		IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
//		Workout w = null;
//		try
//		{
//			w = dao.CreateWorkout(testWorkout, 38);
//		} catch (SQLException e)
//		{
//			fail(e.getLocalizedMessage());
//		}
//		Assert.assertNotNull(w);
//	}
	
	@Test
	public void TestGetWorkout()
	{
		IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
		Workout w = null;
		try
		{
			w = dao.GetWorkout(1);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		Assert.assertNotNull(w);
	}
	
	@Test
	public void TestGetWorkoutNotFound()
	{
		IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
		Workout w = null;
		try
		{
			w = dao.GetWorkout(20);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		Assert.assertNull(w);
	}
	
	@Test
	public void TestGetWorkoutsForUser()
	{
		IWorkoutDAO dao = WorkoutDaoFactory.GetWorkoutDAO(TEST_DB);
		List<Workout> workouts = new ArrayList<Workout>();
		try
		{
			workouts = dao.GetWorkouts(38);
		} catch (SQLException e)
		{
			fail(e.getLocalizedMessage());
		}
		Assert.assertEquals(2, workouts.size());
	}
	
	//@Test
	//public void test() {
	//	fail("Not yet implemented");
	//}
}