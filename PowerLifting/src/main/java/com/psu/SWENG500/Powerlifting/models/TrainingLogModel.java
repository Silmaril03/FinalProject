package com.psu.SWENG500.Powerlifting.models;

import com.psu.SWENG500.Powerlifting.ejbs.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainingLogModel
{
	private List<Workout> workouts;
	
	public TrainingLogModel()
	{
		workouts = new ArrayList<Workout>();
	}
	
	public List<Workout> GetWorkouts(Date workoutDate)
	{
		return retrieveWorkoutsBetweenDates(workoutDate, workoutDate);
	}
	
	public List<Workout> GetWorkouts(Date firstWorkoutDate, Date secondWorkoutDate)
	{
		return retrieveWorkoutsBetweenDates(firstWorkoutDate, secondWorkoutDate);
	}
	
	public void LogWorkout(Workout workoutSession, Date workoutSessionDate)
	{
		workouts.add(workoutSession);
		// TODO: Save to db.
	}
	
	private List<Workout> retrieveWorkoutsBetweenDates(Date startDate, Date endDate)
	{
		return null;
	}
}