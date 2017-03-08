package com.psu.SWENG500.Powerlifting;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.models.*;

public class TestTrainingLogModel
{
	private TrainingLogModel trainingLog;
	
	@Before
	public void setUp() throws Exception
	{
		trainingLog = new TrainingLogModel();
		Workout t1 = new Workout();
		//t1.addExercise(null);
		Workout t2 = new Workout();
		//t2.addExercise(null);
		Workout t3 = new Workout();
		//t3.addExercise(null);
	}
	
	@Test
	public void testGetWorkoutOnSpecificDate() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Workout> workouts = trainingLog.GetWorkouts(sdf.parse("2/18/2017"));
		Assert.assertNotNull(workouts);
	}
	
	@Test
	public void testGetWorkoutBetweenDates() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Workout> workouts = trainingLog.GetWorkouts(sdf.parse("2/17/2017"), sdf.parse("2/18/2017"));
		Assert.assertNotNull(workouts);
	}
}