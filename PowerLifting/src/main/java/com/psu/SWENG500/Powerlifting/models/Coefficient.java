package com.psu.SWENG500.Powerlifting.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Coefficient {
	List<Double> variables = new ArrayList();
	private Double KILOGRAM = new Double (0.45359237);

	public Double getCoefficient(double weight, Weight weightType) {
		if(weightType == Weight.POUNDS){
			weight = KILOGRAM * weight;
		}
		
		Double total = new Double(0);

		int temp = 0;

		for (Double variable : variables) {
			if (temp == 0) {
				total += variable;
			} else {
				total += variable * Math.pow(weight, temp);
			}
			System.out.println(total);
			temp++;
		}
		total = 500 / total;
		System.out.println(total);
		return total;
	}
}
