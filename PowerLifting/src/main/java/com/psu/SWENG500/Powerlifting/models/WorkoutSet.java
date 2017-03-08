package com.psu.SWENG500.Powerlifting.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

public class WorkoutSet
{
	private SimpleStringProperty setNumber = new SimpleStringProperty("");
	private SimpleDoubleProperty  weightLifted = new SimpleDoubleProperty();
	private SimpleIntegerProperty  repCount = new SimpleIntegerProperty();
	private boolean isNewPR;
	private SimpleStringProperty exercise = new SimpleStringProperty("");
//	private SimpleObjectProperty exercise = new SimpleObjectProperty();
	
	public WorkoutSet()
	{
	}

	public int getSetNumber()
	{
		return Integer.parseInt(this.setNumber.getValue());
	}

	public void setSetNumber(int setNumber)
	{
		this.setNumber.set(setNumber+"");;
	}

	public double getWeightLifted()
	{
		return this.weightLifted.getValue();
	}

	public void setWeightLifted(double weightLifted)
	{
		this.weightLifted.set(weightLifted);
	}

	public int getRepCount()
	{
		return this.repCount.getValue();
	}

	public void setRepCount(int repCount)
	{
		this.repCount.set(repCount);
	}

	public boolean getIsNewPR()
	{
		return this.isNewPR;
	}

	public void setIsNewPR(boolean isNewPR)
	{
		this.isNewPR = isNewPR;
	}

	public String getExercise()
	{
		return this.exercise.getValue();
	}

	public void setExercise(String exercise)
	{
		this.exercise.setValue(exercise);;
	}
}