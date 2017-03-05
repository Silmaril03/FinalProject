package com.psu.SWENG500.Powerlifting.models;

import java.util.*;

public class Workout
{
	private int workoutId;
	//private int totalExercises;
	//private int totalVolume;
	private String description;
	private Calendar calendar;
	private List<WorkoutSet> workoutSets;
	
	public Workout()
	{
		this.workoutSets = new ArrayList<WorkoutSet>();
	}
	
	public int getWorkoutId()
	{
		return this.workoutId;
	}
	
	public void setWorkoutId(int workoutId)
	{
		this.workoutId = workoutId;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Calendar getDate()
	{
		return this.calendar;
	}
	
	public void setDate(Calendar calendar)
	{
		this.calendar = calendar;
	}
	
	public void addSet(WorkoutSet set)
	{
		this.workoutSets.add(set);
	}
	
	public void deleteSet(WorkoutSet set)
	{
		this.workoutSets.remove(set);
	}
	
//	public void addExercise(Exercise exercise)
//	{
//		this.sets.add()
//		//this.exercises.add(exercise);
//	}
//	
//	public void deleteExercise(Exercise exercise)
//	{
//		//this.exercises.remove(exercise);
//	}
//	
//	public void addCustomExercise(String exerciseName)
//	{
//		// add custom exercise
//	}
	
	public int getTotalExercises()
	{
		//return this.exercises.size();
		return 0;
	}
	
	public double getTotalVolume()
	{
		// Calculate total volume from exercises
		return 0;
	}
	//public void setTotalExercises()
	//{
	//	// set total exercises
	//}
}