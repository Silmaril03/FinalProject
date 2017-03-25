package com.psu.SWENG500.Powerlifting;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.models.*;

public class TestTrainingLogModel extends TestCase
{
	private TrainingLogModel trainingLog;
	
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
	
	public void testGetWorkoutOnSpecificDate() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Workout workout = trainingLog.GetWorkout(sdf.parse("2/18/2017"));
		assertNull(workout);
	}
	
	public void testGetWorkoutBetweenDates() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Workout> workouts = trainingLog.GetWorkouts(sdf.parse("2/17/2017"), sdf.parse("2/18/2017"));
		assertNull(workouts);
	}
}