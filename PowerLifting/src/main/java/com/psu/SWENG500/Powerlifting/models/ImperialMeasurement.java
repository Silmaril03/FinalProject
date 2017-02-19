package com.psu.SWENG500.Powerlifting.models;

/**
 * @author Jason
 *
 *         Imperial Measurement
 */
public class ImperialMeasurement extends Measurements {

	public ImperialMeasurement() {
		measurementType = MeasurementType.IMPERIAL;
	}

	public ImperialMeasurement(double height, double weight) {
		setHeight(height);
		setWeight(weight);
		measurementType = MeasurementType.IMPERIAL;
	}
}
