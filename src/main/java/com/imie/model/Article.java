package com.imie.model;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Inheritance
@DiscriminatorColumn(name = "dtype")
public abstract class Article {
	@Id
	@GeneratedValue(generator = "seq_article_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_article_id", sequenceName = "seq_article_id", allocationSize = 1)
	protected int id;

	@Column(nullable = false)
	protected String name;

	@Column(nullable = false)
	protected double prix;

	@Column(name = "temps_preparation", nullable = false)
	protected int tempsPreparation;

	protected Article(String name, double prix, int tempsPreparation) {
		this.name = name;
		this.prix = prix;
		this.tempsPreparation = tempsPreparation;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrix() {
		return prix;
	}

	public int getTempsPreparation() {
		return tempsPreparation;
	}

	public abstract String toString();
}
