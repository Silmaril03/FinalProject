package com.psu.SWENG500.Powerlifting.ejbs.Controller;

import com.psu.SWENG500.Powerlifting.models.FemaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.MaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.MeasurementType;
import com.psu.SWENG500.Powerlifting.models.Measurements;
import com.psu.SWENG500.Powerlifting.models.converters.MeasurementConverter;

/**
 * @author Jason
 *
 *         Controller class for the Calculator that makes the calculation for
 *         Body Mass Index and Wilks Score
 */
public class CalculatorController {

	MaleCoefficient mCo = new MaleCoefficient();
	FemaleCoefficient fCo = new FemaleCoefficient();

	public Double CalcWilksScore(Measurements person, Measurements lifting,
			boolean male) {
		double bodyWeight = person.getWeight();
		double liftWeight = lifting.getWeight();

		if (person.getMeasurementType() == MeasurementType.IMPERIAL) {
			bodyWeight = MeasurementConverter
					.getKilogramsFromPounds(bodyWeight);
			liftWeight = MeasurementConverter
					.getKilogramsFromPounds(liftWeight);
		}

		double coefficient = getCoefficient(male, person);

		double wilkScore = coefficient * liftWeight;
		return wilkScore;
	}

	public Double CalcBodyMass(Measurements person) {
		Double bodyWeight = person.getWeight();
		Double bodyHeight = person.getHeight();
		Double bmi = null;

		if (checkValid("Body Weight", bodyWeight)) {
			if (checkValid("Body Height", bodyHeight)) {
				if (person.getMeasurementType() == MeasurementType.IMPERIAL) {
					bodyWeight = MeasurementConverter
							.getKilogramsFromPounds(bodyWeight);
					bodyHeight = MeasurementConverter
							.getCentFromInch(bodyHeight);
				}
				// change to meters
				bodyHeight = bodyHeight / 100;

				bmi = bodyWeight / Math.pow(bodyHeight, 2);
			}
		}

		return bmi;
	}

	private double getCoefficient(boolean male, Measurements person) {
		double coefficient;
		if (male) {
			coefficient = mCo.getCoefficient(person);
		} else {
			coefficient = fCo.getCoefficient(person);
		}
		return coefficient;
	}

	private boolean checkValid(String type, Double val) {
		if (val != null) {
			return true;
		}
		// TODO refactor with LOGGER
		System.out.println(type
				+ " was assigned a null value, retry with a valid value");
		return false;
	}
}
