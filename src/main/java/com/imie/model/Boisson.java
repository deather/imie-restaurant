package com.imie.model;

import java.text.MessageFormat;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOISSON")
public class Boisson extends Article {
	@Column(name = "alcohol_percentage")
	private double alcoholPercentage;

	public Boisson() {
		super("", 0.0, 0);
	}

	public Boisson(String name, double prix, double alcoholPercentage, int tempsPreparation) {
		super(name, prix, tempsPreparation);
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
