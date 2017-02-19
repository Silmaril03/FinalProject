package com.psu.SWENG500.Powerlifting.models;

/**
 * @author Jason
 * 
 *         Abstract Class that holds measurement info, this contains values for
 *         the height and weight, both may not need to be used depending on what
 *         calculation is being called. Also includes a measurement type for
 *         whether Imperial or Metric is used
 *
 */
public abstract class Measurements {
	private Double height;
	private Double weight;
	protected MeasurementType measurementType;

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public MeasurementType getMeasurementType() {
		return measurementType;
	}

}
