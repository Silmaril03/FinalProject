package com.psu.SWENG500.Powerlifting.ejbs.Controller;

import java.math.BigDecimal;

import com.psu.SWENG500.Powerlifting.models.FemaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.MaleCoefficient;
import com.psu.SWENG500.Powerlifting.models.Weight;

public class CalculatorController {

	MaleCoefficient mCo = new MaleCoefficient();
	FemaleCoefficient fCo = new FemaleCoefficient();
	
	public Double Calculate(){
		return null;
	}
	
	public Double CalcWilksScore(int bodyWeight, double bodyMass){
		return null;
	}
	
	public Double CalcBodyMass (){
		return null;
	}
	
	private double getCoefficient(boolean male, double weight, Weight weightType){
		double coefficient;
		if (male){
			coefficient = mCo.getCoefficient(weight, weightType);
		}
		else {
			coefficient = fCo.getCoefficient(weight, weightType);
		}
		return coefficient;
	}
}
