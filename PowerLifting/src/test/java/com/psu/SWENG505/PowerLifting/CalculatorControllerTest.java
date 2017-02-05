package com.psu.SWENG505.PowerLifting;

import com.psu.SWENG505.PowerLifting.ejbs.CalculatorController;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculatorControllerTest extends TestCase{
	CalculatorController calc;
	
	public CalculatorControllerTest(String testName){
		super(testName);
		CalculatorController calc = new CalculatorController();
	}
	
	public void testCalculator(){
		//instantiate Controller Class
		assertNotNull(calc.Calculate());
	}
	
	public void testCalcWilksScore(){
		assertNotNull(calc.CalcWilksScore(0, 0));
	}
	
	public void testBodyMass(){
		assertNotNull(calc.CalcBodyMass());
	}
}
