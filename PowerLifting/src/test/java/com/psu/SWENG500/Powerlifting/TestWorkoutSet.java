package com.psu.SWENG500.Powerlifting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

public class TestWorkoutSet
{
	private WorkoutSet workoutSession;

	@Test
	public void testSetNumber()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setSetNumber(0);
		Assert.assertEquals(0, workoutSession.getSetNumber());
	}
	
	@Test
	public void testWeightLifted()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setWeightLifted(100);
		Assert.assertEquals(100, workoutSession.getWeightLifted(), 0);
	}
	
	@Test
	public void testRepCount()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setRepCount(1);
		Assert.assertEquals(1, workoutSession.getRepCount());
	}
	
	@Test
	public void testIsNewPR()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setIsNewPR(true);
		Assert.assertEquals(true, workoutSession.getIsNewPR());
	}
	
	@Test
	public void testNullExercise()
	{
		workoutSession = new WorkoutSet();
		workoutSession.setExercise(new Exercise());
		Assert.assertNotNull(workoutSession.getExercise());
	}
}