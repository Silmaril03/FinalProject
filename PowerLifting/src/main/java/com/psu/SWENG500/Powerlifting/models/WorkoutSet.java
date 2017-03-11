package com.psu.SWENG500.Powerlifting.models;

public class WorkoutSet
{
	private int setNumber;
	private double weightLifted;
	private int repCount;
	private boolean isNewPR;
	private Exercise exercise;
	
	public WorkoutSet()
	{
	}

	public int getSetNumber()
	{
		return this.setNumber;
	}

	public void setSetNumber(int setNumber)
	{
		this.setNumber = setNumber;
	}

	public double getWeightLifted()
	{
		return this.weightLifted;
	}

	public void setWeightLifted(double weightLifted)
	{
		this.weightLifted = weightLifted;
	}

	public int getRepCount()
	{
		return this.repCount;
	}

	public void setRepCount(int repCount)
	{
		this.repCount = repCount;
	}

	public boolean getIsNewPR()
	{
		return this.isNewPR;
	}

	public void setIsNewPR(boolean isNewPR)
	{
		this.isNewPR = isNewPR;
	}

	public Exercise getExercise()
	{
		return this.exercise;
	}

	public void setExercise(Exercise exercise)
	{
		this.exercise = exercise;
	}
}