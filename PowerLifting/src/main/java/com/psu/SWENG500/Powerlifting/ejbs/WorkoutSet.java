package com.psu.SWENG500.Powerlifting.ejbs;

public class WorkoutSet
{
	int setNumber;
	double weightLifted;
	int repCount;
	boolean isNewPR;
	Exercise exercise;
	
	public WorkoutSet()
	{
		
	}

	public int getSetNumber()
	{
		return setNumber;
	}

	public void setSetNumber(int setNumber)
	{
		this.setNumber = setNumber;
	}

	public double getWeightLifted()
	{
		return weightLifted;
	}

	public void setWeightLifted(double weightLifted)
	{
		this.weightLifted = weightLifted;
	}

	public int getRepCount()
	{
		return repCount;
	}

	public void setRepCount(int repCount)
	{
		this.repCount = repCount;
	}

	public boolean getIsNewPR()
	{
		return isNewPR;
	}

	public void setIsNewPR(boolean isNewPR)
	{
		this.isNewPR = isNewPR;
	}

	public Exercise getExercise()
	{
		return exercise;
	}

	public void setExercise(Exercise exercise)
	{
		this.exercise = exercise;
	}
}