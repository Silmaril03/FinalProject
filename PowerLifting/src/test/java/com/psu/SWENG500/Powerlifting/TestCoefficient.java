package com.psu.SWENG500.Powerlifting;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.models.FemaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.MaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.Weight;

public class TestCoefficient extends TestCase {
	MaleCoefficient mCo = new MaleCoefficient();
	FemaleCoefficient fCo = new FemaleCoefficient();
	int precision = 10000;

	public void testMaleCoefficient() {
		Double coefficient = mCo.getCoefficient(150, Weight.POUNDS);
		coefficient = Math.floor(coefficient * precision +.5)/precision;
		System.out.println("Male Coefficient " + coefficient);
		assertEquals(.7661, coefficient);
	}

	public void testFemaleCoefficient() {
		Double coefficient = fCo.getCoefficient(150, Weight.POUNDS);
		coefficient = Math.floor(coefficient * precision +.5)/precision;
		System.out.println("Female Coefficient " + coefficient);
		assertEquals(1.0148, coefficient);
	}
}
