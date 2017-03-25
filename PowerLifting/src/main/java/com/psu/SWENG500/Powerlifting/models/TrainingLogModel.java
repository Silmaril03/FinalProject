package com.psu.SWENG500.Powerlifting.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TrainingLogModel
{
	private List<Workout> workouts;
	
	public TrainingLogModel()
	{
		workouts = new ArrayList<Workout>();
	}
	
	public TrainingLogModel(List<Workout> workouts)
	{
		this.workouts = workouts;
	}
	
	public Workout GetWorkout(Date workoutDate)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(workoutDate); 
		c.add(Calendar.DATE, 1);
		List<Workout> temp = retrieveWorkoutsBetweenDates(workoutDate, c.getTime());
		if (!temp.isEmpty())
			return temp.get(0);
		else
			return null;
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
		return workouts.stream()
				.filter(w -> (w.getWorkoutDate().after(startDate) || w.getWorkoutDate().compareTo(startDate) == 0) && w.getWorkoutDate().before(endDate))
				.collect(Collectors.toList());
	}
}