package com.psu.SWENG505.PowerLifting;

import java.util.Calendar;

import com.psu.SWENG505.PowerLifting.ejbs.TrainingLogController;
import com.psu.SWENG505.PowerLifting.ejbs.Workout;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TrainingLogControllerTest extends TestCase {
	TrainingLogController trainingLog;
	Workout workout;
	Calendar calendar;
	
	public TrainingLogControllerTest(String testName) {
		super(testName);
		TrainingLogController trainingLog = new TrainingLogController();
	}
	
	public void testGetWorkout() {
		assertNotNull(trainingLog.getWorkout(workout));
	}
	
	public void testSetWorkout() {
		assertTrue(trainingLog.setWorkout(calendar));
	}
	
	public void testSetGoal() {
		assertTrue(trainingLog.setGoal());
	}

}
