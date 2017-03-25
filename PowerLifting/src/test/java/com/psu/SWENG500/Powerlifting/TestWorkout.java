package com.psu.SWENG500.Powerlifting;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.controller.TrainingLogController;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

public class TestWorkout
{
	private Workout tempWorkout;
	private Date tempStartDate;
	private Date tempEndDate;
	
	@Before
	public void setUp()
	{
		tempStartDate = Calendar.getInstance().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(tempStartDate); 
		c.add(Calendar.DATE, 1);
		tempEndDate = c.getTime();
		
		tempWorkout = new Workout();
		tempWorkout.setDescription("This is my first workout!");
		tempWorkout.setWorkoutDate(tempStartDate);
		
		WorkoutSet set1 = new WorkoutSet();
		set1.setExercise("Exercise 1");
		set1.setRepCount(5);
		set1.setWeightLifted(50);
		
		WorkoutSet set2 = new WorkoutSet();
		set2.setExercise("Bench Press, Barbell");
		set2.setRepCount(5);
		set2.setWeightLifted(50);
		
		tempWorkout.addSet(set1);
		tempWorkout.addSet(set2);
	}
	
	@Test
	public void testGetTotalVolume()
	{
		assertEquals(500.0, tempWorkout.getTotalVolume(), 0);
	}
	
	@Test
	public void testGetTotalVolumeByExercise()
	{
		assertEquals(250.0, tempWorkout.getTotalVolumeByExercise("Exercise 1"), 0);
	}
}
