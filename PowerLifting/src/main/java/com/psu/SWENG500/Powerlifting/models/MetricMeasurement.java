package com.psu.SWENG500.Powerlifting.models;

public class MetricMeasurement extends Measurements{

	public MetricMeasurement (){
		measurementType = MeasurementType.METRIC;
	}
	
	public MetricMeasurement(double height, double weight){
		setHeight(height);
		setWeight(weight);
		measurementType = MeasurementType.METRIC;
	}
}
