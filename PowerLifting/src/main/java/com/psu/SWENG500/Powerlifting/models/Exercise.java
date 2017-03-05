package com.psu.SWENG500.Powerlifting.models;

public class Exercise
{
	private String exerciseName;
	private boolean isPartOfTotal;
	
	public Exercise()
	{	
	}

	public String getExerciseName()
	{
		return exerciseName;
	}

	public void setExerciseName(String exerciseName)
	{
		this.exerciseName = exerciseName;
	}

	public Boolean getIsPartOfTotal()
	{
		return isPartOfTotal;
	}

	public void setIsPartOfTotal(Boolean isPartOfTotal)
	{
		this.isPartOfTotal = isPartOfTotal;
	} 
}