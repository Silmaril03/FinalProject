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
	private Double waist;
	private Double hip;
	private Double wrist;
	private Double forearm;
	private Double weight;
	protected MeasurementType measurementType;

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getHip() {
		return hip;
	}

	public void setHip(Double hip) {
		this.hip = hip;
	}

	public Double getWrist() {
		return wrist;
	}

	public void setWrist(Double wrist) {
		this.wrist = wrist;
	}

	public Double getForearm() {
		return forearm;
	}

	public void setForearm(Double forearm) {
		this.forearm = forearm;
	}

	public void setMeasurementType(MeasurementType measurementType) {
		this.measurementType = measurementType;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public MeasurementType getMeasurementType() {
		return measurementType;
	}

}
