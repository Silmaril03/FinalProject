package com.psu.SWENG500.Powerlifting.controller;

import java.util.Calendar;
import java.util.Date;

import com.psu.SWENG500.Powerlifting.dal.WorkoutDaoFactory;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

public class TrainingLogController {
	
	private Workout workout;
	
	public TrainingLogController(){
		workout = new Workout();
	}
	
	public TrainingLogController(Date workoutDate){
		workout = new Workout(workoutDate);
	}
	
	public Workout getWorkout() {
		return workout;
	}
	
	public void addWorkoutSet(WorkoutSet set){
		workout.addSet(set);
	}
	
	public int getSet(){
		return workout.getNumberSets();
	}
	
	public Boolean setGoal() {
		return false;
	}
}
