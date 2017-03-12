package com.psu.SWENG500.Powerlifting.models;

import java.util.*;

public class Workout
{
	private int workoutId;
	//private int totalExercises;
	//private int totalVolume;
	private String description;
	private Date workoutDate;
	private List<WorkoutSet> workoutSets;
	
	public Workout()
	{
		this.workoutSets = new ArrayList<WorkoutSet>();
	}
	
	
	public Workout(Date workoutDate)
	{	
		this.workoutSets = new ArrayList<WorkoutSet>();
		this.setWorkoutDate(workoutDate);
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
	
	public Date getWorkoutDate()
	{
		return this.workoutDate;
	}
	
	public void setWorkoutDate(Date workoutDate)
	{
		this.workoutDate = workoutDate;
	}
	
	public void addSet(WorkoutSet set)
	{
		this.workoutSets.add(set);
	}
	
	public void deleteSet(WorkoutSet set)
	{
		this.workoutSets.remove(set);
	}
	
	public int getNumberSets()
	{
		return workoutSets.size();
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
	
	public List<WorkoutSet> GetWorkoutSets()
	{
		return this.workoutSets;
	}
	
	public void SetWorkoutSets(List<WorkoutSet> workoutSets)
	{
		this.workoutSets = workoutSets;
		
	}
}