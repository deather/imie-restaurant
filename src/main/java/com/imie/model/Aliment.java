package com.imie.model;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Aliment extends Article {
	private List<Allergen> allergens;

	public Aliment(int id, String name, double prix, List<Allergen> allergens) {
		super(id, name, prix);
		this.allergens = allergens;
	}

	public List<Allergen> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}

	public String toString() {
		return MessageFormat.format(
				"| {0}. {1}. Aller.: {2} ({3}€) |",
				this.getId(), this.getName(), String.join(",", this.getAllergens().stream().map(Allergen::toString).collect(Collectors.toList())), this.getPrix()
		);
	}
}
