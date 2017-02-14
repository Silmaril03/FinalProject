package com.psu.SWENG505.PowerLifting;

import com.psu.SWENG505.PowerLifting.models.MaleCoefficient;
import com.psu.SWENG505.PowerLifting.models.Weight;

import junit.framework.TestCase;

public class TestCoefficient extends TestCase{
	MaleCoefficient mCo = new MaleCoefficient();
	
	public void testCoefficient(){
		Double coefficient = mCo.getCoefficient(150, Weight.POUNDS);
		
		System.out.println("Coefficient " + coefficient);
		assertEquals(.7661, coefficient);
	}
}
