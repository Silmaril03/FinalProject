package com.psu.SWENG500.Powerlifting;

import junit.framework.TestCase;

import com.psu.SWENG500.Powerlifting.ejbs.Controller.CalculatorController;
import com.psu.SWENG500.Powerlifting.models.ImperialMeasurement;

/**
 * @author Jason
 * 
 *         JUnit to test the Calculator class that calculates the functions for
 *         Body Mass Index and Wilks Scores
 */
public class CalculatorControllerTest extends TestCase {
	private CalculatorController calc = new CalculatorController();
	private int PRECISION = 10;

	public CalculatorControllerTest(String testName) {
		super(testName);
	}

	public void testCalcWilksScore() {
		ImperialMeasurement person = new ImperialMeasurement();
		person.setWeight(new Double(150));

		ImperialMeasurement lifting = new ImperialMeasurement();
		lifting.setWeight(new Double(400));
		double total = calc.CalcWilksScore(person, lifting, true);

		total = Math.round(total);

		assertNotNull(total);

		assertEquals(139.0, total);
	}

	public void testBodyMass() {
		ImperialMeasurement person = new ImperialMeasurement();
		person.setHeight(new Double(72));
		person.setWeight(new Double(180));
		Double bmi = calc.CalcBodyMass(person);
		bmi = Math.floor(bmi * PRECISION + .5) / PRECISION;
		assertNotNull(bmi);
		assertEquals(24.4, bmi);

		person = new ImperialMeasurement();
		person.setHeight(new Double(72));
		bmi = calc.CalcBodyMass(person);
		assertNull(bmi);
	}
}
