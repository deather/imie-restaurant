package com.imie.model;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ALIMENT")
public class Aliment extends Article {
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<Allergen> allergens;

	public Aliment() {
		super("", 0.0, 0);
	}

	public Aliment(String name, double prix, Set<Allergen> allergens, int tempsPreparation) {
		super(name, prix, tempsPreparation);
		this.allergens = allergens;
	}

	public Set<Allergen> getAllergens() {
		return allergens;
	}

	public void setAllergens(Set<Allergen> allergens) {
		this.allergens = allergens;
	}

	public String toString() {
		return MessageFormat.format(
				"| {0}. {1}. Aller.: {2} ({3}€) |",
				this.getId(), this.getName(), String.join(",", this.getAllergens().stream().map(Allergen::toString).collect(Collectors.toList())), this.getPrix()
		);
	}
}
