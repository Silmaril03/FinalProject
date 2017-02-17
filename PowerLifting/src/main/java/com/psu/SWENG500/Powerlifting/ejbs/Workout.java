package com.psu.SWENG500.Powerlifting.ejbs;

import java.util.Calendar;

public class Workout {
	
	int totalExercises;
	int totalVolume;
	Calendar calendar;
	
	public Workout() {
	}
	
	public Calendar getDate() {
		// get date
		return calendar;
	}
	
	public void addExercise(Exercise exercise) {
		// add exercise
	}
	
	public void deleteExercise(Exercise exercise) {
		// delete exercise
	}
	
	public void addCustomExercise(String exerciseName) {
		// add custom exercise
	}
	
	public void getTotalExercises() {
		// get total exercises
	}
	
	public void setTotalExercises() {
		// set total exercises
	}
}
