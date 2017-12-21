package com.imie.model;

import java.text.MessageFormat;

public class Boisson extends Article {
	private double alcoholPercentage;

	public Boisson(int id, String name, double prix, double alcoholPercentage, int tempsPreparation) {
		super(id, name, prix, tempsPreparation);
		this.alcoholPercentage = alcoholPercentage;
	}

	public double getAlcoholPercentage() {
		return alcoholPercentage;
	}

	public void setAlcoholPercentage(double alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}

	public String toString() {
		return MessageFormat.format(
				"| {0}. {1}, {2}% ({3}€) |",
				this.getId(), this.getName(), this.getAlcoholPercentage(), this.getPrix()
		);
	}
}
